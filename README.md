[![Build Status](https://github.com/Subhransu-De/FasterXML-Jackson-Examples/actions/workflows/pipeline.yml/badge.svg?branch=main)](https://github.com/Subhransu-De/FasterXML-Jackson-Examples/actions/workflows/pipeline.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Subhransu-De_FasterXML-Jackson-Examples&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Subhransu-De_FasterXML-Jackson-Examples)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Subhransu-De_FasterXML-Jackson-Examples&metric=bugs)](https://sonarcloud.io/summary/new_code?id=Subhransu-De_FasterXML-Jackson-Examples)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=Subhransu-De_FasterXML-Jackson-Examples&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=Subhransu-De_FasterXML-Jackson-Examples)

# FasterXML Jackson Examples

This project demonstrates various FasterXML Jackson annotations in a Spring Boot application. It showcases common JSON
serialization and deserialization scenarios using Jackson annotations.

## Features

The project includes examples of the following Jackson annotations:

1. **Basic JSON Serialization** (`/hello`)
    - Simple example of JSON response using Spring RestController

2. **@JsonIgnore** (`/json-ignore`)
    - Demonstrates how to exclude fields from JSON serialization
    - Example shows a field marked with `@JsonIgnore` being excluded from the response

3. **@JsonProperty** (`/json-property`)
    - Shows how to customize field names in JSON output
    - Converts camelCase Java field names to snake_case JSON properties

4. **@JsonInclude** (`/json-include`)
    - Demonstrates how to control which fields are included in JSON output
    - Example shows excluding null fields from the response

5. **@JsonFormat** (`/json-format`)
    - Shows how to format fields like dates during serialization
    - Example demonstrates formatting dates with specific patterns and timezones

6. **@JsonUnwrapped** (`/json-unwrapped`)
    - Demonstrates how to flatten nested objects during serialization
    - Example shows unwrapping an `Address` object into the main JSON structure

7. **@JsonAnyGetter and @JsonAnySetter** (`/json-any-getter-setter`)
    - Shows how to handle arbitrary key-value pairs during serialization and deserialization
    - Example demonstrates serializing a map into top-level properties and deserializing unknown properties into a map

8. **@JsonTypeInfo and @JsonSubTypes** (`/json-type`)
    - Demonstrates handling polymorphic types during serialization and deserialization
    - Example shows serializing and deserializing different `Device` subtypes (`Laptop`, `Desktop`) based on a `type` field

9. **@JsonSerialize** (`/json-serialize`)
    - Shows how to use a custom serializer for a specific type
    - Example demonstrates using a `GreetingSerializer` to customize the JSON output

## Requirements

- Java 21
- Spring Boot 3.4.5

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
2. `GET /json-ignore` - Demonstrates @JsonIgnore annotation
3. `GET /json-property` - Shows @JsonProperty annotation usage
4. `GET /json-include` - Demonstrates @JsonInclude annotation
5. `GET /json-format` - Demonstrates @JsonFormat annotation
6. `GET /json-unwrapped` - Demonstrates @JsonUnwrapped annotation
7. `POST /json-any-getter-setter` - Demonstrates @JsonAnyGetter and @JsonAnySetter annotations
8. `POST /json-type` - Demonstrates @JsonTypeInfo and @JsonSubTypes annotations
9. `POST /json-serialize` - Demonstrates @JsonSerialize with a custom serializer

## Technologies Used

- Spring Boot
- FasterXML Jackson
- JUnit 5
- Spring Test
