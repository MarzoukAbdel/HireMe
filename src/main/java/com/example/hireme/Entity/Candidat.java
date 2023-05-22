package com.example.hireme.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
public class Candidat extends Personne{

     @ManyToOne
     @JoinColumn(name = "metier_id")
     private Metier metier;
     private int score ;


     @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL)
     private List<RendezVous> rendezVousList;

     @ManyToOne
     private Admin admin;


}
