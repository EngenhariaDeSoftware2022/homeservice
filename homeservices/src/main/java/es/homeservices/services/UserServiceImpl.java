package es.homeservices.services;

import es.homeservices.DTO.UserDetailsDTO;
import es.homeservices.DTO.UserRequestDTO;
import es.homeservices.DTO.UserResponseDTO;
import es.homeservices.exception.CpfInvalidException;
import es.homeservices.exception.DateFormatException;
import es.homeservices.exception.UserExistsException;
import es.homeservices.exception.UserNotFoundException;
import es.homeservices.models.Location;
import es.homeservices.models.User;
import es.homeservices.repositories.LocationRepository;
import es.homeservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final LocationRepository locationRepository;

    private Pattern cpfPattern = Pattern.compile("[0-9]+");

    @Autowired
    public UserServiceImpl(UserRepository userRepository, LocationRepository locationRepository) {
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public User registerUser(UserRequestDTO userRequestDTO)  {
        Optional<User> userOpCpf = userRepository.findBycpf(userRequestDTO.getCpf());
        userOpCpf.ifPresent(user ->{
            throw new UserExistsException(userRequestDTO.getCpf());
        });
        Optional<User> userOpEmail = userRepository.findByEmail(userRequestDTO.getEmail());
        userOpEmail.ifPresent(user ->{
            throw new UserExistsException(userRequestDTO.getEmail());
        });

        if(!validateCPF(userRequestDTO.getCpf()))
            throw new CpfInvalidException(userRequestDTO.getCpf());

        Location location = new Location(userRequestDTO.getCity(), userRequestDTO.getNeighborhood());
        locationRepository.save(location);
        User user = new User(
                userRequestDTO.getName(),
                userRequestDTO.getCpf(),
                userRequestDTO.getEmail(),
                userRequestDTO.getPswd(),
                userRequestDTO.getCel(),
                location
        );
        if (userRequestDTO.getBirthDate() != null){
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date date = formatter.parse(userRequestDTO.getBirthDate());
                user.setBirthDate(date);
            }
            catch (ParseException e){
                throw new DateFormatException(userRequestDTO.getBirthDate());
            }
        }

        userRepository.save(user);
        return user;
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



    @Override
    public UserDetailsDTO getUserDetails(String cpf) {
        Optional<User> userOp = userRepository.findBycpf(cpf);
        User user = userOp.orElseThrow(() -> new UserNotFoundException(cpf));
        return new UserDetailsDTO(user);
    }

    @Override
    public UserResponseDTO deleteUser(User user) {
        userRepository.delete(user);
        return new UserResponseDTO(user);
    }

    @Override
    public UserDetailsDTO getPrincipalDetails(User user) {
        return new UserDetailsDTO(user);
    }

    private boolean validateCPF(String cpf){
        if(cpf == null)
            return false;
        if(cpf.length() != 11)
            return false;
        return cpfPattern.matcher(cpf).matches();
    }
}
