package com.example.calcolatrice.configuration;

import com.example.calcolatrice.model.Utente;
import com.example.calcolatrice.repository.UtenteRepository;
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
        Utente utente = optionalUtente.get();


        // Build a UserDetails object

        return User.withUsername(utente.getName())
                .password(utente.getPassword())
                .roles("USER")
                .build();
    }
}
