package info.svetlik.pia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import info.svetlik.pia.configuration.AppConfig;

@SpringBootApplication
public class PiaJdbc implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PiaJdbc.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
