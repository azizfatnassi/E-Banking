package tn.esprit.jmlessous.gestionuser.DAO.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class ObligationSlice implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSlice;
	private String nomObligation;
	private Long valeurNom;
	private double prix;
	private Long coupons;
	private float taux;
	private LocalDate dateachat;
	private LocalDate echeance;
	private LocalDate datePayment;
	private boolean status;
	private LocalDate dernierCoupon;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_obligation")
	private Obligation obligation;
	public Long getIdSlice() {
		return idSlice;
	}
	public void setIdSlice(Long idSlice) {
		this.idSlice = idSlice;
	}
	public String getNomObligation() {
		return nomObligation;
	}
	public void setNomObligation(String nomObligation) {
		this.nomObligation = nomObligation;
	}
	public Long getValeurNom() {
		return valeurNom;
	}
	public void setValeurNom(Long valeurNom) {
		this.valeurNom = valeurNom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
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
	public LocalDate getDateachat() {
		return dateachat;
	}
	public void setDateachat(LocalDate dateachat) {
		this.dateachat = dateachat;
	}
	public LocalDate getEcheance() {
		return echeance;
	}
	public void setEcheance(LocalDate echeance) {
		this.echeance = echeance;
	}
	public LocalDate getDatePayment() {
		return datePayment;
	}
	public void setDatePayment(LocalDate datePayment) {
		this.datePayment = datePayment;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public LocalDate getDernierCoupon() {
		return dernierCoupon;
	}
	public void setDernierCoupon(LocalDate dernierCoupon) {
		this.dernierCoupon = dernierCoupon;
	}
	public Obligation getObligation() {
		return obligation;
	}
	public void setObligation(Obligation obligation) {
		this.obligation = obligation;
	}
	public ObligationSlice(Long idSlice, String nomObligation, Long valeurNom, double prix, Long coupons, float taux,
			LocalDate dateachat, LocalDate echeance, LocalDate datePayment, boolean status, LocalDate dernierCoupon,
			Obligation obligation) {
		super();
		this.idSlice = idSlice;
		this.nomObligation = nomObligation;
		this.valeurNom = valeurNom;
		this.prix = prix;
		this.coupons = coupons;
		this.taux = taux;
		this.dateachat = dateachat;
		this.echeance = echeance;
		this.datePayment = datePayment;
		this.status = status;
		this.dernierCoupon = dernierCoupon;
		this.obligation = obligation;
	}
	public ObligationSlice() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
}
