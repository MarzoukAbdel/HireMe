package com.example.hireme.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
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
