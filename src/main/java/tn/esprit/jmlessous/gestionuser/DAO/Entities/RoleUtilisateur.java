package tn.esprit.jmlessous.gestionuser.DAO.Entities;


import javax.persistence.*;

@Entity
public class RoleUtilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idR;

    @Enumerated(EnumType.STRING)
    private ERoleUtilisateur name;

    public RoleUtilisateur() {
    }

    public RoleUtilisateur(ERoleUtilisateur name) {
        this.name = name;
    }

    public Long getIdR() {
        return idR;
    }

    public void setIdR(Long idR) {
        this.idR = idR;
    }

    public ERoleUtilisateur getName() {
        return name;
    }

    public void setName(ERoleUtilisateur name) {
        this.name = name;
    }
}
