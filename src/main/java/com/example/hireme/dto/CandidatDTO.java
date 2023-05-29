package com.example.hireme.dto;


import lombok.Data;

@Data
public class CandidatDTO extends PersonneDto {

    private Long metier_id;
    private String metierNom;
    private int score;

}
