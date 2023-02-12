package tn.esprit.jmlessous.gestionuser.DAO.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Image;


public interface ImageRepository extends JpaRepository<Image, Long> {
	Optional<Image> findByName(String name);
}
