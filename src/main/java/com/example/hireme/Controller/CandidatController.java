package com.example.hireme.Controller;


import com.example.hireme.Entity.Candidat;
import com.example.hireme.Service.CandidatServiceImp;
import com.example.hireme.Service.IService.ICandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/candidat/api/v1")
public class CandidatController {


   private  ICandidatService candidatService;

    @Autowired
    public CandidatController(ICandidatService candidatService) {
        this.candidatService = candidatService;
    }


    //SAVE CANDIDAT 
    @PostMapping("/addcandidat")
    public ResponseEntity<Candidat> addClient(@RequestBody Candidat candidat) {
        // Add validation or additional logic as needed
       Candidat CandidatEnregistre =  candidatService.creeCandidat(candidat);
        return ResponseEntity.status(HttpStatus.CREATED).body(CandidatEnregistre);
    }
    
    //LIST ALL CANDIDATES
    @GetMapping("/listercandidats")
    public Iterable<Candidat> getAllClients() {
        return candidatService.listerCandidats();
    }


    // UPDATE CANDIDAT
    @PutMapping ("/modifiercandidat/{id}")
    public ResponseEntity<Candidat> modifierCandidat(@PathVariable("id") Long id , @RequestBody Candidat candidat)
    {

        try {
            Candidat  modifiedCandidat = candidatService.modifierCandidat(id , candidat);
            return ResponseEntity.ok(modifiedCandidat);
        } catch (NoSuchElementException e) {
       return ResponseEntity.notFound().build();
    }
    }



    //SUPPRIMER CANDIDAT
    @DeleteMapping("/supprimmercandidat/{id}")
    public ResponseEntity<String> supprimerCandidat(@PathVariable ("id") Long id )
    {try {
            // Delete the Candidat
            candidatService.supprimerCandidat(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Client deleted successfully");
    }



    // LIST CANDIDATS BY NAME
    @GetMapping("/listercandnom/{nom}")
    public ResponseEntity<List<Candidat>> listerCandidatsByNom(@PathVariable("nom") String nom) {
        List<Candidat> candidatList = candidatService.listerCandidatsByNom(nom);
        if (candidatList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(candidatList);
    }

    //DISPLAY CANDIDAT BY ID
    @GetMapping("/affichercandidat/{id}")
    public ResponseEntity<Candidat> getAllClients(@PathVariable("id") Long id) {
        try {
            Candidat CandidatById = candidatService.listerCandidatById(id);
            return ResponseEntity.ok(CandidatById);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }




}
