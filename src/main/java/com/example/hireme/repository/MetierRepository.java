package com.example.hireme.repository;

import com.example.hireme.entity.Candidat;
import com.example.hireme.entity.Metier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MetierRepository extends JpaRepository<Metier , Long> {


    List<Metier> findAllByNom(String nom);




    @Query("SELECT Candidat FROM Candidat c INNER JOIN c.metier m WHERE c.metier.nom = :NomMetier")
    List<Candidat> findCandidatsByMetier(@Param("NomMetier") String NomMetier);

}
