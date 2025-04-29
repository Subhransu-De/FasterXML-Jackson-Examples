package dev.subhransu.fasterxmljacksonexamples.JsonUnwrapped;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class JsonUnwrappedExampleControllerTest {

  @Autowired private MockMvc mockMvc;

  @Test
  void getJsonUnwrapped() throws Exception {
    mockMvc
        .perform(get("/json-unwrapped"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("A good name"))
        .andExpect(jsonPath("$.street").value("A nice street"))
        .andExpect(jsonPath("$.city").value("A peaceful city"));
  }
}
