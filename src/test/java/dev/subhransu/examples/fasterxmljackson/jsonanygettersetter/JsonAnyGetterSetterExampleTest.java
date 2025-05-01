package dev.subhransu.examples.fasterxmljackson.jsonanygettersetter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class JsonAnyGetterSetterExampleTest {

  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;

  @Test
  void testAnyGetterSetter() throws Exception {
    JsonAnyGetterSetterExample input =
        new JsonAnyGetterSetterExample(
            "John Doe",
            objectMapper.readValue(
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
                objectMapper
                    .getTypeFactory()
                    .constructMapType(Map.class, String.class, Object.class)));

    mockMvc
        .perform(
            post("/json-any-getter-setter")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(input)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("John Doe"))
        .andExpect(jsonPath("$.age").value(30))
        .andExpect(jsonPath("$.city").value("New York"))
        .andExpect(jsonPath("$.address.street").value("123 Main St"))
        .andExpect(jsonPath("$.address.zip").value("10001"));
  }
}
