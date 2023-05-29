package com.example.hireme.service;

import com.example.hireme.entity.Metier;
import com.example.hireme.exeception.RessourcesNotFound;
import com.example.hireme.repository.MetierRepository;
import com.example.hireme.service.iservice.IMetierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Metier> listerMetier() {
        return metierRepository.findAll();
    }

    @Override
    public Metier modifierMetierAdmin(long id , Metier metier) {
        Metier metierExistant = metierRepository.findById(id).orElseThrow(()-> new RessourcesNotFound("Metier Not Found"));
        metierExistant.setNom(metier.getNom());
        metierExistant.setDescription(metier.getDescription());
        return metierRepository.save(metierExistant);
    }

    @Override
    public List<Metier> listerMetierByNom(String nom) {
        return metierRepository.findAllByNom(nom);
    }



}
