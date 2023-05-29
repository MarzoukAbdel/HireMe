package com.example.hireme.service.iservice;

import com.example.hireme.entity.Metier;

import java.util.List;


public interface IMetierService {

    Metier ajouterMetier(Metier metier);
    Metier chercherByID(Long id);
    List<Metier>  listerMetier();
    Metier modifierMetierAdmin(long id, Metier metier);
    List<Metier> listerMetierByNom(String nom);






}
