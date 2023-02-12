package tn.esprit.jmlessous.gestionuser.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.ERoleUtilisateur;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Forms.request.SignupRequest;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Forms.response.MessageResponse;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Image;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Utilisateur;
import tn.esprit.jmlessous.gestionuser.DAO.Repository.ImageRepository;
import tn.esprit.jmlessous.gestionuser.DAO.Repository.UtilisateurRepository;
import tn.esprit.jmlessous.gestionuser.Service.Implementation.ImageUtility;
import tn.esprit.jmlessous.gestionuser.Service.Interface.UtilisateurService;

import java.io.IOException;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/utilisateur")

public class UtilisateurController {

    @Autowired
    UtilisateurService utilisateurService ;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/newUtilisateur")
    @ResponseBody
    Utilisateur newUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.addUtilisateur(utilisateur);
    }

    @GetMapping("/getUtilisateurByLogin/{login}")
    public Utilisateur getUtilisateurByLogin(@PathVariable("login") String login){
        return utilisateurService.getUtilisateurByLogin(login);
    }

    @GetMapping("/getUtilisateurById/{id}")
    public Utilisateur getUtilisateurByLogin(@PathVariable("id") Long id){
        return utilisateurService.getUtilisateurById(id);
    }

    @GetMapping("/getAllUtilisateurs")
    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurService.getAllUtilisateur();
    }

    @DeleteMapping("deleteUtilisateurById/{id}")
    public void deleteUtilisateurById(@PathVariable("id")Long id){
        utilisateurService.deleteUtilisateurById(id);
    }

    @PostMapping("addUtilisateur")

    public ResponseEntity<?> addUtilisateur(@RequestBody SignupRequest u)
    {
        if (utilisateurRepository.existsByLogin(u.getLogin())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        u.setPassword(encoder.encode(u.getPassword()));
        Utilisateur utilisateur = new Utilisateur(u.getLogin(),u.getEmail(),u.getCin(),u.getPassword(),
                u.getNom(),u.getPrenom(),u.getDate_naissance(),u.getAdresse(),u.getNumTel(),u.getVille(),u.getCodePostal(),u.getImage() , u.getSalary());
        utilisateurService.addUtilisateur(utilisateur);
        utilisateurService.AddRoleToUtilisateur(utilisateur,u.getRole());
        utilisateurService.AddImageToUtilisateur(utilisateur.getIdU(),1L);
        utilisateurService.updateUtilisateur(utilisateur);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

    }


    /////////////////////////Upload Image/////////////////////////////////////////////////////Upload Image/////////////////////////////////////////////////////Upload Image////////////////////////////
    @PostMapping("/upload/image/{id}")
    public ResponseEntity<MessageResponse> uplaodImage(@RequestParam("image") MultipartFile file,@PathVariable("id")Long id)
            throws IOException {
        System.out.println("ID : "+id);
        System.out.println("MultipartFile : "+file);
        imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());
        Utilisateur utilisateur=utilisateurService.getUtilisateurById(id);
        utilisateurService.AddImageToUtilisateur(id, file.getOriginalFilename());
        utilisateurService.updateUtilisateur(utilisateur);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageResponse("Image uploaded successfully: " +
                        file.getOriginalFilename()));
    }

    @GetMapping(path = {"/get/image/info/{name}"})
    public Image getImageDetails(@PathVariable("name") String name) throws IOException {

        final Optional<Image> dbImage = imageRepository.findByName(name);

        return Image.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(ImageUtility.decompressImage(dbImage.get().getImage())).build();
    }





    /////////////////////////Upload Image/////////////////////////////////////////////////////Upload Image/////////////////////////////////////////////////////Upload Image////////////////////////////


    @PutMapping("updateUtilisateur")

    public Utilisateur updateUtilisateur(@RequestBody SignupRequest  u){
        Utilisateur utilisateur =utilisateurService.getUtilisateurByLogin(u.getLogin());
        utilisateur.setAdresse(u.getAdresse());
        utilisateur.setVille(u.getVille());
        utilisateur.setCodePostal(u.getCodePostal());
        utilisateur.setNumTel(u.getNumTel());
        utilisateur.setNom(u.getNom());
        utilisateur.setPrenom(u.getPrenom());
        utilisateur.setDate_naissance(u.getDate_naissance());
        return utilisateurService.updateUtilisateur(utilisateur);
    }



}
