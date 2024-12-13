package com.example.calcolatrice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String uuid;

    @Column(name = "uuid_utente", nullable = false)
    private String userUuid;

    @Column(name = "n_utilizzi", nullable = false)
    private int nUtilizzi;
}