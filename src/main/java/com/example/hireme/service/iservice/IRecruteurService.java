package com.example.hireme.service.iservice;

import com.example.hireme.entity.Recruteur;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IRecruteurService {

    Recruteur creeRecruteur(Recruteur recruteur);
    Recruteur afficherRecruteur(Long id);
    List<Recruteur> findAllRecruteur();
    Recruteur modifierRecruteur(Long id , Recruteur recruteur);
    List<Recruteur> listerRecruteurByNom(String nom);
    Recruteur  supprimerRecruteur(long id);
    public void uploadImage(Long id, MultipartFile imageFile) throws IOException;


}
