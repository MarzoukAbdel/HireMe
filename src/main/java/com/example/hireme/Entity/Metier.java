package com.example.hireme.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Metier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom;
    private String description;

    @OneToMany(mappedBy = "metier")
    List<Candidat> candidats;



}
