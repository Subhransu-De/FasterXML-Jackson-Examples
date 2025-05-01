package dev.subhransu.fasterxmljacksonexamples.CustomSerializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.IOException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

class GreetingSerializer extends JsonSerializer<JsonSerializeExample> {
  @Override
  public void serialize(
      JsonSerializeExample value, JsonGenerator gen, SerializerProvider serializers)
      throws IOException {
    gen.writeStartObject();
    gen.writeFieldName("greetings");
    gen.writeString("Hello, " + value.name());
    gen.writeEndObject();
  }
}

@JsonSerialize(using = GreetingSerializer.class)
record JsonSerializeExample(String name) {}

@RestController
class CustomSerializerExampleController {

  @PostMapping("/json-serialize")
  public JsonSerializeExample getJsonSerialize(
      @RequestBody JsonSerializeExample jsonSerializeExample) {
    return jsonSerializeExample;
  }
}
