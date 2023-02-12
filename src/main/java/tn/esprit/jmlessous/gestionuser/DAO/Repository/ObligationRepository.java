package tn.esprit.jmlessous.gestionuser.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.jmlessous.gestionuser.DAO.Entities.Obligation;


 @Repository
public interface ObligationRepository extends JpaRepository<Obligation, Long> {

	
	
}
