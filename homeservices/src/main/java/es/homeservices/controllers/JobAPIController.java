package es.homeservices.controllers;

import es.homeservices.DTO.JobListResponseDTO;
import es.homeservices.DTO.SingleJobResponseDTO;
import es.homeservices.models.Job;
import es.homeservices.models.enumeration.Tag;
import es.homeservices.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class JobAPIController {

    @Autowired
    private JobService jobService;

    @GetMapping(value = "/listJobs")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Job> listJobs(){
        return this.jobService.listJobs();
    }

    @GetMapping(value = "/listTags")
    @ResponseStatus(HttpStatus.OK)
    public Tag[] listTags() {
    	return this.jobService.listTags();
    }

    @GetMapping(value = "/searchJobsByTitle")
    @ResponseStatus(HttpStatus.OK)
    public JobListResponseDTO getJob(@RequestParam String title,
                                     @RequestBody List<String> strTags){

        List<Tag> tags = jobService.stringToEnum(strTags);
        System.out.println(tags);
        return jobService.searchByTitle(title, tags);
    }

}
