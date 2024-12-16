package com.example.calcolatrice.controller;

import com.example.calcolatrice.exception.NoDataFoundException;
import com.example.calcolatrice.repository.UtenteRepository;
import com.example.calcolatrice.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.calcolatrice.model.Utente;
import com.example.calcolatrice.dto.UtenteDTO;
import org.springframework.ui.Model;

@Controller
@RequestMapping
public class AuthController {

    private final UtenteService utenteService;
    @Autowired
    private UtenteRepository utenteRepository;

    public AuthController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

  /* @PostMapping("/login")
    public String logUser(@RequestBody UtenteDTO utenteDTO) {
       utenteRepository.findByName(utenteDTO.getName()).orElseThrow(NoDataFoundException::new);
        return "redirect:/calcolatrice?success";
    } */


    @GetMapping("/registration")
    public String signUpForm(Model model) {
        model.addAttribute("utente", new UtenteDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@RequestBody UtenteDTO utenteDTO) {
        utenteDTO.setPassword(utenteService.passwordEncoder().encode(utenteDTO.getPassword()));
        utenteDTO.setAddress(utenteDTO.getAddress());
        utenteDTO.setName(utenteDTO.getName());
        utenteService.save(utenteDTO);
        return "redirect:/login?success";
    }
}