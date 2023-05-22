package com.example.hireme.Service;

import com.example.hireme.Entity.Candidat;
import com.example.hireme.Repository.CandidatRepository;
import com.example.hireme.Service.IService.ICandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidatServiceImp implements ICandidatService {

    @Autowired
    CandidatRepository candidatRepository;



    @Override
    public Candidat CreeCandidat(Candidat candidat) {

       return candidatRepository.save(candidat);
    }

    @Override
    public List<Candidat> listerCandidats() {
        return candidatRepository.findAll();
    }


}
