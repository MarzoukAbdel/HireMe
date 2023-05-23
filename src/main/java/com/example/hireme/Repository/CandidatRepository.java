package com.example.hireme.Repository;

import com.example.hireme.Entity.Candidat;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {

    @Query("SELECT Candidat FROM Candidat c INNER JOIN c.metier m WHERE c.metier = :NomMetier")
    List<Candidat> findCandidatsByMetier(@Param("NomMetier") String NomMetier);


    List<Candidat> findAllByOrderByScoreDesc();

    List<Candidat> findAllByNom(String nom);
}
