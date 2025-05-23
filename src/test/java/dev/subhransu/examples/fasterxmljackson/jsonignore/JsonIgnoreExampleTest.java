package dev.subhransu.examples.fasterxmljackson.jsonignore;

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
class JsonIgnoreExampleTest {

  @Autowired private MockMvc mockMvc;

  @Test
  void shouldSucceed() throws Exception {
    mockMvc
        .perform(get("/json-ignore"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.visibleField").value("visible"))
        .andExpect(jsonPath("$.ignoredField").doesNotExist());
  }
}
