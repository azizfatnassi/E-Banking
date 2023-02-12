package tn.esprit.jmlessous.gestionuser.DAO.Entities;

import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Obligation implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idObligation;
	private String nomEmetteur;
	private Long valeurNom;
	private Long coupons;
	private float taux;
	private float tauxCoupon;
	private LocalDate dateEmission;
	private LocalDate echeance;
	private Long periode;
	private String devise;
	private double tauxChange;

	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="obligation")
	private Set<ObligationSlice> obslice;
	
	
	


	public Long getIdObligation() {
		return idObligation;
	}





	public void setIdObligation(Long idObligation) {
		this.idObligation = idObligation;
	}





	public double getTauxChange() {
		return tauxChange;
	}





	public void setTauxChange( String devise) {
        try {
        	URL url = new URL("http://data.fixer.io/api/latest?access_key=oXpVpcaRvBzwqeRMsoBjRKxv9DMajUBO&base=TND&symbols=" + devise);
        	Scanner scanner = new Scanner(url.openStream());
            String response = scanner.nextLine();
            scanner.close();

            // Parser la réponse JSON et récupérer le taux de change
            // ...

            this.tauxChange = tauxChange;
        } catch (Exception e) {
            // Gestion des erreurs
            e.printStackTrace();
        }
    }




	public String getDevise() {
		return devise;
	}





	public void setDevise(String devise) {
		this.devise = devise;
	}





	public String getNomEmetteur() {
		return nomEmetteur;
	}





	public void setNomEmetteur(String nomEmetteur) {
		this.nomEmetteur = nomEmetteur;
	}





	public Long getValeurNom() {
		return valeurNom;
	}





	public void setValeurNom(Long valeurNom) {
		this.valeurNom = valeurNom;
	}





	public Long getCoupons() {
		return coupons;
	}





	public void setCoupons(Long coupons) {
		this.coupons = coupons;
	}





	public float getTaux() {
		return taux;
	}





	public void setTaux(float taux) {
		this.taux = taux;
	}





	public float getTauxCoupon() {
		return tauxCoupon;
	}





	public void setTauxCoupon(float tauxCoupon) {
		this.tauxCoupon = tauxCoupon;
	}





	public LocalDate getDateEmission() {
		return dateEmission;
	}





	public void setDateEmission(LocalDate dateEmission) {
		this.dateEmission = dateEmission;
	}





	public LocalDate getEcheance() {
		return echeance;
	}





	public void setEcheance(LocalDate echeance) {
		this.echeance = echeance;
	}


	public Long getPeriode() {
		return periode;
	}





	public void setPeriode(Long periode) {
		this.periode = periode;
	}







	public Set<ObligationSlice> getObslice() {
		return obslice;
	}





	public void setObslice(Set<ObligationSlice> obslice) {
		this.obslice = obslice;
	}

	public Obligation(Long idObligation, String nomEmetteur, Long valeurNom, Long coupons, float taux, float tauxCoupon,
			LocalDate dateEmission, LocalDate echeance, Long periode, String devise, double tauxChange,
		 Set<ObligationSlice> obslice) {
		super();
		this.idObligation = idObligation;
		this.nomEmetteur = nomEmetteur;
		this.valeurNom = valeurNom;
		this.coupons = coupons;
		this.taux = taux;
		this.tauxCoupon = tauxCoupon;
		this.dateEmission = dateEmission;
		this.echeance = echeance;
		this.periode = periode;
		this.devise = devise;
		this.tauxChange = tauxChange;
	
		this.obslice = obslice;
	}





	public Obligation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
