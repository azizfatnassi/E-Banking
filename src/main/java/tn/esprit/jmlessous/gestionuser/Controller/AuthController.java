package tn.esprit.jmlessous.gestionuser.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.esprit.jmlessous.gestionuser.Configuration.Security.JwtUtils;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.ERoleUtilisateur;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Forms.request.LoginRequest;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Forms.request.SignupRequest;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Forms.response.JwtResponse;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Forms.response.MessageResponse;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Utilisateur;
import tn.esprit.jmlessous.gestionuser.DAO.Repository.RoleUtilisateurRepository;
import tn.esprit.jmlessous.gestionuser.DAO.Repository.UtilisateurRepository;
import tn.esprit.jmlessous.gestionuser.Service.Implementation.UserDetailsImpl;
import tn.esprit.jmlessous.gestionuser.Service.Interface.UtilisateurService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UtilisateurRepository utilisateurRepository;

  @Autowired
  RoleUtilisateurRepository roleUtilisateurRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  UtilisateurService utilisateurService;

  @PostMapping("/login")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt,
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(),
                         userDetails.getCin(),
                         userDetails.getNom(),
                         userDetails.getPrenom(),
                         userDetails.getDate_naissance(),
                         userDetails.getAdresse(),
                         userDetails.getNumTel(),
                         userDetails.getVille(),
                         userDetails.getCodePostal(),
                         userDetails.getImage(),
                         roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest u) {
    if (utilisateurRepository.existsByLogin(u.getLogin())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    u.setPassword(encoder.encode(u.getPassword()));
    Utilisateur utilisateur = new Utilisateur(u.getLogin(),u.getEmail(),u.getCin(),u.getPassword(),
            u.getNom(),u.getPrenom(),u.getDate_naissance() ,u.getAdresse() , u.getNumTel(),u.getVille(),u.getCodePostal(),u.getImage() , u.getSalary() );
    utilisateurService.addUtilisateur(utilisateur);
    utilisateurService.AddRoleToUtilisateur(utilisateur,u.getRole());
    utilisateurService.AddImageToUtilisateur(utilisateur.getIdU(),1L);
    utilisateurService.updateUtilisateur(utilisateur);
    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));



  }


}
