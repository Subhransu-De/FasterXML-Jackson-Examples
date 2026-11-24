[![Build Status](https://github.com/Subhransu-De/FasterXML-Jackson-Examples/actions/workflows/pipeline.yml/badge.svg?branch=main)](https://github.com/Subhransu-De/FasterXML-Jackson-Examples/actions/workflows/pipeline.yml)

# FasterXML Jackson Examples

This project demonstrates common Jackson annotations in a Spring Boot 4 (Jackson 3) application, with controller endpoints and `MockMvc` tests for each annotation.

Companion article: [Jackson Annotations in Spring Boot 4](https://subhransu.de/articles/fine-grained-json-control-leveraging-jackson-annotations-in-spring-boot/)

## Features

The project includes examples of the following Jackson annotations:

1. **Basic JSON Serialization** (`/hello`)
   - Simple JSON response using a Spring `@RestController`.
2. **@JsonProperty** (`/json-property`)
   - Customizes JSON field names during serialization and deserialization (`camelCase` Java fields mapped to `snake_case` JSON).
3. **@JsonIgnore** (`/json-ignore`)
   - Excludes a field from JSON serialization and deserialization.
4. **@JsonInclude** (`/json-include`)
   - Controls which fields are included in JSON output based on their values, such as omitting `null` fields.
5. **@JsonFormat** (`/json-format`)
   - Formats `Instant` fields with custom patterns, time zones, and numeric output.
6. **@JsonUnwrapped** (`/json-unwrapped`)
   - Flattens a nested `Address` record into its parent JSON object during both deserialization and serialization.
7. **@JsonAnyGetter and @JsonAnySetter** (`/json-any-getter-setter`)
   - Serializes map entries as top-level JSON properties and collects unknown incoming properties into a `Map` record component.
8. **@JsonTypeInfo and @JsonSubTypes** (`/json-type`)
   - Handles polymorphic `Device` subtypes (`Laptop`, `Desktop`) using an external `type` discriminator field.
9. **@JsonSerialize** (`/json-serialize`)
   - Uses a custom Jackson 3 `ValueSerializer` (`GreetingSerializer`) with `tools.jackson.databind.annotation.JsonSerialize`.

## Requirements

- Java 21
- Spring Boot 4.1.2 (Jackson 3.1.7)

## Running the Application

You can run the application using the Maven wrapper:

```bash
./mvnw spring-boot:run
```

## Testing

To run the tests:

```bash
./mvnw test
```

## Endpoints

1. `GET /hello` - Returns a simple JSON message
2. `GET /json-property` - Demonstrates `@JsonProperty`
3. `GET /json-ignore` - Demonstrates `@JsonIgnore`
4. `GET /json-include` - Demonstrates `@JsonInclude`
5. `GET /json-format` - Demonstrates `@JsonFormat`
6. `POST /json-unwrapped` - Demonstrates `@JsonUnwrapped`
7. `POST /json-any-getter-setter` - Demonstrates `@JsonAnyGetter` and `@JsonAnySetter`
8. `POST /json-type` - Demonstrates `@JsonTypeInfo` and `@JsonSubTypes`
9. `POST /json-serialize` - Demonstrates `@JsonSerialize` with a custom `ValueSerializer`

## Technologies Used

- Spring Boot 4
- Jackson 3
- JUnit 5
- MockMvc
- AssertJ
