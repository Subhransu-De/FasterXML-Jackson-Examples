package dev.subhransu.examples.fasterxmljackson.jsonformat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

record JsonFormatExample(
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata") Instant kolkataDateTime,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/London") Instant londonDateTime,
    @JsonFormat(shape = JsonFormat.Shape.NUMBER) Instant anotherDateTime) {

  JsonFormatExample() {
    this(Instant.now(), Instant.now(), Instant.now());
  }
}

@RestController
class JsonFormatExampleController {
  @GetMapping("/json-format")
  public JsonFormatExample getJsonFormat() {
    return new JsonFormatExample();
  }
}
