package com.ge.appge.service.Impl;

import org.springframework.stereotype.Service;

import com.ge.appge.repository.etudiantRepository;
import com.ge.appge.service.etudiantService;
import com.ge.appge.entity.Etudiant;

import java.util.List;
@Service
public class etudiantServiceImpl implements etudiantService{
    private etudiantRepository etudiantrepository;
    
    public etudiantServiceImpl(etudiantRepository etudiantrepository) {
        this.etudiantrepository = etudiantrepository;
    }

    @Override
    public List<Etudiant> getAllEtudiants(){
        return etudiantrepository.findAll();
    }

    @Override
    public void deleteEtudiant(Long id){
        etudiantrepository.deleteById(id);
    }

    @Override
    public Etudiant saveEtudiant(Etudiant etudiant){
        return etudiantrepository.save(etudiant);
    }
    @Override
    public Etudiant getEtudiantById(Long id){
        return etudiantrepository.findById(id).get();
    }
    @Override
    public Etudiant updateEtudiant(Etudiant etudiant){
        return etudiantrepository.save(etudiant);
    }
}
