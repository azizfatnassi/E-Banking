package tn.esprit.jmlessous.gestionuser.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Utilisateur;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByLogin(String login);
    Boolean existsByLogin(String login);

    Utilisateur findByCin( String  cin );
}
