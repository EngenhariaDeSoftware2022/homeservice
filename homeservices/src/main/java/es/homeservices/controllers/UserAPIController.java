package es.homeservices.controllers;

import es.homeservices.DTO.UserDetailsDTO;
import es.homeservices.DTO.UserRequestDTO;
import es.homeservices.DTO.UserResponseDTO;
import es.homeservices.models.User;
import es.homeservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserAPIController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/listUsers")
    @ResponseStatus(HttpStatus.OK)
    public List<User> listUsers(){
        return userService.listUsers();
    }

    @PutMapping(value = "/createUser")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = userService.registerUser(userRequestDTO);
        return userResponseDTO;
    }

    @GetMapping(value = "/getUser")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO getUserByCPF(@RequestParam String cpf){
        return userService.getUser(cpf);
    }

    @GetMapping(value = "/getUserDetails")
    @ResponseStatus(HttpStatus.OK)
    public UserDetailsDTO getUserDetailsByCPF(@RequestParam String cpf){
        return userService.getUserDetails(cpf);
    }
}