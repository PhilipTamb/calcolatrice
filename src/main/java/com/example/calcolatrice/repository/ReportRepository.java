package com.example.calcolatrice.repository;

import com.example.calcolatrice.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    // Trova un report tramite il campo uuid
    Optional<Report> findByUuid(String uuid);

    // Trova tutti i report associati a un determinato utente
    Optional<Report> findByUserUuid(String userUuid);

    // Trova tutti i report con numero di utilizzi maggiore di un valore specifico
    List<Report> findByUtilizziGreaterThan(int nUtilizzi);

    // Trova tutti i report
    List<Report> findAll();
}
