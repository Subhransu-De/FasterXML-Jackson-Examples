package dev.subhransu.examples.fasterxmljackson.jsonignore;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

record JsonIgnoreExample(String visibleField, @JsonIgnore String ignoredField) {}

@RestController
class JsonIgnoreExampleController {
  @GetMapping("/json-ignore")
  public JsonIgnoreExample getJsonIgnoreExample() {
    return new JsonIgnoreExample("visible", "ignored");
  }
}
