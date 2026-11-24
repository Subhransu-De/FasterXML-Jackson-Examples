package dev.subhransu.examples.fasterxmljackson.jsonanygettersetter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.json.JsonMapper;

@SpringBootTest
@AutoConfigureMockMvc
class JsonAnyGetterSetterExampleTest {

  @Autowired private MockMvc mockMvc;
  @Autowired private JsonMapper jsonMapper;

  @Test
  void testAnyGetterSetter() throws Exception {
    JsonAnyGetterSetterExample input =
        new JsonAnyGetterSetterExample(
            "John Doe",
            jsonMapper.readValue(
                """
                {
                  "age": 30,
                  "city": "New York",
                  "address": {
                    "street": "123 Main St",
                    "zip": "10001"
                  }
                }
                """,
                jsonMapper
                    .getTypeFactory()
                    .constructMapType(Map.class, String.class, Object.class)));

    mockMvc
        .perform(
            post("/json-any-getter-setter")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper.writeValueAsString(input)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("John Doe"))
        .andExpect(jsonPath("$.age").value(30))
        .andExpect(jsonPath("$.city").value("New York"))
        .andExpect(jsonPath("$.address.street").value("123 Main St"))
        .andExpect(jsonPath("$.address.zip").value("10001"))
        .andExpect(jsonPath("$.properties").doesNotExist());
  }
}
