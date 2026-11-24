package dev.subhransu.examples.fasterxmljackson.jsonanygettersetter;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

record JsonAnyGetterSetterExample(
    String name, @JsonAnyGetter @JsonAnySetter Map<String, Object> properties) {}

@RestController
class JsonAnyGetterSetterController {
  @PostMapping("/json-any-getter-setter")
  public JsonAnyGetterSetterExample anyGetterSetter(@RequestBody JsonAnyGetterSetterExample data) {
    return data;
  }
}
