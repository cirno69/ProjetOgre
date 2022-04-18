package org.CYJE.Ogre.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	
@Entity
@Table(name="adherant")
public class Adherant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="dateDeNaissance") //date_de_naissance
	private String dateDeNaissance;
	
	@Column(name="promo")
	private String promo;
	
	@Column(name="campus")
	private String campus;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mailingListe") //mailing_liste	
	private Boolean mailingListe;
	
	@Column(name="cotisant")
	private int cotisant;

	@Column(name="connaissancesInfo") //connaisances_info
	private String connaissancesInfo;
	
	@Column(name="attentes") 
	private String attentes;
	
	@Column(name="centresInteret")//centres_interet
	private String centresInteret;

	//Constructeurs
	public Adherant() {
		//obligatoire pour que hibernate fonctionne
	}

	public Adherant(String nom, String prenom, String genre, String dateDeNaissance, String promo, String campus,
			String email, Boolean mailingListe, int cotisant, String connaissancesInfo, String attentes, String centresInteret) {
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.dateDeNaissance = dateDeNaissance;
		this.promo = promo;
		this.campus = campus;
		this.email = email;
		this.mailingListe = mailingListe;
		this.cotisant = cotisant;
		this.connaissancesInfo = connaissancesInfo;
		this.attentes = attentes;
		this.centresInteret=centresInteret;
	}
	
	//Getters et Setters
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getMailingListe() {
		return mailingListe;
	}

	public void setMailingListe(Boolean mailingListe) {
		this.mailingListe = mailingListe;
	}

	public int getCotisant() {
		return cotisant;
	}

	public void setCotisant(int cotisant) {
		this.cotisant = cotisant;
	}

	public String getConnaissancesInfo() {
		return connaissancesInfo;
	}

	public void setConnaissancesInfo(String connaissancesInfo) {
		this.connaissancesInfo = connaissancesInfo;
	}
	public String getAttentes() {
		return attentes;
	}

	public void setAttentes(String attentes) {
		this.attentes = attentes;
	}
	
	public void setCentresInteret(String centresInteret) {
		this.centresInteret = centresInteret;
	}
	public String getCentresInteret() {
		return centresInteret;
	}

	//toString for debugging
	@Override
	public String toString() {
		return "Adherant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", genre=" + genre + ", dateDeNaissance="
				+ dateDeNaissance + ", promo=" + promo + ", campus=" + campus + ", email=" + email + ", mailingListe="
				+ mailingListe + ", cotisant=" + cotisant + ", connaissances info=" + connaissancesInfo + ", attentes="
				+ attentes + ", centres d'interet=" + centresInteret + "]";
	}
	

	
	

	
	
	

}
