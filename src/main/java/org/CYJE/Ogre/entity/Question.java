package org.CYJE.Ogre.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	
@Entity
@Table(name="questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="prenom")
	private String prenom;
	@Column(name="email")
	private String email;
	@Column(name="pays")
	private String pays;
	@Column(name="voiturePossede")
	private int voiturePossede;
	@Column(name="voitureKM")
	private int voitureKM;
	@Column(name="voitureEnergie")
	private String voitureEnergie;
	@Column(name="voitureConso")
	private int voitureConso;
	@Column(name="voitureKMSeul")
	private int voitureKMSeul;
	@Column(name="voitureKMTous")
	private int voitureKMTous;
	@Column(name="voitureRemplacement")
	private String voitureRemplacement;
	@Column(name="avionKM")
	private int avionKM;
	@Column(name="trainKM")
	private int trainKM;
	@Column(name="logementAdulte")
	private int logementAdulte;
	@Column(name="logementEnfant")
	private int logementEnfant;
	@Column(name="logementType")
	private String logementType;
	@Column(name="logementSurface")
	private int logementSurface;
	@Column(name="chauffageEnergie")
	private String chauffageEnergie;
	@Column(name="energieKWH")
	private int energieKWH;
	@Column(name="energieFacture")
	private int energieFacture;
	@Column(name="pompeChaleur")
	private int pompeChaleur;
	@Column(name="temperatureConfort")
	private int temperatureConfort;
	@Column(name="climatisation")
	private int climatisation;
	@Column(name="climatisationPieces")
	private int climatisationPieces;
	@Column(name="climatisationsTemps")
	private int climatisationsTemps;
	@Column(name="bainsOUDouches")
	private String bainsOUDouches;
	@Column(name="doucheFrequence")
	private int doucheFrequence;
	@Column(name="doucheDuree")
	private String doucheDuree;
	@Column(name="bouilloire")
	private int bouilloire;
	@Column(name="plaqueCuisson")
	private int plaqueCuisson;
	@Column(name="four")
	private int four;
	@Column(name="laveLinge")
	private int laveLinge;
	@Column(name="secheLinge")
	private int secheLinge;
	@Column(name="laveVaisselle")
	private int laveVaisselle;
	@Column(name="refrigirateur")
	private int refrigirateur;
	@Column(name="congelateur")
	private int congelateur;
	@Column(name="eclairage")
	private String eclairage;
	@Column(name="vegetalien")
	private int vegetalien;
	@Column(name="fruitETLegume")
	private int fruitETLegume;
	@Column(name="produitLaitier")
	private int produitLaitier;
	@Column(name="oeufs")
	private int oeufs;
	@Column(name="viande")
	private int viande;
	@Column(name="canette")
	private int canette;
	@Column(name="emballage")
	private int emballage;
	@Column(name="locaux")
	private int locaux;
	@Column(name="chat")
	private int chat;
	@Column(name="chien")
	private int chien;
	@Column(name="cheval")
	private int cheval;
	@Column(name="equipementNumerique")
	private int equipementNumerique;
	@Column(name="internet")
	private int internet;
	@Column(name="videos")
	private int videos;
	@Column(name="vetements")
	private int vetements;


	//Constructeurs
	public Question() {
		//obligatoire pour que hibernate fonctionne
	}

	public Question(int id, String prenom, String email, String pays, int voiturePossede, int voitureKM, String voitureEnergie, int voitureConso, int voitureKMSeul, int voitureKMTous, String voitureRemplacement, int avionKM, int trainKM, int logementAdulte, int logementEnfant, String logementType, int logementSurface, String chauffageEnergie, int energieKWH, int energieFacture, int pompeChaleur, int temperatureConfort, int climatisation, int climatisationPieces, int climatisationsTemps, String bainsOUDouches, int doucheFrequence, String doucheDuree, int bouilloire, int plaqueCuisson, int four, int laveLinge, int secheLinge, int laveVaisselle, int refrigirateur, int congelateur, String eclairage, int vegetalien, int fruitETLegume, int produitLaitier, int oeufs, int viande, int canette, int emballage, int locaux, int chat, int chien, int cheval, int equipementNumerique, int internet, int videos, int vetements) {
		this.id = id;
		this.prenom = prenom;
		this.email = email;
		this.pays = pays;
		this.voiturePossede = voiturePossede;
		this.voitureKM = voitureKM;
		this.voitureEnergie = voitureEnergie;
		this.voitureConso = voitureConso;
		this.voitureKMSeul = voitureKMSeul;
		this.voitureKMTous = voitureKMTous;
		this.voitureRemplacement = voitureRemplacement;
		this.avionKM = avionKM;
		this.trainKM = trainKM;
		this.logementAdulte = logementAdulte;
		this.logementEnfant = logementEnfant;
		this.logementType = logementType;
		this.logementSurface = logementSurface;
		this.chauffageEnergie = chauffageEnergie;
		this.energieKWH = energieKWH;
		this.energieFacture = energieFacture;
		this.pompeChaleur = pompeChaleur;
		this.temperatureConfort = temperatureConfort;
		this.climatisation = climatisation;
		this.climatisationPieces = climatisationPieces;
		this.climatisationsTemps = climatisationsTemps;
		this.bainsOUDouches = bainsOUDouches;
		this.doucheFrequence = doucheFrequence;
		this.doucheDuree = doucheDuree;
		this.bouilloire = bouilloire;
		this.plaqueCuisson = plaqueCuisson;
		this.four = four;
		this.laveLinge = laveLinge;
		this.secheLinge = secheLinge;
		this.laveVaisselle = laveVaisselle;
		this.refrigirateur = refrigirateur;
		this.congelateur = congelateur;
		this.eclairage = eclairage;
		this.vegetalien = vegetalien;
		this.fruitETLegume = fruitETLegume;
		this.produitLaitier = produitLaitier;
		this.oeufs = oeufs;
		this.viande = viande;
		this.canette = canette;
		this.emballage = emballage;
		this.locaux = locaux;
		this.chat = chat;
		this.chien = chien;
		this.cheval = cheval;
		this.equipementNumerique = equipementNumerique;
		this.internet = internet;
		this.videos = videos;
		this.vetements = vetements;
	}
	
	//Getters et Setters
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom(){
		return prenom;
	}

	public void setPrenom(String prenom){
		this.prenom=prenom;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public String getPays(){
		return pays;
	}

	public void setPays(String pays){
		this.pays=pays;
	}

	public int getVoiturepossede(){
		return voiturePossede;
	}

	public void setVoiturepossede(int voiturePossede){
		this.voiturePossede=voiturePossede;
	}

	public int getVoiturekm(){
		return voitureKM;
	}

	public void setVoiturekm(int voitureKM){
		this.voitureKM=voitureKM;
	}

	public String getVoitureenergie(){
		return voitureEnergie;
	}

	public void setVoitureenergie(String voitureEnergie){
		this.voitureEnergie=voitureEnergie;
	}

	public int getVoitureconso(){
		return voitureConso;
	}

	public void setVoitureconso(int voitureConso){
		this.voitureConso=voitureConso;
	}

	public int getVoiturekmseul(){
		return voitureKMSeul;
	}

	public void setVoiturekmseul(int voitureKMSeul){
		this.voitureKMSeul=voitureKMSeul;
	}

	public int getVoiturekmtous(){
		return voitureKMTous;
	}

	public void setVoiturekmtous(int voitureKMTous){
		this.voitureKMTous=voitureKMTous;
	}

	public String getVoitureremplacement(){
		return voitureRemplacement;
	}

	public void setVoitureremplacement(String voitureRemplacement){
		this.voitureRemplacement=voitureRemplacement;
	}

	public int getAvionkm(){
		return avionKM;
	}

	public void setAvionkm(int avionKM){
		this.avionKM=avionKM;
	}

	public int getTrainkm(){
		return trainKM;
	}

	public void setTrainkm(int trainKM){
		this.trainKM=trainKM;
	}

	public int getLogementadulte(){
		return logementAdulte;
	}

	public void setLogementadulte(int logementAdulte){
		this.logementAdulte=logementAdulte;
	}

	public int getLogementenfant(){
		return logementEnfant;
	}

	public void setLogementenfant(int logementEnfant){
		this.logementEnfant=logementEnfant;
	}

	public String getLogementtype(){
		return logementType;
	}

	public void setLogementtype(String logementType){
		this.logementType=logementType;
	}

	public int getLogementsurface(){
		return logementSurface;
	}

	public void setLogementsurface(int logementSurface){
		this.logementSurface=logementSurface;
	}

	public String getChauffageenergie(){
		return chauffageEnergie;
	}

	public void setChauffageenergie(String chauffageEnergie){
		this.chauffageEnergie=chauffageEnergie;
	}

	public int getEnergiekwh(){
		return energieKWH;
	}

	public void setEnergiekwh(int energieKWH){
		this.energieKWH=energieKWH;
	}

	public int getEnergiefacture(){
		return energieFacture;
	}

	public void setEnergiefacture(int energieFacture){
		this.energieFacture=energieFacture;
	}

	public int getPompechaleur(){
		return pompeChaleur;
	}

	public void setPompechaleur(int pompeChaleur){
		this.pompeChaleur=pompeChaleur;
	}

	public int getTemperatureconfort(){
		return temperatureConfort;
	}

	public void setTemperatureconfort(int temperatureConfort){
		this.temperatureConfort=temperatureConfort;
	}

	public int getClimatisation(){
		return climatisation;
	}

	public void setClimatisation(int climatisation){
		this.climatisation=climatisation;
	}

	public int getClimatisationpieces(){
		return climatisationPieces;
	}

	public void setClimatisationpieces(int climatisationPieces){
		this.climatisationPieces=climatisationPieces;
	}

	public int getClimatisationstemps(){
		return climatisationsTemps;
	}

	public void setClimatisationstemps(int climatisationsTemps){
		this.climatisationsTemps=climatisationsTemps;
	}

	public String getBainsoudouches(){
		return bainsOUDouches;
	}

	public void setBainsoudouches(String bainsOUDouches){
		this.bainsOUDouches=bainsOUDouches;
	}

	public int getDouchefrequence(){
		return doucheFrequence;
	}

	public void setDouchefrequence(int doucheFrequence){
		this.doucheFrequence=doucheFrequence;
	}

	public String getDoucheduree(){
		return doucheDuree;
	}

	public void setDoucheduree(String doucheDuree){
		this.doucheDuree=doucheDuree;
	}

	public int getBouilloire(){
		return bouilloire;
	}

	public void setBouilloire(int bouilloire){
		this.bouilloire=bouilloire;
	}

	public int getPlaquecuisson(){
		return plaqueCuisson;
	}

	public void setPlaquecuisson(int plaqueCuisson){
		this.plaqueCuisson=plaqueCuisson;
	}

	public int getFour(){
		return four;
	}

	public void setFour(int four){
		this.four=four;
	}

	public int getLavelinge(){
		return laveLinge;
	}

	public void setLavelinge(int laveLinge){
		this.laveLinge=laveLinge;
	}

	public int getSechelinge(){
		return secheLinge;
	}

	public void setSechelinge(int secheLinge){
		this.secheLinge=secheLinge;
	}

	public int getLavevaisselle(){
		return laveVaisselle;
	}

	public void setLavevaisselle(int laveVaisselle){
		this.laveVaisselle=laveVaisselle;
	}

	public int getRefrigirateur(){
		return refrigirateur;
	}

	public void setRefrigirateur(int refrigirateur){
		this.refrigirateur=refrigirateur;
	}

	public int getCongelateur(){
		return congelateur;
	}

	public void setCongelateur(int congelateur){
		this.congelateur=congelateur;
	}

	public String getEclairage(){
		return eclairage;
	}

	public void setEclairage(String eclairage){
		this.eclairage=eclairage;
	}

	public int getVegetalien(){
		return vegetalien;
	}

	public void setVegetalien(int vegetalien){
		this.vegetalien=vegetalien;
	}

	public int getFruitetlegume(){
		return fruitETLegume;
	}

	public void setFruitetlegume(int fruitETLegume){
		this.fruitETLegume=fruitETLegume;
	}

	public int getProduitlaitier(){
		return produitLaitier;
	}

	public void setProduitlaitier(int produitLaitier){
		this.produitLaitier=produitLaitier;
	}

	public int getOeufs(){
		return oeufs;
	}

	public void setOeufs(int oeufs){
		this.oeufs=oeufs;
	}

	public int getViande(){
		return viande;
	}

	public void setViande(int viande){
		this.viande=viande;
	}

	public int getCanette(){
		return canette;
	}

	public void setCanette(int canette){
		this.canette=canette;
	}

	public int getEmballage(){
		return emballage;
	}

	public void setEmballage(int emballage){
		this.emballage=emballage;
	}

	public int getLocaux(){
		return locaux;
	}

	public void setLocaux(int locaux){
		this.locaux=locaux;
	}

	public int getChat(){
		return chat;
	}

	public void setChat(int chat){
		this.chat=chat;
	}

	public int getChien(){
		return chien;
	}

	public void setChien(int chien){
		this.chien=chien;
	}

	public int getCheval(){
		return cheval;
	}

	public void setCheval(int cheval){
		this.cheval=cheval;
	}

	public int getEquipementnumerique(){
		return equipementNumerique;
	}

	public void setEquipementnumerique(int equipementNumerique){
		this.equipementNumerique=equipementNumerique;
	}

	public int getInternet(){
		return internet;
	}

	public void setInternet(int internet){
		this.internet=internet;
	}

	public int getVideos(){
		return videos;
	}

	public void setVideos(int videos){
		this.videos=videos;
	}

	public int getVetements(){
		return vetements;
	}

	public void setVetements(int vetements){
		this.vetements=vetements;
	}

	

	
	

	
	
	

}
