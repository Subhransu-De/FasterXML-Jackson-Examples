package dev.subhransu.fasterxmljacksonexamples.JsonTypeSubType;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

interface Device {}

record Computer<T extends Device>(
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            property = "type",
            include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
        @JsonSubTypes({
          @JsonSubTypes.Type(value = Laptop.class, name = "Laptop"),
          @JsonSubTypes.Type(value = Desktop.class, name = "Desktop")
        })
        T device) {}

record Laptop(String battery) implements Device {}

record Desktop(String monitor) implements Device {}

@RestController
class JsonTypeSubTypeExampleController {
  @PostMapping("/json-type")
  public String jsonType(@RequestBody Computer<? extends Device> computer) {
    return switch (computer.device()) {
      case Laptop laptop -> "It is a Laptop!";
      case Desktop desktop -> "It is a Desktop!";
      default -> "Unknown device!";
    };
  }
}
