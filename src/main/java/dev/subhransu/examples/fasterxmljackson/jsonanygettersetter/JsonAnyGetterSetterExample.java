package dev.subhransu.examples.fasterxmljackson.jsonanygettersetter;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class JsonAnyGetterSetterController {
  @PostMapping("/json-any-getter-setter")
  public JsonAnyGetterSetterExample anyGetterSetter(@RequestBody JsonAnyGetterSetterExample data) {
    return data;
  }
}

record JsonAnyGetterSetterExample(String name, Map<String, Object> properties) {
  @JsonAnyGetter
  public Map<String, Object> getProperties() {
    return properties;
  }

  @JsonAnySetter
  public void setProperty(String name, Object value) {
    properties.put(name, value);
  }
}
