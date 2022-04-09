package com.example.jpadata.repositories;

import com.example.jpadata.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    public List<Patient> findByMalade(boolean m );
    Page <Patient> findByMalade(boolean m, Pageable pageable);
    List<Patient> findByMaladeAndScoreLessThan(boolean m,int score);
   // List <Patient> findByDateNaissanceBetweenAndMaladeIsTrueOrNomLike (Date d1, Date d2,String mc);
    //or
    //@Query("selct patient from Patient whre p.dateNaissance between :x and :y or p.name like:z ")
    //List <Patient> chercherpATIENTS (@Param("x") Date d1, @Param("y")Date d2,@Param("z") String nom);
    @Query("select p from Patient p where p.nom like:z and p.score < :scoreMin  ")
    List<Patient> chercherPatients(@Param("z") String nom ,@Param("scoreMin") int scoreMin);

}
