package com.example.hireme.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidatDTO {
    private Long id ;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String address;
    private Long metier_id;
    private String metierNom;
    private String tele;





}
