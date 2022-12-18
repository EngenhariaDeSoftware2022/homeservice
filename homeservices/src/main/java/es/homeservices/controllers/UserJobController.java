package es.homeservices.controllers;

import es.homeservices.DTO.*;
import es.homeservices.models.Job;
import es.homeservices.services.UserJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserJobController {

    @Autowired
    private UserJobService userJobService;

    @PostMapping(value = "/createJob")
    @ResponseStatus(HttpStatus.OK)
    public JobResponseDTO createJob(@RequestBody JobRequestDTO jobDTO){
        return userJobService.createJob(jobDTO);
    }

    @GetMapping(value = "/listUserJobs")
    @ResponseStatus(HttpStatus.OK)
    public JobListResponseDTO listUserJob(@RequestParam String cpf){
        return userJobService.listUserJob(cpf);
    }

    @PatchMapping(value = "/editJob")
    @ResponseStatus(HttpStatus.OK)
    public JobResponseDTO editJob(@RequestBody EditJobRequestDTO EditJobDTO){
        return userJobService.editJob(EditJobDTO);
    }

    @GetMapping(value = "/getJob")
    @ResponseStatus(HttpStatus.OK)
    public SingleJobResponseDTO getUserJob(@RequestParam String cpf, Long jobId){
        return userJobService.getUserJob(cpf, jobId);
    }

    @DeleteMapping(value = "/deleteJob")
    @ResponseStatus(HttpStatus.OK)
    public DeletedJobResponseDTO deleteJob(@RequestParam String cpf, Long jobId){
        return userJobService.deleteJob(cpf, jobId);
    }
}
