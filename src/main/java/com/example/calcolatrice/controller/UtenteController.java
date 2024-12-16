package com.example.calcolatrice.controller;

import com.example.calcolatrice.dto.UtenteDTO;
import com.example.calcolatrice.service.UtenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping("/{uuid}")
    public UtenteDTO findByUuid(@PathVariable String uuid ){
        return utenteService.findByUuid( uuid );
    }

    @PostMapping
    public UtenteDTO save( @RequestBody @Valid UtenteDTO utente ){
        return utenteService.save( utente );
    }
}
