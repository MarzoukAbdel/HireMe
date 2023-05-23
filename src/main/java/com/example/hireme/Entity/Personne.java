package com.example.hireme.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@Data

@MappedSuperclass
public abstract class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String password;
    private String address;
    private String tele;


}
