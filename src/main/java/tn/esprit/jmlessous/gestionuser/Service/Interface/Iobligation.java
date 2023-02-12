package tn.esprit.jmlessous.gestionuser.Service.Interface;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.jmlessous.gestionuser.DAO.Entities.Obligation;



@Service
public interface Iobligation {
    Obligation retrieveObligation(Long id);
	Obligation addObligation(Obligation o);
	Obligation updatObligation(Obligation o);
	void deleteObligation(Long id);
	List<Obligation> findall();
	double Duration(Long id);
	
	double Sensibilité(Long id);
	double PrixObligation2(Obligation o);
	String simulateur(Long id);
	double Capitalisation(Obligation id);
	Obligation comparaison();
	
}
