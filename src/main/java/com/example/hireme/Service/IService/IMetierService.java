package com.example.hireme.Service.IService;

import com.example.hireme.Entity.Metier;


public interface IMetierService {

    Metier ajouterMetier(Metier metier);
    Metier chercherByID(Long id);



}
