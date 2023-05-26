package com.example.hireme.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recruteur extends Personne{



    @OneToMany(mappedBy = "recruteur", cascade = CascadeType.ALL)
    private List<RendezVous> rendezVousList;


    @ManyToOne
    private Admin admin;
}
