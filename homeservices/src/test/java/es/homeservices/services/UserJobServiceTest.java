package es.homeservices.services;

import es.homeservices.DTO.JobRequestDTO;
import es.homeservices.DTO.JobResponseDTO;
import es.homeservices.exception.UserNotFoundException;
import es.homeservices.models.User;
import es.homeservices.models.enumeration.Tag;
import es.homeservices.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserJobServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserJobServiceImpl userJobService;

    @Test
    public void testCreateJobSuccess() {
        User user = new User("Test", "12345678900", "testuser@email.com", "12345678");
        when(userRepository.findBycpf("12345678900")).thenReturn(Optional.of(user));

        JobRequestDTO jobRequest = new JobRequestDTO(
                "12345678900",
                "Test Job",
                "Test Description",
                Tag.FAXINA,
                "1234567890",
                "Test City",
                "Test Neighborhood",
                100.0
        );
        JobResponseDTO jobResponse = userJobService.createJob(jobRequest);
        assertNotNull(jobResponse);
        assertEquals("Test Job", jobResponse.getTitle());
        assertEquals(1, jobResponse.getJobId(), 0.0);
    }

    @Test(expected = UserNotFoundException.class)
    public void testCreateJobUserNotFound() {
        when(userRepository.findBycpf("12345678900")).thenReturn(Optional.empty());

        JobRequestDTO jobRequest = new JobRequestDTO(
                "12345678900",
                "Test Job",
                "Test Description",
                Tag.FAXINA,
                "1234567890",
                "Test City",
                "Test Neighborhood",
                100.0
        );
        userJobService.createJob(jobRequest);
    }
}
