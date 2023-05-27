package com.example.hireme.Repository;

import com.example.hireme.Entity.Recruteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruteurRepository extends JpaRepository<Recruteur, Long> {

   List<Recruteur> findAllByNom(String Nom);

}
