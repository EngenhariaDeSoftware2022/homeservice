package es.homeservices.controllers;

import es.homeservices.DTO.UserRequestDTO;
import es.homeservices.DTO.UserResponseDTO;
import es.homeservices.models.Job;
import es.homeservices.models.User;
import es.homeservices.models.enumeration.Tag;
import es.homeservices.services.JobService;
import es.homeservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

}
