package es.homeservices.services;

import es.homeservices.DTO.UserDetailsDTO;
import es.homeservices.DTO.UserRequestDTO;
import es.homeservices.DTO.UserResponseDTO;
import es.homeservices.models.User;

import java.util.List;

public interface UserService {

    UserResponseDTO registerUser(UserRequestDTO user);
    List<User> listUsers();
    UserResponseDTO getUser(String cpf);

    UserDetailsDTO getUserDetails(String cpf);
}
