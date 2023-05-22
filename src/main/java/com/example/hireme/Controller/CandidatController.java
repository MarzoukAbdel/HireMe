package com.example.hireme.Controller;


import com.example.hireme.Entity.Candidat;
import com.example.hireme.Service.IService.ICandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Candidat addClient(@RequestBody Candidat candidat) {
        // Add validation or additional logic as needed
        return candidatService.CreeCandidat(candidat);
    }
    
    //LIST ALL CANDIDATES
    @GetMapping("/listercandidats")
    public Iterable<Candidat> getAllClients() {
        return candidatService.listerCandidats();
    }






}
