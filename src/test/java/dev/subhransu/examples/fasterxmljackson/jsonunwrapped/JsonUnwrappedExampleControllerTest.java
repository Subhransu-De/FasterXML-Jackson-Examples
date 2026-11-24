package dev.subhransu.examples.fasterxmljackson.jsonunwrapped;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class JsonUnwrappedExampleControllerTest {

  @Autowired private MockMvc mockMvc;

  @Test
  void postJsonUnwrapped() throws Exception {
    String requestBody =
        """
        {
          "name": "A good name",
          "street": "A nice street",
          "city": "A peaceful city"
        }
        """;

    mockMvc
        .perform(
            post("/json-unwrapped").contentType(MediaType.APPLICATION_JSON).content(requestBody))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("A good name"))
        .andExpect(jsonPath("$.street").value("A nice street"))
        .andExpect(jsonPath("$.city").value("A peaceful city"));
  }
}
