package com.example.calcolatrice.service;

import com.example.calcolatrice.dto.UtenteDTO;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UtenteService {

    UtenteDTO findByUuid( String uuid );

    UtenteDTO save(UtenteDTO utente);

    PasswordEncoder passwordEncoder();
}
