package com.ge.appge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ge.appge.entity.Etudiant;

@Repository
public interface etudiantRepository extends JpaRepository<Etudiant,Long> {

}
