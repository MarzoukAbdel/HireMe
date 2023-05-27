package com.example.hireme.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


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
    private String password;
    private String address;
    private String tele;

    @Lob
    @Column(name = "image", length = 1048576)
    private byte [] image;

    // constructors, getters, and setters


}
