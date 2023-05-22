package com.example.hireme.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Admin  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id ;
    String nom;
    String prenom;
    String login;
    String password;


    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Candidat> candidats;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Recruteur> recruteurs;

}
