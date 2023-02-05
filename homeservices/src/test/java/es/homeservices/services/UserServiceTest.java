package es.homeservices.services;

import es.homeservices.DTO.UserRequestDTO;
import es.homeservices.DTO.UserResponseDTO;
import es.homeservices.exception.CpfInvalidException;
import es.homeservices.exception.UserExistsException;
import es.homeservices.models.Location;
import es.homeservices.models.User;
import es.homeservices.repositories.LocationRepository;
import es.homeservices.repositories.UserJobRepository;
import es.homeservices.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserServiceImpl userService;

    @Mock
    private LocationRepository locationRepository;

    @Mock
    private UserJobRepository userJobRepository;

    @Test
    public void testRegisterUserSuccess() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setCpf("12345678910");
        userRequestDTO.setName("John Doe");
        userRequestDTO.setEmail("johndoe@example.com");
        userRequestDTO.setPswd("password");
        userRequestDTO.setCity("São Paulo");
        userRequestDTO.setNeighborhood("Moema");

        User user = new User();
        user.setCpf("12345678910");

        when(userRepository.findBycpf("123.456.789-10")).thenReturn(Optional.of(user));

        assertThrows(UserExistsException.class, () -> userService.registerUser(userRequestDTO));
    }

    @Test
    public void registerUserCPFInvalid() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setCpf("123.456.789-10");
        userRequestDTO.setName("John Doe");
        userRequestDTO.setEmail("johndoe@example.com");
        userRequestDTO.setPswd("password");
        userRequestDTO.setCity("São Paulo");
        userRequestDTO.setNeighborhood("Moema");

        when(userService.validateCPF("12345678910")).thenReturn(false);

        assertThrows(CpfInvalidException.class, () -> userService.registerUser(userRequestDTO));
    }

    @Test
    public void whenValidCPFValid() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setCpf("00000000000");
        userService.registerUser(userRequestDTO);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test(expected = UserExistsException.class)
    public void whenUserAlreadyExists() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setCpf("00000000000");

        User user = new User();
        user.setCpf("00000000000");

        when(userRepository.findBycpf("00000000000")).thenReturn(Optional.of(user));
        userService.registerUser(userRequestDTO);
    }

    @Test(expected = CpfInvalidException.class)
    public void whenInvalidCPF() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setCpf("00000000000");

        doNothing().when(userService).validateCPF("00000000000");
        when(userService.validateCPF("00000000000")).thenReturn(false);
        userService.registerUser(userRequestDTO);
    }

}
