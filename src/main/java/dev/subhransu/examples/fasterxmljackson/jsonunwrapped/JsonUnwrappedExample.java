package dev.subhransu.examples.fasterxmljackson.jsonunwrapped;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

record JsonUnwrappedExample(String name, @JsonUnwrapped Address address) {}

record Address(String street, String city) {}

@RestController
class JsonUnwrappedExampleController {
  @GetMapping("/json-unwrapped")
  public JsonUnwrappedExample getJsonUnwrapped() {
    return new JsonUnwrappedExample("A good name", new Address("A nice street", "A peaceful city"));
  }
}
