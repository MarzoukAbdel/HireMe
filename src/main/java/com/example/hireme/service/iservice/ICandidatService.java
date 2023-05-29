package com.example.hireme.service.iservice;

import com.example.hireme.entity.Candidat;
import com.example.hireme.entity.Metier;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface ICandidatService {

    Candidat creeCandidat(Candidat candidat);
    List<Candidat> findAllCandidat();
    Candidat modifierCandidat(Long id , Candidat candidat);
    Candidat  supprimerCandidat(long id);
    List<Candidat> listerCandidatsAMetier(String NomMetier);

    Candidat listerCandidatById(long id);

    List<Candidat> listerCandidatsByNom(String nom);

    List<Candidat> listerCandidatsByScoreDesc();

    public void uploadImage(Long id, MultipartFile imageFile) throws IOException;

    void modifierMetierCandidat(Long idcondidat , Metier metier);


}
