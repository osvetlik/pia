package info.svetlik.pia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import info.svetlik.pia.configuration.AppConfig;

@SpringBootApplication
@Import(AppConfig.class)
public class PiaJpa {

	public static void main(String[] args) {
		SpringApplication.run(PiaJpa.class, args);
	}

}
