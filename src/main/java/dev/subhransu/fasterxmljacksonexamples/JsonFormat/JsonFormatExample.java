package dev.subhransu.fasterxmljacksonexamples.JsonFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

record JsonFormatExample(
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata") Date kolkataDateTime,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/London") Date londonDateTime,
    @JsonFormat(shape = JsonFormat.Shape.NUMBER) Date anotherDateTime) {

  JsonFormatExample() {
    this(new Date(), new Date(), new Date());
  }
}

@RestController
class JsonFormatExampleController {
  @GetMapping("/json-format")
  public JsonFormatExample format() {
    return new JsonFormatExample();
  }
}
