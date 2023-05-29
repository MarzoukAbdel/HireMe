package com.example.hireme.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Recruteur extends Personne{



    @OneToMany(mappedBy = "recruteur", cascade = CascadeType.ALL)
    private List<RendezVous> rendezVousList;


    @ManyToOne
    private Admin admin;
}
