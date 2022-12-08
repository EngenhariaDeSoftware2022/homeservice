package es.homeservices.services;

import es.homeservices.DTO.UserRequestDTO;
import es.homeservices.DTO.UserResponseDTO;
import es.homeservices.exception.UserExistsException;
import es.homeservices.exception.UserNotFoundException;
import es.homeservices.models.Location;
import es.homeservices.models.User;
import es.homeservices.repositories.LocationRepository;
import es.homeservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final LocationRepository locationRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, LocationRepository locationRepository) {
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        Optional<User> userOp = userRepository.findBycpf(userRequestDTO.getCpf());
        userOp.ifPresent(user ->{
            throw new UserExistsException(userRequestDTO.getCpf());
        });
        Location location = new Location(userRequestDTO.getCity(), userRequestDTO.getNeighborhood());
        locationRepository.save(location);
        User user = new User(
                userRequestDTO.getName(),
                userRequestDTO.getCpf(),
                userRequestDTO.getEmail(),
                userRequestDTO.getPswd(),
                location
        );
        userRepository.save(user);
        return new UserResponseDTO(user);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserResponseDTO getUser(String cpf){
        Optional<User> userOp = userRepository.findBycpf(cpf);
        User user = userOp.orElseThrow(() -> new UserNotFoundException(cpf));
        return new UserResponseDTO(user);
    }
}
