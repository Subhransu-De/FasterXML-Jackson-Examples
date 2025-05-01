package dev.subhransu.fasterxmljacksonexamples.JsonTypeSubType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ComputerTest {

  @Autowired private MockMvc mockMvc;

  @Autowired private ObjectMapper objectMapper;

  private static Stream<Arguments> deviceProvider() {
    return Stream.of(
        Arguments.of("Laptop", new Laptop("60Wh"), "It is a Laptop!"),
        Arguments.of("Desktop", new Desktop("32 inch"), "It is a Desktop!"));
  }

  @ParameterizedTest
  @MethodSource("deviceProvider")
  void shouldSucceed(String type, Device device, String expectedResponse) throws Exception {
    String requestBody =
        """
            {
                "type": "%s",
                "device": %s
            }"""
            .formatted(type, objectMapper.writeValueAsString(device));

    mockMvc
        .perform(post("/json-type").contentType(MediaType.APPLICATION_JSON).content(requestBody))
        .andExpect(status().isOk())
        .andExpect(content().string(expectedResponse));
  }
}
