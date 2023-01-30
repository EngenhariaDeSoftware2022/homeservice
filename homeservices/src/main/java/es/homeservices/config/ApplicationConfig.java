package es.homeservices.config;

import es.homeservices.repositories.UserRepository;
import es.homeservices.services.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ApplicationConfig {

    private final JpaUserDetailsService jpaUserDetailsService;

    @Autowired
    public ApplicationConfig(JpaUserDetailsService jpaUserDetailsService) {
        this.jpaUserDetailsService = jpaUserDetailsService;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return jpaUserDetailsService::loadUserByUsername;
    }


}
