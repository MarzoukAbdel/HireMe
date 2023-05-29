package com.example.hireme.repository;

import com.example.hireme.entity.Candidat;
import com.example.hireme.entity.Metier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {

   // @Query("SELECT c FROM Candidat c INNER JOIN c.metier m WHERE c.metier.nom = :NomMetier")
    List<Candidat> findAllByMetier_Nom(String NomMetier);


    List<Candidat> findAllByOrderByScoreDesc();

    List<Candidat> findAllByNom(String nom);


}
