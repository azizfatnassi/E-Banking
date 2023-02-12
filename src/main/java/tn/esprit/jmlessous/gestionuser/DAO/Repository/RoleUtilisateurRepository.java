package tn.esprit.jmlessous.gestionuser.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.ERoleUtilisateur;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.RoleUtilisateur;

import java.util.Optional;

public interface RoleUtilisateurRepository extends JpaRepository<RoleUtilisateur,Long> {
    Optional<RoleUtilisateur> findByName(ERoleUtilisateur name);
}
