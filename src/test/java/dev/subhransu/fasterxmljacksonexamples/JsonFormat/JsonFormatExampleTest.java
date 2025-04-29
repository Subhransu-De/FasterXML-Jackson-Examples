package dev.subhransu.fasterxmljacksonexamples.JsonFormat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.jayway.jsonpath.JsonPath;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class JsonFormatExampleTest {

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  @Autowired private MockMvc mvc;

  @Test
  void testJsonInclude() throws Exception {

    MvcResult result =
        mvc.perform(MockMvcRequestBuilders.get("/json-format"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.kolkataDateTime").exists())
            .andExpect(jsonPath("$.londonDateTime").exists())
            .andExpect(jsonPath("$.anotherDateTime").exists())
            .andExpect(jsonPath("$.anotherDateTime").isNumber())
            .andReturn();

    String responseBody = result.getResponse().getContentAsString();

    LocalDateTime kolkataTime =
        LocalDateTime.parse(JsonPath.read(responseBody, "$.kolkataDateTime"), formatter);
    LocalDateTime londonTime =
        LocalDateTime.parse(JsonPath.read(responseBody, "$.londonDateTime"), formatter);
    assertThat(kolkataTime)
        .as("Kolkata time should be 4 hours and 30 minutes ahead of London")
        .isAfter(londonTime)
        .isCloseTo(londonTime.plusHours(4).plusMinutes(30), within(1, ChronoUnit.HOURS));
  }
}
