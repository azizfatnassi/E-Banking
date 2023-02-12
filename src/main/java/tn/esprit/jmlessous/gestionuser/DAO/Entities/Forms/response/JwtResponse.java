package tn.esprit.jmlessous.gestionuser.DAO.Entities.Forms.response;


import tn.esprit.jmlessous.gestionuser.DAO.Entities.Address;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Image;

import java.util.Date;
import java.util.List;

public class JwtResponse {
  private String token;
  private String type = "Bearer";

  private Long idU;
  private String login;
  private String email;
  private String cin;
  private List<String> roles;
  private String nom;
  private String prenom;
  private Date date_naissance;
  private Address adresse;
  private String numTel;
  private String ville;
  private int codePostal;
  private Image image;

  public JwtResponse(String accessToken, Long idU, String login, String email, List<String> roles) {
    this.token = accessToken;
    this.idU = idU;
    this.login = login;
    this.email = email;
    this.roles = roles;
  }

  public JwtResponse(String accessToken, Long idU, String login, String email,String cin,String nom,String prenom,
                     Date date_naissance,Address adresse,String numTel, String ville, int codePostal,Image image, List<String> roles)
  {
    this.token = accessToken;
    this.idU = idU;
    this.login = login;
    this.email = email;
    this.cin=cin;
    this.nom=nom;
    this.prenom=prenom;
    this.date_naissance=date_naissance;
    this.adresse=adresse;
    this.numTel=numTel;
    this.ville=ville;
    this.codePostal=codePostal;
    this.image=image;
    this.roles = roles;
  }



    public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public Long getIdU() {
    return idU;
  }

  public void setIdU(Long idU) {
    this.idU = idU;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCin() {
    return cin;
  }

  public void setCin(String cin) {
    this.cin = cin;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public Date getDate_naissance() {
    return date_naissance;
  }

  public void setDate_naissance(Date date_naissance) {
    this.date_naissance = date_naissance;
  }

  public Address getAdresse() {
    return adresse;
  }

  public void setAdresse(Address adresse) {
    this.adresse = adresse;
  }

  public String getNumTel() {
    return numTel;
  }

  public void setNumTel(String numTel) {
    this.numTel = numTel;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  public int getCodePostal() {
    return codePostal;
  }

  public void setCodePostal(int codePostal) {
    this.codePostal = codePostal;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }
}
