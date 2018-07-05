package io.github.kjm015.kylenewer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class KyleNewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyleNewerApplication.class, args);
		log.info("App now running!");
	}
}
