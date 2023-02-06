package es.homeservices;

import es.homeservices.auth.AuthenticationService;
import es.homeservices.models.Location;
import es.homeservices.models.User;
import es.homeservices.repositories.JobRepository;
import es.homeservices.repositories.LocationRepository;
import es.homeservices.repositories.UserJobRepository;
import es.homeservices.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@SpringBootApplication(scanBasePackages = "es.homeservices")
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class HomeservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeservicesApplication.class, args);
	}


}