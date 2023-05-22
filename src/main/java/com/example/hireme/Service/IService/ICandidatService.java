package com.example.hireme.Service.IService;

import com.example.hireme.Entity.Candidat;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICandidatService {

    Candidat CreeCandidat(Candidat candidat);
    List<Candidat> listerCandidats();


}
