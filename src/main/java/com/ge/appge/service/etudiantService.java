package com.ge.appge.service;

import com.ge.appge.entity.Etudiant;
import java.util.List;

public interface etudiantService {
    List<Etudiant> getAllEtudiants();

    Etudiant saveEtudiant(Etudiant etudiant);

    Etudiant updateEtudiant(Etudiant etudiant);

    void deleteEtudiant(Long id);

    Etudiant getEtudiantById(Long id);
}
