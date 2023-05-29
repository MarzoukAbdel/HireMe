package com.example.hireme.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class PersonneDto {

    private Long id ;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String address;
    private String tele;



}
