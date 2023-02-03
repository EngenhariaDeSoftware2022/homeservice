package es.homeservices.controllers;

import es.homeservices.DTO.*;
import es.homeservices.models.Job;
import es.homeservices.models.SecurityUser;
import es.homeservices.services.UserJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class UserJobController {

    @Autowired
    private UserJobService userJobService;

    @PostMapping(value = "/createJob")
    @ResponseStatus(HttpStatus.OK)
    public JobResponseDTO createJob(@AuthenticationPrincipal SecurityUser securityUser,
                                    @RequestBody JobRequestDTO jobDTO){
        return userJobService.createJob(securityUser.getUser(), jobDTO);
    }

    @GetMapping(value = "/listUserJobs")
    @ResponseStatus(HttpStatus.OK)
    public JobListResponseDTO listUserJob(@AuthenticationPrincipal SecurityUser securityUser){
        return userJobService.listUserJob(securityUser.getUser());
    }

    @PatchMapping(value = "/editJob")
    @ResponseStatus(HttpStatus.OK)
    public JobResponseDTO editJob(@AuthenticationPrincipal SecurityUser securityUser,
                                  @RequestBody EditJobRequestDTO EditJobDTO){
        return userJobService.editJob(securityUser.getUser(), EditJobDTO);
    }

    @GetMapping(value = "/getJob")
    @ResponseStatus(HttpStatus.OK)
    public Job getUserJob(@AuthenticationPrincipal SecurityUser securityUser,
                          @RequestParam Long jobId){
        return userJobService.getUserJob(securityUser.getUser(), jobId);
    }

    @DeleteMapping(value = "/deleteJob")
    @ResponseStatus(HttpStatus.OK)
    public DeletedJobResponseDTO deleteJob(@AuthenticationPrincipal SecurityUser securityUser,
                                           @RequestParam Long jobId){
        return userJobService.deleteJob(securityUser.getUser(), jobId);
    }
}
