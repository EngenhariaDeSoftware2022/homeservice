package es.homeservices.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import es.homeservices.DTO.JobListResponseDTO;
import es.homeservices.repositories.UserJobRepository;
import es.homeservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.homeservices.models.Job;
import es.homeservices.models.enumeration.Tag;
import es.homeservices.repositories.JobRepository;

@Service
public class JobServiceImpl implements JobService {
	
	private final JobRepository jobRepository;
	private final UserRepository userRepository;
	private final UserJobRepository userJobRepository;
	
	@Autowired
	public JobServiceImpl(JobRepository jobRepository, UserRepository userRepository, UserJobRepository userJobRepository) {
		this.jobRepository = jobRepository;
		this.userRepository = userRepository;
		this.userJobRepository = userJobRepository;
	}
	
	public Collection<Job> listJobs() {
		return this.jobRepository.findAll();
	}

	public Tag[] listTags() {
		return Tag.values();
	}

	@Override
	public JobListResponseDTO searchByTitle(String title, List<Tag> tags) {
		List<Job> jobs = new ArrayList<>();
		if(title.isEmpty()){
			jobs = jobRepository.findAll();
		}
		else{
			jobs = jobRepository.findByTitleIgnoreCase(title);
		}

		if (!tags.isEmpty()){
			List<Job> filteredJobs = new ArrayList<Job>();
			for(Job j : jobs){
				if(tags.contains(j.getTag()))
					filteredJobs.add(j);

			}
			return new JobListResponseDTO(filteredJobs);
		}
		return new JobListResponseDTO(jobs);
	}

	@Override
	public List<Tag> stringToEnum(List<String> strTags){
		List<Tag> tags = new ArrayList<Tag>();
		//if(strTags == null || strTags.isEmpty())
		//	return tags;

		for (String s : strTags){
			tags.add(Tag.valueOf(s));
		}

		return tags;
	}



}
