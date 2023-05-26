package com.example.hireme.Mappers;

import com.example.hireme.Dto.CandidatDTO;
import com.example.hireme.Entity.Candidat;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class CandidatMapper {
    public Candidat toEntity(CandidatDTO candidatDTO) {
        Candidat candidat = new Candidat();
        candidat.setNom(candidatDTO.getNom());
        candidat.setPrenom(candidatDTO.getPrenom());
        candidat.setEmail(candidatDTO.getEmail());
        candidat.setPassword(candidatDTO.getPassword());
        candidat.setTele(candidatDTO.getTele());
        candidat.setAddress(candidatDTO.getAddress());

        return candidat;}

    public CandidatDTO toDTO(Candidat candidat) {
        CandidatDTO candidatDTO = new CandidatDTO();
        candidatDTO.setId(candidat.getId());
        candidatDTO.setNom(candidat.getNom());
        candidatDTO.setPrenom(candidat.getPrenom());
        candidatDTO.setPassword(candidat.getPassword());
        candidatDTO.setEmail(candidat.getEmail());
        candidatDTO.setTele(candidat.getTele());
        candidatDTO.setAddress(candidat.getAddress());
        if(!isNull(candidat.getMetier())){
            candidatDTO.setMetier_id(candidat.getMetier().getId());
        candidatDTO.setMetierNom(candidat.getMetier().getNom());
    }
        return candidatDTO;}


}
