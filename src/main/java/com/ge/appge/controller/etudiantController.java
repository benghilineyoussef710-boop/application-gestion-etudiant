package com.ge.appge.controller;

import org.springframework.stereotype.Controller;

import com.ge.appge.entity.Etudiant;
import com.ge.appge.service.etudiantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class etudiantController {

    private etudiantService etudiantservice;

    public etudiantController(etudiantService etudiantservice) {
        this.etudiantservice = etudiantservice;
    }
    
    @GetMapping("/etudiants")
    public String listEtudiant(Model model) {
        model.addAttribute("etudiants",etudiantservice.getAllEtudiants());
        return "etudiants";
    }
    @GetMapping("/etudiants/new")
    public String createEtudiant(Model model) {
       Etudiant etudiant=new Etudiant();
       model.addAttribute("etudiant",etudiant);
        return "create_etudiant";
    }
    @GetMapping("/etudiants/edit/{id}")
    public String editEtudiant(@PathVariable Long id,Model model) {
       model.addAttribute("etudiant",etudiantservice.getEtudiantById(id));
        return "edit_etudiant";
    }
    @PostMapping("/etudiants")
    public String saveEtudiant(@ModelAttribute("etudiant") Etudiant etudiant) {
        etudiantservice.saveEtudiant(etudiant);
        return "redirect:/etudiants";
    }
    @PostMapping("/etudiants/{id}")
    public String updateEtudiant(@PathVariable Long id,@ModelAttribute("etudiant") Etudiant etudiant,Model model) {
       Etudiant etudiantexistant=etudiantservice.getEtudiantById(id);
       etudiantexistant.setEmail(etudiant.getEmail());
       etudiantexistant.setPrenom(etudiant.getPrenom());
       etudiantexistant.setNom(etudiant.getNom());
       etudiantservice.updateEtudiant(etudiantexistant);
        return "redirect:/etudiants";
    }
    @GetMapping("/etudiants/delete/{id}")
    public String deleteEtudiant(@PathVariable Long id) {
        etudiantservice.deleteEtudiant(id);
        return "redirect:/etudiants";
    }
    
}
