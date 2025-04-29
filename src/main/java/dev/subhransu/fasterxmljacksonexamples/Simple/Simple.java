package dev.subhransu.fasterxmljacksonexamples.Simple;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Simple {
  @GetMapping("/hello")
  public Map<String, String> helloWorld() {
    return Map.of("message", "Hello, world!");
  }
}
