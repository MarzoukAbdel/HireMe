package com.example.hireme.service;

import com.example.hireme.entity.Candidat;
import com.example.hireme.entity.Metier;
import com.example.hireme.exeception.RessourcesNotFound;
import com.example.hireme.repository.CandidatRepository;
import com.example.hireme.repository.MetierRepository;
import com.example.hireme.service.iservice.ICandidatService;
import com.example.hireme.utils.imageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service

@RequiredArgsConstructor

public class CandidatServiceImp implements ICandidatService {
    private final CandidatRepository candidatRepository;
    private final MetierRepository metierRepository;
    private final imageUtils imageUtils;



     //ADD CANDIDAT
    @Override
    public Candidat creeCandidat(Candidat candidat) {

     Candidat CandidatEnregistrer = candidatRepository.save(candidat);
        return CandidatEnregistrer;
    }

    @Override
    public List<Candidat> findAllCandidat() {
              List<Candidat> allCandidat = candidatRepository.findAll();
              return allCandidat;
    }

    //LIST CANDIDAT

    public List<Candidat> listerCandidats() {

        return candidatRepository.findAll();
    }

    //UPDATE CANDIDAT
    @Override //TODO SET NOT REQUIRED
    public Candidat modifierCandidat(Long id, Candidat candidat) {
        Candidat candidatExistant = candidatRepository.findById(id).orElseThrow(()-> new RessourcesNotFound("Candidat Not Found"));

            candidatExistant.setNom(candidat.getNom());
            candidatExistant.setAddress(candidat.getAddress());
            candidatExistant.setEmail(candidat.getEmail());
            candidatExistant.setPrenom(candidat.getPrenom());
            candidatExistant.setTele(candidat.getTele());
            candidatExistant.setPassword(candidat.getPassword());
            Candidat candidatEnregister  = candidatRepository.save(candidatExistant);


        return candidatEnregister;
    }


    //DELETE CANDIDAT
    @Override
    public Candidat  supprimerCandidat(long id) {

        Candidat candidatExistant = candidatRepository.findById(id).orElseThrow(()-> new RessourcesNotFound("Candidat Not Found"));
        candidatRepository.delete(candidatExistant);
           return candidatExistant;
    }


    //LIST CANDIDATS BY METIER
    @Override
    public List<Candidat> listerCandidatsAMetier(String NomMetier) {

       List<Metier> metierExistants = metierRepository.findAllByNom(NomMetier);
       if (metierExistants.isEmpty()) {
           throw new RessourcesNotFound("Metier not found for name: " + NomMetier);
       }
       return candidatRepository.findAllByMetier_Nom(NomMetier);


    }


    //DISPLAY CANDIDAT BY ID
    @Override
    public Candidat listerCandidatById(long id) {
       Candidat candidatExistant = candidatRepository.findById(id).orElseThrow(()-> new RessourcesNotFound("Candidat Not Found"));

     return candidatExistant;
    }




    // LIST CANDIDAT BY NAME
    @Override
    public List<Candidat> listerCandidatsByNom(String nom) {
    return candidatRepository.findAllByNom(nom);
    }




    //LIST CANDIDAT BY HIGHEST SCORE
    @Override
    public List<Candidat> listerCandidatsByScoreDesc() {
       return candidatRepository.findAllByOrderByScoreDesc();
    }



    //UPLOAD IMAGE CANDIDAT
    @Override
    public void uploadImage(Long id, MultipartFile imageFile) throws IOException {
        Candidat candidatExistant = candidatRepository.findById(id).orElseThrow(()-> new RessourcesNotFound("Candidat Not Found"));
        if (imageUtils.checkImage(imageFile)) {
                    byte[] imageData = imageFile.getBytes();
                    candidatExistant.setImage(imageData);
                    candidatRepository.save(candidatExistant);
            }
        else
           throw new IOException("Failed To Upload image Please Retry");

    }

    @Override
    public void modifierMetierCandidat(Long idCondidat, Metier metier) {

        Metier metierExistant = metierRepository.findById(metier.getId()).orElseThrow(()-> new RessourcesNotFound("Metier Not Found"));
        Candidat candidatExistant = candidatRepository.findById(idCondidat).orElseThrow(()-> new RessourcesNotFound("Candidat Not Found"));
        candidatExistant.setMetier(metier);
        candidatRepository.save(candidatExistant);

    }
}



