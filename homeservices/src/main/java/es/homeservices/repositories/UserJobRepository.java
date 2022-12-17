package es.homeservices.repositories;

import es.homeservices.models.UserJob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJobRepository extends JpaRepository<UserJob, Long> {
    Optional<UserJob> findByUserId(Long userId);
}
