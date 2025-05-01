package dev.subhransu.examples.fasterxmljackson.jsonproperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class JsonPropertyExampleController {
  @GetMapping("/json-property")
  public JsonPropertyExample getJsonPropertyExample() {
    return new JsonPropertyExample("John Doe");
  }
}

record JsonPropertyExample(@JsonProperty("first_name") String firstName) {}
