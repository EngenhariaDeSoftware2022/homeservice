package es.homeservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "es.homeservices")
public class HomeservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeservicesApplication.class, args);
	}

}