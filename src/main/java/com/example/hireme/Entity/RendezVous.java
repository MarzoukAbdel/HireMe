package com.example.hireme.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Map;

@Entity
public class RendezVous {

    @Id

    private long id ;
    private LocalDate date;
    private int note;
    private String review;

    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Candidat candidat;

    @ManyToOne
    @JoinColumn(name = "recruteur_id")
    private Recruteur recruteur;


}
