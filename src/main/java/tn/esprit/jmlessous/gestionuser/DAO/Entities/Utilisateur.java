package tn.esprit.jmlessous.gestionuser.DAO.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idU;

    private String login;

    private String email;

    private String cin;

    private String password;

    private String nom;

    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date date_naissance;

    @Enumerated(EnumType.STRING)
    private Address adresse;

    private String numTel;

    private String ville;

    private int codePostal;



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "utilisateur_role_utilisateurs",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "role_utilisateurs_id"))
    private Set<RoleUtilisateur> roleUtilisateurs = new LinkedHashSet<>();

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @OneToMany(mappedBy = "fkClient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<InsurenceContract> insurenceContracts = new LinkedHashSet<>();

    @Column(name = "salary")
    private Integer salary;


    public Utilisateur(Long idU, String login, String email, String cin, String password, String nom, String prenom, Date date_naissance, Address adresse, String numTel, String ville, int codePostal, Set<RoleUtilisateur> roleUtilisateurs, Image image, Integer salary) {
        this.idU = idU;
        this.login = login;
        this.email = email;
        this.cin = cin;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.numTel = numTel;
        this.ville = ville;
        this.codePostal = codePostal;
        this.roleUtilisateurs = roleUtilisateurs;
        this.image = image;
        this.salary = salary;
    }

    public Utilisateur( String login, String email, String cin, String password, String nom, String prenom, Date date_naissance, Address adresse, String numTel, String ville, int codePostal, Set<RoleUtilisateur> roleUtilisateurs, Image image, Integer salary) {

        this.login = login;
        this.email = email;
        this.cin = cin;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.numTel = numTel;
        this.ville = ville;
        this.codePostal = codePostal;
        this.roleUtilisateurs = roleUtilisateurs;
        this.image = image;
        this.salary = salary;
    }

    public Utilisateur(String login, String email, String cin, String password, String nom, String prenom, Date date_naissance, Address adresse, String numTel, String ville, int codePostal, Image image, int salary) {
        this.login = login;
        this.email = email;
        this.cin = cin;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse =  adresse;
        this.numTel = numTel;
        this.ville = ville;
        this.codePostal = codePostal;
        this.roleUtilisateurs = roleUtilisateurs;
        this.image = image;
        this.salary = salary;
    }
}
