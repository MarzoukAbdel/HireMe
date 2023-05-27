package com.example.hireme.Mappers;


import com.example.hireme.Dto.RecruteurDTO;

import com.example.hireme.Entity.Recruteur;

import org.springframework.stereotype.Component;

@Component
public class RecruteurMapper {

    public Recruteur toEntity( RecruteurDTO recruteurDTO) {

        Recruteur recruteur = new Recruteur();
        recruteur.setNom(recruteurDTO.getNom());
        recruteur.setPrenom(recruteurDTO.getPrenom());
        recruteur.setEmail(recruteurDTO.getEmail());
        recruteur.setPassword(recruteurDTO.getPassword());
        recruteur.setAddress(recruteurDTO.getAddress());
        recruteur.setTele(recruteurDTO.getTele());
        return recruteur;

    }

    public RecruteurDTO toDTO(Recruteur recruteur)
    {
        RecruteurDTO recruteurDTO = new RecruteurDTO();
        recruteurDTO.setId(recruteur.getId());
        recruteurDTO.setNom(recruteur.getNom());
        recruteurDTO.setPrenom(recruteur.getPrenom());
        recruteurDTO.setEmail(recruteur.getEmail());
        recruteurDTO.setPassword(recruteur.getPassword());
        recruteurDTO.setAddress(recruteur.getAddress());
        recruteurDTO.setTele(recruteur.getTele());
        return recruteurDTO;
    }
}
