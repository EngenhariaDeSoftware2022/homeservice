package es.homeservices.services;

import es.homeservices.DTO.UserDetailsDTO;
import es.homeservices.DTO.UserRequestDTO;
import es.homeservices.DTO.UserResponseDTO;
import es.homeservices.models.User;

import java.text.ParseException;
import java.util.List;

public interface UserService {

    User registerUser(UserRequestDTO user) throws ParseException;
    List<User> listUsers();
    UserResponseDTO getUser(String cpf);

    UserDetailsDTO getUserDetails(String cpf);

    UserResponseDTO deleteUser(User user);

    UserDetailsDTO getPrincipalDetails(User user);
}
