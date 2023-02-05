package es.homeservices.services;

import es.homeservices.DTO.*;
import es.homeservices.exception.JobNotFoundException;
import es.homeservices.exception.UserJobNotFoundException;
import es.homeservices.exception.UserNotFoundException;
import es.homeservices.models.Job;
import es.homeservices.models.Location;
import es.homeservices.models.User;
import es.homeservices.models.UserJob;
import es.homeservices.models.enumeration.Tag;
import es.homeservices.repositories.JobRepository;
import es.homeservices.repositories.LocationRepository;
import es.homeservices.repositories.UserJobRepository;
import es.homeservices.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserJobServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserJobRepository userJobRepository;

    @Mock
    private LocationRepository locationRepository;

    @Mock
    private JobRepository jobRepository;

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

    @Test
    public void testListUserJobSuccess() {
        User user = new User("Test", "12345678900", "testuser@email.com", "12345678");
        userRepository.save(user);

        Job job = new Job("Test Job", "Test Description", "1234567890",
                new Location("Test City", "Test Neighborhood"), 100.0);
        UserJob userJob = new UserJob(user);
        userJobRepository.save(userJob);

        JobListResponseDTO jobListResponse = userJobService.listUserJob("12345678900");
        assertNotNull(jobListResponse);
        List<Job> jobs = jobListResponse.getJobs();
        assertEquals(1, jobs.size());
        assertEquals("Test Job", jobs.get(0).getTitle());
        assertEquals("Test Description", jobs.get(0).getDescription());
        assertEquals("1234567890", jobs.get(0).getCel());
        assertEquals("Test City", jobs.get(0).getLocation().getCity());
        assertEquals("Test Neighborhood", jobs.get(0).getLocation().getNeighborhood());
        assertEquals(100.0, jobs.get(0).getValue(), 0.0);
    }

    @Test
    public void testListUserJobNoUserJobFound() {
        User user = new User("John Doe", "12345678900", "john.doe@example.com", "12345678");
        when(userRepository.findBycpf("12345678900")).thenReturn(Optional.of(user));
        when(userJobRepository.findByUserId(user.getId())).thenReturn(Optional.empty());

        JobListResponseDTO response = userJobService.listUserJob(user);
        assertNotNull(response);
        assertEquals(0, response.getJobs().size());
    }

    @Test
    public void testEditJobSuccess() {
        String userCpf = "12345678900";
        User user = new User("test", userCpf, "test@test.com", "12345678");
        userRepository.save(user);

        UserJob userJob = new UserJob(user);
        userJobRepository.save(userJob);

        Location location = new Location("city", "neighborhood");
        locationRepository.save(location);

        Job job = new Job("title", "description", "cel", location, 10.0);
        job.setId(1L);
        userJob.addJob(job);
        jobRepository.save(job);

        EditJobRequestDTO jobDTO = new EditJobRequestDTO();
        jobDTO.setUserCpf(userCpf);
        jobDTO.setJobId(1L);
        jobDTO.setTitle("new title");
        jobDTO.setDescription("new description");
        jobDTO.setTag(Tag.FAXINA);
        jobDTO.setValue(20.0);
        jobDTO.setCity("new city");
        jobDTO.setNeighborhood("new neighborhood");

        JobResponseDTO response = userJobService.editJob(jobDTO);

        assertEquals(1L, response.getJobId());
        assertEquals("new title", response.getTitle());
    }

    @Test
    public void testEditJobUserNotFound() {
        EditJobRequestDTO jobDTO = new EditJobRequestDTO();
        jobDTO.setUserCpf("12345678900");
        jobDTO.setJobId(1L);

        assertThrows(UserNotFoundException.class, () -> userJobService.editJob(jobDTO));
    }

    @Test
    public void testEditJobUserJobNotFound() {
        String userCpf = "12345678900";
        User user = new User("test", userCpf, "test@test.com", "12345678");
        userRepository.save(user);

        EditJobRequestDTO jobDTO = new EditJobRequestDTO();
        jobDTO.setUserCpf(userCpf);
        jobDTO.setJobId(1L);

        assertThrows(UserJobNotFoundException.class, () -> userJobService.editJob(jobDTO));
    }

    @Test
    public void testEditJobJobNotFound() {
        String userCpf = "12345678900";
        User user = new User("test", userCpf, "test@test.com", "12345678");
        userRepository.save(user);

        UserJob userJob = new UserJob(user);
        userJobRepository.save(userJob);

        EditJobRequestDTO jobDTO = new EditJobRequestDTO();
        jobDTO.setUserCpf(userCpf);
        jobDTO.setJobId(1L);

        assertThrows(JobNotFoundException.class, () -> userJobService.editJob(jobDTO));
    }

    @Test
    public void testGetUserJobSuccess() {
        User user = new User("John Doe", "12345678900", "johndoe@email.com", "12345678");
        user = userRepository.save(user);

        Location location = new Location("city", "neighborhood");
        locationRepository.save(location);

        Job job = new Job("Job title", "Job description", "cel", location, 200.0);
        job = jobRepository.save(job);

        SingleJobResponseDTO response = userJobService.getUserJob("12345678900", job.getId());

        assertEquals(job.getId(), response.getId());
        assertEquals(job.getTitle(), response.getTitle());
        assertEquals(job.getDescription(), response.getDescription());
    }

    @Test
    public void testGetUserJobUserNotFound() {
        userJobService.getUserJob("12345678901", 1L);
    }

    @Test
    public void testGetUserJobUserJobNotFound() {
        User user = new User("John Doe", "12345678900", "johndoe@email.com", "12345678");
        user = userRepository.save(user);

        userJobService.getUserJob("12345678900", 1L);
    }

    @Test
    public void testGetUserJobJobNotFound() {
        User user = new User("John Doe", "12345678900", "johndoe@email.com", "12345678");
        user = userRepository.save(user);
        UserJob userJob = new UserJob(user);
        userJob = userJobRepository.save(userJob);

        userJobService.getUserJob("12345678900", 1L);
    }

    @Test
    public void testDeleteJobSuccess() throws Exception {
        User user = new User("User", "12345678900", "user@email.com", "12345678");
        userRepository.save(user);

        UserJob userJob = new UserJob(user);
        userJobRepository.save(userJob);

        Job job = new Job("Title", "Description", "Tag", new Location("City", "Neighborhood"), 100);
        jobRepository.save(job);
        userJob.addJob(job);
        userJobRepository.save(userJob);

        DeletedJobResponseDTO deleted = userJobService.deleteJob("12345678900", job.getId());

        assertEquals(user, deleted.getUser());
        assertEquals(job, deleted.getDeleted());
        assertFalse(userJobRepository.findByUserId(user.getId()).get().getJobs().containsKey(job.getId()));
        assertFalse(jobRepository.existsById(job.getId()));
    }

    @Test
    public void testDeleteJobUserNotFound() throws Exception {
        userJobService.deleteJob("00000000000", 1L);
    }

    @Test
    public void testDeleteJobUserJobNotFound() throws Exception {
        User user = new User("User", "12345678900", "user@email.com", "12345678");
        userRepository.save(user);

        userJobService.deleteJob("12345678900", 1L);
    }

    @Test
    public void testDeleteJobJobNotFound() throws Exception {
        User user = new User("User", "12345678900", "user@email.com", "12345678");
        userRepository.save(user);

        UserJob userJob = new UserJob(user);
        userJobRepository.save(userJob);

        userJobService.deleteJob("12345678900", 1L);
    }
}
