package com.example.hireme.Controller;

import com.example.hireme.Entity.Candidat;
import com.example.hireme.Entity.Metier;
import com.example.hireme.Repository.CandidatRepository;
import com.example.hireme.Repository.MetierRepository;
import com.example.hireme.Service.IService.IMetierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetierController {


    private IMetierService metierService;
    @Autowired
    public MetierController(IMetierService metierService) {
        this.metierService = metierService;
    }

    @PostMapping("/addmetier")
    public ResponseEntity<Metier> addClient(@RequestBody Metier metier) {
        // Add validation or additional logic as needed
      Metier metierEnregistrer = metierService.ajouterMetier(metier);
        return ResponseEntity.status(HttpStatus.CREATED).body(metierEnregistrer);
    }

}
