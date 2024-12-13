package com.example.calcolatrice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.calcolatrice.service.LoginServiceImpl;
import org.springframework.ui.Model;
import java.security.Principal;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Configuration
@EnableWebSecurity
public class LoginController {

    private UtenteRepository userRepository;
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        Utente utente = LoginServiceImpl.loadUserByName(principal.getName());
       model.addAttribute("userdetail", userDetails);
        return "home";
    }


    @GetMapping("/login")
    public String login(Model model, UtenteDTO userDto) {

        model.addAttribute("user", userDto);
        return "login";
    }

    @PostMapping("/register")
    public String registerSava(@ModelAttribute("user") UtenteDTO userDto, Model model) {
        Utente utente = LoginServiceImpl.findByName(userDto.getName());
        if (utente != null) {
            model.addAttribute("Userexist", user);
            return "register";
        }
        LoginServiceImpl.save(UtenteDTO);
        return "redirect:/register?success";
    }
}

}