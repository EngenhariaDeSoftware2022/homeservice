package es.homeservices.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.homeservices.DTO.SingleJobResponseDTO;
import es.homeservices.exception.JobNotFoundException;
import es.homeservices.exception.UserJobNotFoundException;
import es.homeservices.exception.UserNotFoundException;
import es.homeservices.models.Job;
import es.homeservices.models.User;
import es.homeservices.models.UserJob;
import es.homeservices.models.enumeration.Tag;
import es.homeservices.repositories.JobRepository;
import es.homeservices.repositories.UserJobRepository;
import es.homeservices.repositories.UserRepository;

@Service
public class JobServiceImpl implements JobService {
	
	private final JobRepository jobRepository;
	private final UserJobRepository userJobRepository;
	private final UserRepository userRepository;
	
	@Autowired
	public JobServiceImpl(JobRepository jobRepository, UserJobRepository userJobRepository, UserRepository userRepository) {
		this.jobRepository = jobRepository;
		this.userJobRepository = userJobRepository;
		this.userRepository = userRepository;
	}
	
	public Collection<Job> listJobs() {
		return this.jobRepository.findAll();
	}
	
    @Override
    public SingleJobResponseDTO getJobByTitle(String title, String cpf) {
    	Optional<User> userOp = userRepository.findBycpf(cpf);
        User user = userOp.orElseThrow(() -> new UserNotFoundException(cpf));

        Optional<UserJob> userJobOp = userJobRepository.findByUserId(userOp.get().getId());
        UserJob userJob = userJobOp.orElseThrow(() -> new UserJobNotFoundException(user.getId()));
        
        return new SingleJobResponseDTO(userJob.getJobTitle(title));
    }
	
	public Tag[] listTags() {
		return Tag.values();
	}
	
}