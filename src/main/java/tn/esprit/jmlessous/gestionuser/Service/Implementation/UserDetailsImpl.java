package tn.esprit.jmlessous.gestionuser.Service.Implementation;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Address;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Image;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Utilisateur;


import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long idU;

  private String login;

  private String email;

  private String cin;

  @JsonIgnore
  private String password;

  private String nom;

  private String prenom;


  private Date date_naissance;

  private Address adresse;

  private String numTel;

  private String ville;

  private int codePostal;

  private Image image;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(Long idU, String login, String email, String cin , String password, String nom, String prenom , Date date_naissance,
                         Address addresse, String ville, int codePostal, Image image, Collection<? extends GrantedAuthority> authorities) {
    this.idU = idU;
    this.login = login;
    this.email = email;
    this.cin=cin;
    this.password = password;
    this.nom=nom;
    this.prenom=prenom;
    this.date_naissance=date_naissance;
    this.adresse=addresse;
    this.ville=ville;
    this.codePostal=codePostal;
    this.image=image;
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(Utilisateur user) {
    List<GrantedAuthority> authorities = user.getRoleUtilisateurs().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImpl(
            user.getIdU(),
            user.getLogin(),
            user.getEmail(),
            user.getCin(),
            user.getPassword(),
            user.getNom(),
            user.getPrenom(),
            user.getDate_naissance(),
            user.getAdresse() ,
            user.getVille(),
            user.getCodePostal(),
            user.getImage(),
            authorities);
    }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Long getId() {
    return idU;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return login;
  }

  public String getCin() {
    return cin;
  }

  public String getNom() {
    return nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public Date getDate_naissance() {
    return date_naissance;
  }

  public Address getAdresse() {
    return adresse;
  }

  public String getNumTel() {
    return numTel;
  }

  public String getVille() {
    return ville;
  }

  public int getCodePostal() {
    return codePostal;
  }


  public Image getImage() {
    return image;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(idU, user.idU);
  }
}
