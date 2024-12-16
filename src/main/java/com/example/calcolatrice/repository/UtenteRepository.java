package com.example.calcolatrice.repository;

import com.example.calcolatrice.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    Optional<Utente> findByUuid(String uuid);

    Optional<Utente> findByName(String username);
}
