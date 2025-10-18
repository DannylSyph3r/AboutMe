package dev.slethware.aboutme;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				contact = @Contact(
						name = "Akinola Daniel",
						email = "danieleakinola@gmail.com"
				),
				description = "About me",
				title = "AboutMe API",
				version = "1.0"
		)
)
@SpringBootApplication
public class AboutmeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AboutmeApiApplication.class, args);
	}
}