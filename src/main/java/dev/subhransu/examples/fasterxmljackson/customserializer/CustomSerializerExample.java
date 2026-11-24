package dev.subhransu.examples.fasterxmljackson.customserializer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;
import tools.jackson.databind.annotation.JsonSerialize;

class GreetingSerializer extends ValueSerializer<JsonSerializeExample> {
  @Override
  public void serialize(JsonSerializeExample value, JsonGenerator gen, SerializationContext ctxt) {
    gen.writeStartObject();
    gen.writeName("greetings");
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
