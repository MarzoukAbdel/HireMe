package com.example.hireme.Controller;


import com.example.hireme.Dto.CandidatDTO;
import com.example.hireme.Entity.Candidat;
import com.example.hireme.Entity.Metier;
import com.example.hireme.Mappers.CandidatMapper;
import com.example.hireme.Service.IService.ICandidatService;
import com.example.hireme.Service.IService.IMetierService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/candidat/api/v1")
public class CandidatController {


    private ICandidatService candidatService;
    private CandidatMapper candidatMapper;
    private IMetierService metierService;

    @Autowired
    public CandidatController(ICandidatService candidatService, CandidatMapper candidatMapper, IMetierService metierService) {
        this.candidatService = candidatService;
        this.candidatMapper = candidatMapper;
        this.metierService = metierService;
    }


    //SAVE CANDIDAT 
    @PostMapping("/addcandidat")
    public ResponseEntity<Candidat> ajouterCandidat(@RequestBody Candidat candidat) {
        try {
            Candidat CandidatEnregistre = candidatService.creeCandidat(candidat);
            return ResponseEntity.status(HttpStatus.CREATED).body(CandidatEnregistre);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/candidature")
    public ResponseEntity<CandidatDTO> candidature(@RequestBody CandidatDTO candidatDTO) {
        try {
            Metier metier = metierService.chercherByID(candidatDTO.getMetier_id());
            Candidat candidat = candidatMapper.toEntity(candidatDTO);
            candidat.setMetier(metier);
            Candidat CandidatEnregistre = candidatService.creeCandidat(candidat);
            CandidatDTO candidatDTOReturned = candidatMapper.toDTO(CandidatEnregistre);
            return ResponseEntity.status(HttpStatus.CREATED).body(candidatDTOReturned);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //LIST ALL CANDIDATs
    @GetMapping("/listercandidats")
    public ResponseEntity<List<CandidatDTO>> listerCandidats() {
        List<Candidat> candidatList = candidatService.findAllCandidat();
        if (candidatList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<CandidatDTO> candidatDTOList = candidatList.stream()
                .map(candidat -> candidatMapper.toDTO(candidat))
                .collect(Collectors.toList());
        return ResponseEntity.ok(candidatDTOList);
    }

    // UPDATE CANDIDAT
    @PutMapping("/modifiercandidat/{id}")
    public ResponseEntity<CandidatDTO> modifierCandidat(@NonNull @PathVariable("id") Long id, @RequestBody CandidatDTO candidatdto) {
        try {
            Candidat candidat = candidatMapper.toEntity(candidatdto);
            Candidat candidatmodifier = candidatService.modifierCandidat(id, candidat);
            CandidatDTO modifiedCandidatDto = candidatMapper.toDTO(candidatmodifier);
            return ResponseEntity.ok(modifiedCandidatDto);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE CANDIDAT
    @DeleteMapping("/supprimmercandidat/{id}")
    public ResponseEntity<String> supprimerCandidat(@PathVariable("id") Long id) {
        try {
            // Delete the Candidat
            candidatService.supprimerCandidat(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Client deleted successfully");
    }

    // LIST CANDIDATS BY NAME
    @GetMapping("/listercandidatnom/{nom}")
    public ResponseEntity<List<Candidat>> listerCandidatsByNom(@PathVariable("nom") String nom) {
        List<Candidat> candidatList = candidatService.listerCandidatsByNom(nom);
        if (candidatList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {

            List<CandidatDTO> candidatDTOList = candidatList.stream()
                    .map(candidat -> candidatMapper.toDTO(candidat))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(candidatList);
        }

    }

    //DISPLAY CANDIDAT BY ID
    @GetMapping("/affichercandidat/{id}")
    public ResponseEntity<CandidatDTO> afficherCandidat(@PathVariable("id") Long id) {
        try {
            Candidat CandidatById = candidatService.listerCandidatById(id);
            CandidatDTO candidatDTObyId = candidatMapper.toDTO(CandidatById);
            return ResponseEntity.ok(candidatDTObyId);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }



    //LIST CANDIDATS BY SCORE (ORDER BY) DESC
    @GetMapping("/listerparscore")
    public ResponseEntity<List<CandidatDTO>> listerCandidatByScore() {
        List<Candidat> candidatList = candidatService.listerCandidatsByScoreDesc();
        if (candidatList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<CandidatDTO> candidatDTOList = candidatList.stream()
                .map(candidat -> candidatMapper.toDTO(candidat))
                .collect(Collectors.toList());
        return ResponseEntity.ok(candidatDTOList);
    }

    //UPLOAD PHOTO CANDIDAT
    @PutMapping("/uploadimage_c/{id}")
    public ResponseEntity<String> uploadImage(@PathVariable("id") Long id,@RequestParam("file") MultipartFile imageFile) {
        try {
            candidatService.uploadImage(id, imageFile);
            return ResponseEntity.status(HttpStatus.OK).body("Image uploaded/modified successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload/modify image");
        }
    }
}

