package com.example.hireme.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
