package tn.esprit.jmlessous.gestionuser.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.ERoleUtilisateur;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Image;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.RoleUtilisateur;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Utilisateur;
import tn.esprit.jmlessous.gestionuser.DAO.Repository.ImageRepository;
import tn.esprit.jmlessous.gestionuser.DAO.Repository.RoleUtilisateurRepository;
import tn.esprit.jmlessous.gestionuser.DAO.Repository.UtilisateurRepository;
import tn.esprit.jmlessous.gestionuser.Service.Interface.UtilisateurService;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    RoleUtilisateurRepository roleUtilisateurRepository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    PasswordEncoder encoder;


    @Override
    public List<Utilisateur> getAllUtilisateur() {
        return (List<Utilisateur>) utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur addUtilisateur(Utilisateur u) {
        return utilisateurRepository.save(u);
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur u) {
        return utilisateurRepository.save(u);
    }

    @Override
    public void deleteUtilisateurById(Long idU) {
         utilisateurRepository.deleteById(idU);
    }

    @Override
    public void AddRoleToUtilisateur(Utilisateur u, ERoleUtilisateur eRoleUtilisateur) {

        RoleUtilisateur roleUtilisateur=roleUtilisateurRepository.findByName(eRoleUtilisateur).get();
        u.getRoleUtilisateurs().add(roleUtilisateur);
        utilisateurRepository.save(u);

    }

    @Override
    public void AddImageToUtilisateur(Long idU, String image) {
        Utilisateur u= utilisateurRepository.findById(idU).get();
        Image image1=imageRepository.findByName(image).get();
        if(u.getImage().getId() != 1)
        imageRepository.deleteById(u.getImage().getId());
        u.setImage(image1);
        utilisateurRepository.save(u);
    }

    @Override
    public void AddImageToUtilisateur(Long idU, Long imageId) {
        Utilisateur u= utilisateurRepository.findById(idU).get();
        Image image1=imageRepository.findById(imageId).get();
        u.setImage(image1);
        utilisateurRepository.save(u);
    }

    @Override
    public Utilisateur getUtilisateurByLogin(String login) {
        return utilisateurRepository.findByLogin(login).get();
    }

    @Override
    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id).get();
    }
}
