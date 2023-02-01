package es.homeservices.auth;

import es.homeservices.models.SecurityUser;
import es.homeservices.models.User;
import es.homeservices.repositories.UserRepository;
import es.homeservices.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository repository;
    
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
    @Autowired
    public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        User user = new User(
                request.getName(),
                request.getCpf(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword())
        );
        repository.save(user);

        String jwtToken = jwtService.generateToken(new SecurityUser(user));
        return new AuthenticationResponse(jwtToken);
    }

    //For testing only
    public void register(User user) {
        user.setPswd(passwordEncoder.encode(user.getPswd()));
        repository.save(user);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = repository.findByEmail((request.getEmail()))
                .orElseThrow();
        String jwtToken = jwtService.generateToken(new SecurityUser(user));
        return new AuthenticationResponse(jwtToken);
    }
}
