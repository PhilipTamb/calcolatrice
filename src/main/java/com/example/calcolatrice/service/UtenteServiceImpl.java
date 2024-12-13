package com.example.calcolatrice.service;

import com.example.calcolatrice.dto.UtenteDTO;
import com.example.calcolatrice.exception.NoDataFoundException;
import com.example.calcolatrice.model.Utente;
import com.example.calcolatrice.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtenteServiceImpl implements UtenteService{

    @Autowired
    private UtenteRepository utenteRepository;

    private Utente dtoToModel (UtenteDTO utente){
        return Utente.builder()
                .uuid(utente.getUuid())
                .name(utente.getName())
                .password(utente.getPassword())
                .address(utente.getAddress())
                .build();
    }

    private UtenteDTO modelToDTO (Utente utente){
        return UtenteDTO.builder()
                .uuid(utente.getUuid())
                .name(utente.getName())
                .password(utente.getPassword())
                .address(utente.getAddress())
                .build();
    }

    @Override
    public UtenteDTO findByUuid(String uuid) {
        return modelToDTO(utenteRepository.findByUuid(uuid).orElseThrow(NoDataFoundException::new));
    }

    @Override
    public UtenteDTO save(UtenteDTO utente) {
        utente.setUuid(String.valueOf(UUID.randomUUID()));
        return modelToDTO(utenteRepository.save( dtoToModel(utente) ));
    }
}
