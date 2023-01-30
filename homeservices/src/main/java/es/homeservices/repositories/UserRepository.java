package es.homeservices.repositories;

import es.homeservices.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findBycpf(String cpf);
    Optional<User> findByEmail(String email);
}
