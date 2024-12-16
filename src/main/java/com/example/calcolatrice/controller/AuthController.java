package com.example.calcolatrice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.calcolatrice.model.Utente;
import com.example.calcolatrice.dto.UtenteDTO;
import org.springframework.ui.Model;

@Controller
@RequestMapping
public class AuthController {

    private final UtenteService utenteService;

    public AuthController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signUpForm(Model model) {
        model.addAttribute("utente", new UtenteDTO());
        return "signup";
    }

    @PostMapping("/register")
    public String registerUser(UtenteDTO utenteDTO) {
        utenteDTO.setPassword(utenteService.passwordEncoder().encode(utenteDTO.getPassword()));
        utenteService.save(utenteDTO);
        return "redirect:/login?success";
    }
}