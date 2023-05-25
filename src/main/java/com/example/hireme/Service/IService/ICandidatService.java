package com.example.hireme.Service.IService;

import com.example.hireme.Entity.Candidat;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface ICandidatService {

    Candidat creeCandidat(Candidat candidat);
    List<Candidat> findAllCandidat();
    Candidat modifierCandidat(Long id , Candidat candidat);
    Candidat  supprimerCandidat(long id);
    List<Candidat> listerCandidatsAMetier(String NomMetier);

    Candidat listerCandidatById(long id);

    List<Candidat> listerCandidatsByNom(String nom);

    List<Candidat> listerCandidatsByScoreDesc();

}
