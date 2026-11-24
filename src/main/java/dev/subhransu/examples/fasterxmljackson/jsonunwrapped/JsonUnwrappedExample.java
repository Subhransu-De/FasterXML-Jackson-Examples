package dev.subhransu.examples.fasterxmljackson.jsonunwrapped;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

record JsonUnwrappedExample(String name, @JsonUnwrapped Address address) {}

record Address(String street, String city) {}

@RestController
class JsonUnwrappedExampleController {
  @PostMapping("/json-unwrapped")
  public JsonUnwrappedExample unwrap(@RequestBody JsonUnwrappedExample example) {
    return example;
  }
}
