package tn.esprit.jmlessous.gestionuser.DAO.Entities.Forms.request;

import tn.esprit.jmlessous.gestionuser.DAO.Entities.Address;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.ERoleUtilisateur;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Image;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String login;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;


  @NotBlank
  @Size(min = 8, max = 8)
  private String cin;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;


  private String nom;

  private String prenom;


  private Date date_naissance;

  private Address adresse;

  private String numTel;

  private String ville;

  private int codePostal;

  private Image image;

  private int salary;

  private ERoleUtilisateur role;

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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


  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  public void setCodePostal(int codePostal) {
    this.codePostal = codePostal;
  }

  public ERoleUtilisateur getRole() {
    return role;
  }

  public void setRole(ERoleUtilisateur role) {
    this.role = role;
  }

  public int getSalary() {
    return salary;
  }

  public Address getAdresse() {
    return adresse;
  }

  public void setAdresse(Address adresse) {
    this.adresse = adresse;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }
}
