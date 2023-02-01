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

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRep,
										JobRepository jobRep,
										UserJobRepository userJobRep,
										LocationRepository locRep,
										AuthenticationService authService){
		Location location1 = new Location(
				"c. grande",
				"universitario"

		);

		Location location2 = new Location(
				"patos",
				"qualquerbairro"

		);


		User user1 = new User(
				"Aires",
				"012345678910",
				"pedro.cabral",
				"pass",
				location1

		);

		User user2 = new User(
				"Rafael",
				"109876543210",
				"pedro.rafael",
				"pass",
				location2
		);

// (String name, String cpf, String email, String pswd, String city, String neighBorhood)
		return args -> {
			locRep.save(location1);
			locRep.save(location2);
			authService.register(user1);
			authService.register(user2);
		};
	}
}