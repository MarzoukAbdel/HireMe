package com.example.hireme.mappers;

import com.example.hireme.dto.MetierDTO;
import com.example.hireme.entity.Metier;
import org.springframework.stereotype.Component;


@Component
public class MetierMapper {


    public MetierDTO toDTO(Metier metier)
    {
        MetierDTO metierDTO = new MetierDTO();
        metierDTO.setNom(metier.getNom());
        metierDTO.setDescription(metier.getDescription());
        metierDTO.setId(metier.getId());
        return metierDTO;
    }

    public Metier toEntity(MetierDTO metierDTO)
    {

        Metier metier = new Metier();
        metier.setDescription(metierDTO.getDescription());
        metier.setId(metierDTO.getId());
        metier.setNom(metierDTO.getNom());
        return metier;
    }



}
