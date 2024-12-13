package com.example.calcolatrice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.calcolatrice.model.Utente;
import com.example.calcolatrice.model.login;


public class LoginServiceImpl implements LoginService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private UtenteRepository utenteRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.utenteRepository = userRepository;
    }

    @Override
    public Utente findByName(String name) {
        return utenteRepository.findByName(name);
    }

    @Override
    public Utente save(UtenteDTO utenteDto) {
        Utente user = new Utente(utenteDto.getName(), passwordEncoder.encode(utenteDto.getPassword()),
                utenteDto.getAddress());
        return userRepository.save(user);
    }


    @Override
    public User loadUserByName(String name) throws UsernameNotFoundException {

        User user = userRepository.findByName(name);
        Login.logged.put(user);
        if (user == null) {
            throw new UsernameNotFoundException("Username or Password not found");
        }
        return user;
    }


}

