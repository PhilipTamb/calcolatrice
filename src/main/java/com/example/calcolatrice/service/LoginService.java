package com.example.calcolatrice.service;
import com.example.calcolatrice.model.Utente;

public interface LoginService {

    Utente findByUsername(String username);

    Utente save(UtenteDto UtenteDTO);
}
