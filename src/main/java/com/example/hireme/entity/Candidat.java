package com.example.hireme.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Candidat extends Personne{

    private int score ;



     @ManyToOne
     @JoinColumn(name = "metier_id")
     private Metier metier;



     @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL)
     private List<RendezVous> rendezVousList;

     @ManyToOne
     private Admin admin;


}
