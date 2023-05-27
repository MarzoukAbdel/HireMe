package com.example.hireme.Controller;
import com.example.hireme.Dto.CandidatDTO;
import com.example.hireme.Dto.RecruteurDTO;
import com.example.hireme.Entity.Candidat;
import com.example.hireme.Entity.Recruteur;
import com.example.hireme.Mappers.RecruteurMapper;
import com.example.hireme.Service.IService.IRecruteurService;
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
@RequestMapping("/recruteur/api/v1")

public class RecruteurController {


    private final IRecruteurService iRecruteurService;
    private final RecruteurMapper recruteurMapper;

    @Autowired
    public RecruteurController(IRecruteurService iRecruteurService, RecruteurMapper recruteurMapper) {
        this.iRecruteurService = iRecruteurService;
        this.recruteurMapper = recruteurMapper;
    }
    //ADD RECRUTEUR
    @PostMapping("/candidature")
    public ResponseEntity<RecruteurDTO> candidature(@RequestBody RecruteurDTO recruteurDTO) {
        try {
            Recruteur recruteur = recruteurMapper.toEntity(recruteurDTO);
            Recruteur RecruteurEnregistre = iRecruteurService.creeRecruteur(recruteur);
            RecruteurDTO recruteurDTOreturned = recruteurMapper.toDTO(RecruteurEnregistre);
            return ResponseEntity.status(HttpStatus.CREATED).body(recruteurDTOreturned);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //LIST RECRUTEUR
    @GetMapping("listerecruteurs")
    public  ResponseEntity<List<RecruteurDTO>> listRecruteur()
    {
        List<Recruteur> recruteurList = iRecruteurService.findAllRecruteur();
        if (recruteurList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<RecruteurDTO> recruteurDTOList = recruteurList.stream()
                .map(recruteur -> recruteurMapper.toDTO(recruteur))
                .collect(Collectors.toList());
        return ResponseEntity.ok(recruteurDTOList);
    }

    // UPDATE RECRUTRUR
    @PutMapping("/modifierrecruteur/{id}")
    public ResponseEntity<RecruteurDTO> modifierCandidat(@PathVariable("id") Long id, @RequestBody RecruteurDTO recruteurDTO) {
        try {
            Recruteur recruteur = recruteurMapper.toEntity(recruteurDTO);
            Recruteur recruteurModifier = iRecruteurService.modifierRecruteur(id,recruteur);
            RecruteurDTO modifiedRecruteurDto = recruteurMapper.toDTO(recruteurModifier);
            return ResponseEntity.ok(modifiedRecruteurDto);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }


    //DELETE RECRUTEUR
    @DeleteMapping("/supprimmerrecruteur/{id}")
    public ResponseEntity<String> supprimerCandidat(@PathVariable("id") Long id) {
        try {
            // Delete the Candidat
            iRecruteurService.supprimerRecruteur(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Client deleted successfully");
    }


    // LIST RECRUTEUR BY NAME
    @GetMapping("/listerrecruteurbynom/{nom}")
    public ResponseEntity<List<RecruteurDTO>> listerRecruteurByNom(@PathVariable("nom") String nom) {
        List<Recruteur> recruteurtListNom = iRecruteurService.listerRecruteurByNom(nom);
        if (recruteurtListNom.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else
        {
            List<RecruteurDTO> recruteurDTOListNom = recruteurtListNom.stream()
                    .map(recruteur -> recruteurMapper.toDTO(recruteur))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(recruteurDTOListNom);
        }
        
    }

    //DISPLAY RECRUTEUR BY ID
    @GetMapping("/afficherrecruteur/{id}")
    public ResponseEntity<RecruteurDTO> afficherCandidat(@PathVariable("id") Long id) {
        try {
            Recruteur recruteurbyId = iRecruteurService.afficherRecruteur(id);
            RecruteurDTO recruteurDTOById = recruteurMapper.toDTO(recruteurbyId);
            return ResponseEntity.ok(recruteurDTOById);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }


    //UPLOAD PHOTO RECRUTEUR
    @PutMapping ("/uploadimage_r/{id}")
    public ResponseEntity<String> uploadImage(@PathVariable("id") Long id,@RequestParam("file") MultipartFile imageFile) {
        try {
            iRecruteurService.uploadImage(id, imageFile);
            return ResponseEntity.status(HttpStatus.OK).body("Image uploaded/modified successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload/modify image");
        }
    }




}
