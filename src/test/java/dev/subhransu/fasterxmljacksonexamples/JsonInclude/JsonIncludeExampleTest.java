package dev.subhransu.fasterxmljacksonexamples.JsonInclude;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class JsonIncludeExampleTest {

  @Autowired private MockMvc mvc;

  @Test
  public void testJsonIncludeExample() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/json-include"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.notNullField").value("Not Null Field"))
        .andExpect(jsonPath("$.nullField").doesNotExist());
  }
}
