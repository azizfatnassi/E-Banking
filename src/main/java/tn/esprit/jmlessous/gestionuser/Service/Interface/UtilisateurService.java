package tn.esprit.jmlessous.gestionuser.Service.Interface;

import tn.esprit.jmlessous.gestionuser.DAO.Entities.ERoleUtilisateur;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Image;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Utilisateur;

import java.util.*;

public interface UtilisateurService {

    List<Utilisateur> getAllUtilisateur();
    Utilisateur addUtilisateur(Utilisateur u);
    Utilisateur updateUtilisateur(Utilisateur u);
    void deleteUtilisateurById(Long idU);
    void AddRoleToUtilisateur(Utilisateur u , ERoleUtilisateur eRoleUtilisateur);
    void AddImageToUtilisateur(Long idU , String image);
    void AddImageToUtilisateur(Long idU , Long imageId);
    Utilisateur getUtilisateurByLogin(String Login );
    Utilisateur getUtilisateurById(Long id );
}
