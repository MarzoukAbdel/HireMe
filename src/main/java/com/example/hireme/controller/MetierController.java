package com.example.hireme.controller;

import com.example.hireme.dto.CandidatDTO;
import com.example.hireme.dto.MetierDTO;
import com.example.hireme.entity.Metier;
import com.example.hireme.mappers.MetierMapper;
import com.example.hireme.service.iservice.IMetierService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/metier/api/v1")
@RequiredArgsConstructor
public class MetierController {



    private final IMetierService metierService;
    private final MetierMapper metierMapper;


    @PostMapping("/addmetier")
    public ResponseEntity<Metier> addClient(@RequestBody Metier metier) {
        // Add validation or additional logic as needed
      Metier metierEnregistrer = metierService.ajouterMetier(metier);
        return ResponseEntity.status(HttpStatus.CREATED).body(metierEnregistrer);
    }

    @GetMapping("/listermetier")
    public ResponseEntity<List<MetierDTO>> listerMetier()
    {   List<Metier> listMetier = metierService.listerMetier();
        if(listMetier.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        else{
            List<MetierDTO> metierDTOList = listMetier.stream()
                    .map(metier -> metierMapper.toDTO(metier))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(metierDTOList);
        }
    }

}
