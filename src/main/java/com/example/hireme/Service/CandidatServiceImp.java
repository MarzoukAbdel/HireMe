package com.example.hireme.Service;

import com.example.hireme.Entity.Candidat;
import com.example.hireme.Execeptiond.RessourcesNotFound;
import com.example.hireme.Repository.CandidatRepository;
import com.example.hireme.Service.IService.ICandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class CandidatServiceImp implements ICandidatService {
    private final  CandidatRepository candidatRepository;
    @Autowired
    public CandidatServiceImp(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

     //ADD CANDIDAT
    @Override
    public Candidat creeCandidat(Candidat candidat) {

     Candidat CandidatEnregistrer = candidatRepository.save(candidat);
       //
        return CandidatEnregistrer;
    }

    //LIST CANDIDAT
    @Override
    public List<Candidat> listerCandidats() {
        return candidatRepository.findAll();
    }

    //UPDATE CANDIDAT
    @Override
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

        Candidat candidatExistant = candidatRepository.findById(id).orElseThrow(()-> new RessourcesNotFound("Candidat Not Found"));;
        candidatRepository.delete(candidatExistant);
           return candidatExistant;
    }


    //LIST CANDIDATS BY METIER
    @Override
    public List<Candidat> listerCandidatsAMetier(String NomMetier) {

       return candidatRepository.findCandidatsByMetier(NomMetier);

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


}
