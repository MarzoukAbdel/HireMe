package com.example.hireme.repository;

import com.example.hireme.entity.Recruteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruteurRepository extends JpaRepository<Recruteur, Long> {

   List<Recruteur> findAllByNom(String Nom);

}
