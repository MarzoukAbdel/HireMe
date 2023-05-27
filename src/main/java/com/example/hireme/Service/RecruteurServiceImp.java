package com.example.hireme.Service;

import com.example.hireme.Entity.Candidat;
import com.example.hireme.Entity.Recruteur;
import com.example.hireme.Exeception.RessourcesNotFound;
import com.example.hireme.Repository.RecruteurRepository;
import com.example.hireme.Service.IService.IRecruteurService;
import com.example.hireme.Utils.imageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class RecruteurServiceImp implements IRecruteurService {


    private final RecruteurRepository recruteurRepository;
    private final imageUtils imageUtils;

    @Autowired
    public RecruteurServiceImp(RecruteurRepository recruteurRepository, com.example.hireme.Utils.imageUtils imageUtils) {
        this.recruteurRepository = recruteurRepository;
        this.imageUtils = imageUtils;
    }

    //ADD RECRUTEUR
    @Override
    public Recruteur creeRecruteur(Recruteur recruteur) {
      Recruteur recruteurEnregistrer = recruteurRepository.save(recruteur);
        return recruteur;
    }

    @Override
    public Recruteur afficherRecruteur(Long id) {
        Recruteur RecruteurExistant = recruteurRepository.findById(id).orElseThrow(()-> new RessourcesNotFound("Recruteur Not Found"));
        return RecruteurExistant;
    }


    //GET ALL RECRUTEURS
    @Override
    public List<Recruteur> findAllRecruteur() {
        List<Recruteur> allRecruteurs = recruteurRepository.findAll();
        return allRecruteurs;
    }


    //UPDATE RECRUTEUR
    @Override //TODO SET NOT RECOMMENDED
    public Recruteur modifierRecruteur(Long id, Recruteur recruteur) {
        Recruteur RecruteurExistant = recruteurRepository.findById(id).orElseThrow(()-> new RessourcesNotFound("Recruteur Not Found"));
        RecruteurExistant.setNom(recruteur.getNom());
        RecruteurExistant.setAddress(recruteur.getAddress());
        RecruteurExistant.setEmail(recruteur.getEmail());
        RecruteurExistant.setPrenom(recruteur.getPrenom());
        RecruteurExistant.setTele(recruteur.getTele());
        RecruteurExistant.setPassword(recruteur.getPassword());
        Recruteur RecruteurModifier = recruteurRepository.save(RecruteurExistant);
        return RecruteurModifier;
    }


    //LIST ALL RECRUTEURS BY NAME
    @Override
    public List<Recruteur> listerRecruteurByNom(String nom) {
        List<Recruteur>  ListRecruteurByNom = recruteurRepository.findAllByNom(nom);
      return ListRecruteurByNom;
    }

    @Override
    public Recruteur supprimerRecruteur(long id) {
        Recruteur recruteurExistant = recruteurRepository.findById(id).orElseThrow(()-> new RessourcesNotFound("Recruteur Not Found"));;
        recruteurRepository.delete(recruteurExistant);
        return recruteurExistant;
    }


    //UPLOAD PHOTO FOR RECRUITER
    @Override
    public void uploadImage(Long id, MultipartFile imageFile) throws IOException {
        Recruteur recruteurExistant = recruteurRepository.findById(id).orElseThrow(()-> new RessourcesNotFound("Recruteur Not Found"));
        if (imageUtils.checkImage(imageFile)) {
                byte[] imageData = imageFile.getBytes();
                recruteurExistant.setImage(imageData);
                recruteurRepository.save(recruteurExistant);
        }
        else
            throw new IOException("Failed To Upload image Please Retry");

    }









}
