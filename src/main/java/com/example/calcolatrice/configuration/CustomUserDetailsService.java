package com.example.calcolatrice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retrieve user from the database
        Optional<Utente>  optionalUtente = utenteRepository.findByName(username);

        if (!optionalUtente.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        utente = optionalUtente.get();


        // Build a UserDetails object
        UserDetails userDetails = User.withUsername(utente.getUsername())
                .password(utente.getPassword())
                .roles(utente.getRoles())
                .build();

        return userDetails;
    }
}
