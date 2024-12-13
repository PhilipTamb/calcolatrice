package com.example.calcolatrice.service;

import com.example.calcolatrice.dto.UtenteDTO;

public interface UtenteService {

    UtenteDTO findByUuid( String uuid );

    UtenteDTO save(UtenteDTO utente);
}
