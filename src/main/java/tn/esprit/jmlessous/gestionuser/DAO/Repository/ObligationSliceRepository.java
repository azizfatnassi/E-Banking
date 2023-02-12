package tn.esprit.jmlessous.gestionuser.DAO.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.jmlessous.gestionuser.DAO.Entities.ObligationSlice;


@Repository

public interface ObligationSliceRepository extends JpaRepository<ObligationSlice, Long> {
	
	//@Query("SELECT s FROM ObligationSlice s WHERE s.Obligation.idObligation= :id ")
	//List<ObligationSlice> retrieveSliceByOb(@Param("id") Long id);
	
	//@Query("SELECT s FROM ObligationSlice s WHERE s.Obligation.idObligation=:id AND s.status=?true ")
	//List<ObligationSlice> SlicePayé(@Param("id") Long id); 
	
	//@Query("SELECT s FROM ObligationSlice s WHERE s.Obligation.idObligation=:id AND s.status=?false ")
	//List<ObligationSlice> SliceNonPayé(@Param("id") Long id);

}
