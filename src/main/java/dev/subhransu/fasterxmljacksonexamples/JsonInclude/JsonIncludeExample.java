package dev.subhransu.fasterxmljacksonexamples.JsonInclude;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@JsonInclude(JsonInclude.Include.NON_NULL)
record JsonIncludeExample(String nullField, String notNullField) {}

@RestController
class JsonIncludeExampleController {
  @GetMapping("/json-include")
  public JsonIncludeExample getJsonIncludeExample() {
    return new JsonIncludeExample(null, "Not Null Field");
  }
}
