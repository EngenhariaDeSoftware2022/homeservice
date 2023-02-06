package es.homeservices.controllers;

import es.homeservices.DTO.UserDetailsDTO;
import es.homeservices.DTO.UserRequestDTO;
import es.homeservices.DTO.UserResponseDTO;
import es.homeservices.models.SecurityUser;
import es.homeservices.models.User;
import es.homeservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @GetMapping(value = "/getUser")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO getUserByCPF(@RequestParam String cpf){
        return userService.getUser(cpf);
    }

    @GetMapping(value = "/getCurrentLoggedInDetails")
    @ResponseStatus(HttpStatus.OK)
    public UserDetailsDTO getCurrentLoggedInUserDetails(@AuthenticationPrincipal SecurityUser securityUser){
        return userService.getPrincipalDetails(securityUser.getUser());
    }


    @GetMapping("/getUserDetails")
    @ResponseStatus(HttpStatus.OK)
    public UserDetailsDTO getUserDetailsByCPF(@RequestParam String cpf){
        return userService.getUserDetails(cpf);
    }

    @DeleteMapping("/deleteUser")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO deleteUser(@AuthenticationPrincipal SecurityUser securityUser){
        return userService.deleteUser(securityUser.getUser());
    }
}
