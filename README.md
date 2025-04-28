# FasterXML Jackson Examples

This project demonstrates various FasterXML Jackson annotations in a Spring Boot application. It showcases common JSON serialization and deserialization scenarios using Jackson annotations.

## Features

The project includes examples of the following Jackson annotations:

1. **Basic JSON Serialization** (`/hello`)
   - Simple example of JSON response using Spring RestController

2. **@JsonIgnore** (`/jsonIgnore`)
   - Demonstrates how to exclude fields from JSON serialization
   - Example shows a field marked with `@JsonIgnore` being excluded from the response

3. **@JsonProperty** (`/jsonProperty`)
   - Shows how to customize field names in JSON output
   - Converts camelCase Java field names to snake_case JSON properties

4. **@JsonInclude** (`/jsonInclude`)
   - Demonstrates how to control which fields are included in JSON output
   - Example shows excluding null fields from the response

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
2. `GET /jsonIgnore` - Demonstrates @JsonIgnore annotation
3. `GET /jsonProperty` - Shows @JsonProperty annotation usage
4. `GET /jsonInclude` - Demonstrates @JsonInclude annotation

## Technologies Used

- Spring Boot
- FasterXML Jackson
- JUnit 5
- Spring Test
