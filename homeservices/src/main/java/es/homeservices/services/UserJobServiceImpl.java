package es.homeservices.services;

import es.homeservices.DTO.*;
import es.homeservices.exception.UserJobNotFoundException;
import es.homeservices.exception.UserNotFoundException;
import es.homeservices.models.Job;
import es.homeservices.models.Location;
import es.homeservices.models.User;
import es.homeservices.models.UserJob;
import es.homeservices.repositories.JobRepository;
import es.homeservices.repositories.LocationRepository;
import es.homeservices.repositories.UserJobRepository;
import es.homeservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserJobServiceImpl implements UserJobService {

    private final UserJobRepository userJobRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    @Autowired
    public UserJobServiceImpl(UserJobRepository userJobRepository, LocationRepository locationRepository, UserRepository userRepository, JobRepository jobRepository) {
        this.userJobRepository = userJobRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    public JobResponseDTO createJob(JobRequestDTO jobDTO) {
        Optional<User> userOp = userRepository.findBycpf(jobDTO.getUserCpf());
        User user = userOp.orElseThrow(() -> new UserNotFoundException(jobDTO.getUserCpf()));

        Location location = new Location(jobDTO.getCity(), jobDTO.getNeighborhood());
        locationRepository.save(location);

        Job job = new Job(
                jobDTO.getTitle(),
                jobDTO.getDescription(),
                jobDTO.getCel(),
                location,
                jobDTO.getValue()
        );
        jobRepository.save(job);

        Optional<UserJob> userJobOp = userJobRepository.findByUserId(user.getId());
        if(userJobOp.isPresent()) {
            userJobOp.get().addJob(job);
            userJobRepository.save(userJobOp.get());
        } else {
            UserJob userJob = new UserJob(userOp.get());
            userJob.addJob(job);
            userJobRepository.save(userJob);
        }
        return new JobResponseDTO(job);
    }

    @Override
    public JobListResponseDTO listUserJob(String cpf) {
        Optional<User> userOp = userRepository.findBycpf(cpf);
        User user = userOp.orElseThrow(() -> new UserNotFoundException(cpf));

        Optional<UserJob> userJobOp = userJobRepository.findByUserId(user.getId());
        UserJob userJob = userJobOp.orElseThrow(() -> new UserJobNotFoundException(user.getId()));
        return new JobListResponseDTO(new ArrayList<Job>(userJob.getJobs().values()));
    }

    @Override
    public JobResponseDTO editJob(EditJobRequestDTO jobDTO) {
        Optional<User> userOp = userRepository.findBycpf(jobDTO.getUserCpf());
        User user = userOp.orElseThrow(() -> new UserNotFoundException(jobDTO.getUserCpf()));

        Optional<UserJob> userJobOp = userJobRepository.findByUserId(userOp.get().getId());
        UserJob userJob = userJobOp.orElseThrow(() -> new UserJobNotFoundException(user.getId()));

        Job job = userJob.getJob(jobDTO.getJobId());

        if(jobDTO.getTitle() != null){job.setTitle(jobDTO.getTitle());}
        if(jobDTO.getDescription() != null){job.setDescription(jobDTO.getDescription());}
        if(jobDTO.getTag() != null){job.setTag(jobDTO.getTag());}
        if(jobDTO.getValue() != -1){job.setValue(jobDTO.getValue());}
        if(jobDTO.getCity() != null && jobDTO.getNeighborhood() != null){
            Location location = new Location(jobDTO.getCity(), jobDTO.getNeighborhood());
            locationRepository.save(location);
            job.setLocation(location);
        }
        jobRepository.save(job);

        return new JobResponseDTO(job);
    }

    @Override
    public SingleJobResponseDTO getUserJob(String cpf, Long jobId) {
        Optional<User> userOp = userRepository.findBycpf(cpf);
        User user = userOp.orElseThrow(() -> new UserNotFoundException(cpf));

        Optional<UserJob> userJobOp = userJobRepository.findByUserId(userOp.get().getId());
        UserJob userJob = userJobOp.orElseThrow(() -> new UserJobNotFoundException(user.getId()));

        return new SingleJobResponseDTO(userJob.getJob(jobId));
    }

    @Override
    public DeletedJobResponseDTO deleteJob(String cpf, Long jobId) {
        Optional<User> userOp = userRepository.findBycpf(cpf);
        User user = userOp.orElseThrow(() -> new UserNotFoundException(cpf));

        Optional<UserJob> userJobOp = userJobRepository.findByUserId(userOp.get().getId());
        UserJob userJob = userJobOp.orElseThrow(() -> new UserJobNotFoundException(user.getId()));

        Job job = userJob.getJob(jobId);
        DeletedJobResponseDTO deleted = new DeletedJobResponseDTO(user, job);
        userJob.deleteJob(jobId);
        userJobRepository.save(userJob);
        jobRepository.delete(job);
        return deleted;
    }
}
