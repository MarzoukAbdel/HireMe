package com.example.hireme.Service;

import com.example.hireme.Entity.Candidat;
import com.example.hireme.Entity.Metier;
import com.example.hireme.Exeception.RessourcesNotFound;
import com.example.hireme.Repository.CandidatRepository;
import com.example.hireme.Repository.MetierRepository;
import com.example.hireme.Service.IService.IMetierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetierServiceImp implements IMetierService {
    private  MetierRepository metierRepository;
    @Autowired
    public MetierServiceImp(MetierRepository metierRepository) {
        this.metierRepository = metierRepository;
        }


    @Override
    public Metier ajouterMetier(Metier metier) {
        Metier metierEnregistrer = metierRepository.save(metier);
        return metierEnregistrer;
    }

    @Override
    public Metier chercherByID(Long id) {
        Metier metier = metierRepository.findById(id).orElseThrow(()-> new RessourcesNotFound("Metier Not Found"));
        return metier;
    }
}
