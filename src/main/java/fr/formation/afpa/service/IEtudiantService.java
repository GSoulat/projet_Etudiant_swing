package fr.formation.afpa.service;

import java.util.List;

import fr.formation.afpa.model.Etudiant;

public interface IEtudiantService {
	
	public List<Etudiant> listEtudiant();
	
	public void ajouterEtudiant(Etudiant student);
	
	public Etudiant modifierEtudiant(Etudiant e);
	
	

}
