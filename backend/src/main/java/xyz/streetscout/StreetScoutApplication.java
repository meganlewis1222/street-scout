package xyz.streetscout;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
    info = @Info(
        title = "Street Scout Application REST API Documentation",
        description = "Backend service to find and manage local Food vendors",
        version = "v1",
        contact = @Contact(
            name = "Street Scout Dev Team",
            email = "contact@streetscout.xyz",
            url = "https://streetscout.xyz"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0"
        )
    ),
    externalDocs = @ExternalDocumentation(
        description = "Street Scout",
        url = "https://github.com/aye-candy/street-scout"
    ))
@SpringBootApplication
public class StreetScoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreetScoutApplication.class, args);
    }

}
