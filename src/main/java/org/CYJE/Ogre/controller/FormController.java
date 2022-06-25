package org.CYJE.Ogre.controller;

import java.util.List;

import org.CYJE.Ogre.entity.Question;
import org.CYJE.Ogre.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class FormController {
	
	private QuestionService questionService;
	
	@Autowired
	public FormController(QuestionService questionService) {
		this.questionService = questionService;
	}

	public FormController() {
	}

	@GetMapping("/form")
	public String showForm(Model model) {
		Question question = new Question();
		model.addAttribute("question", question);
		return "form";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String showEditForm(Model model, @PathVariable int id) { 
		Question question = questionService.getReponse(id);
		model.addAttribute("question", question);
		return "form";
	}

	@PostMapping("/form/save")
	public String saveReponse(@ModelAttribute("question") Question question) {
		questionService.saveReponse(question);
		return "redirect:/";
	}
	

	
	
	@PutMapping("/edit")
	public String editReponse(@ModelAttribute("question") Question question) {
		questionService.saveReponse(question);
		return "redirect:/";
	}

	
	@RequestMapping("resultats")
	public String showResults() {
		
		return "resultats";
	}

	
	@RequestMapping("/calculConsoVoiture")
	public String calculConsoVoiture(Model model, @RequestParam String emailUtilisateur) {
		List<Question> listeQ = questionService.getQuestion();
		Question q = null;
		boolean trouve = false;
		int i = 0;
		
		// Récupération des réponses de l'utilisateur
		do {
			
			if(listeQ.get(i).getEmail().equalsIgnoreCase(emailUtilisateur)) {
				trouve = true;
				q = listeQ.get(i);
			}
			else
				i++;
			
		}while(!trouve);
		
		
		if(q!=null) {
			model.addAttribute("trouve", "Voici les résultats de votre consommation en Kwh :");
		    model.addAttribute("voiture", "" + consoVoiture(q));
		    model.addAttribute("avion", "" + consoAvion(q));
		    model.addAttribute("train", "" + consoTrain(q));
		    model.addAttribute("chauffage", "" + consoChauffageProPerso(q));
		    model.addAttribute("climatisation", "" + consoClim(q));
		    model.addAttribute("taches", "" + consoTachesQuotidiennes(q));
		    model.addAttribute("nutrition", "" + consoNutrition(q));
		    model.addAttribute("eclairage", consoEclairage());
		    model.addAttribute("produitsBruns", consoProduitsBruns());
		    model.addAttribute("marchandises", consoMarchandise(q));
		    model.addAttribute("servicesPublics", servicesPublic());
		}
		else
			model.addAttribute("trouve", "Le participant lié à cet e-mail n'a pas répondu au questionnaire.");
	    
		return "resultats";
	}
	
	double consoVoiture(Question q) {
		final double valeurCalorifique = 10;
		final double nbJoursParAn = 365; 
		int distanceParAnSeul = q.getVoitureKMSeul(), distanceParAnFamille = q.getVoitureKMTous(), nbPersonnesMenage = q.getLogementEnfant() + q.getLogementAdulte();
		double consoPourCentKm = q.getVoitureConso();
		double distanceParJourSeul, distanceParLitreSeul, energieParJourSeul;
		double distanceParJourFamille, distanceParLitreFamille, energieParJourFamille, energieParJourFamillePourUnePersonne;
		
		distanceParJourSeul = (double)distanceParAnSeul / nbJoursParAn;
		distanceParLitreSeul = 100 / consoPourCentKm;
	    energieParJourSeul = ( distanceParJourSeul / distanceParLitreSeul ) * valeurCalorifique;
	    
	    distanceParJourFamille = (double)distanceParAnFamille / nbJoursParAn;
	    distanceParLitreFamille = 100 / consoPourCentKm;
	    energieParJourFamille = ( distanceParJourFamille / distanceParLitreFamille ) * valeurCalorifique;
	    energieParJourFamillePourUnePersonne = energieParJourFamille / nbPersonnesMenage;

	    return Math.round((energieParJourSeul + energieParJourFamillePourUnePersonne)*100.0)/100.0;
	}
	
	double consoAvion(Question q) {
		double distanceParcourueParAn = q.getAvionKM();
		double coefficient = (distanceParcourueParAn)/(14200*2);
		double energieConsoPassager = 11538.46 * coefficient;
		double energieConsoJour = energieConsoPassager / 365;
		
		return Math.round(energieConsoJour*100.0)/100.0;
	}

	double consoTrain(Question q) {
		double distanceParcourueParAn = q.getTrainKM();
	 	double coefficient = distanceParcourueParAn /660;
		double energieConsoPassager = 88*coefficient;
		double energieConsoJour = energieConsoPassager/365;
		
		return Math.round(energieConsoJour*100.0)/100.0;
	}

	double consoChauffageProPerso(Question q) {
		double factureAnnuelle = q.getEnergieKWH();
		double nbPersonneLogement = q.getLogementAdulte();
		double energieConsoJour = (factureAnnuelle/nbPersonneLogement)/365;
		
		return Math.round(energieConsoJour*100.0)/100.0;
	}

	double consoClim(Question q) {
		double nbPieceClimatise = q.getClimatisationPieces();
		double periodeUtilisation = q.getClimatisationsTemps();
		double energieConsoJour = (0.6*nbPieceClimatise*12*periodeUtilisation)/365;
		
		return Math.round(energieConsoJour*100.0)/100.0;
	}
	
	double consoTachesQuotidiennes(Question q) {
		//Bain et douche
		final double energiePourUneDouche = 2.8; //Kwh -> sur base d'une douche de 10 minutes avec 60 litres d'eau
		boolean prendBain = q.getBainsOUDouches()==1 ? true : false;
		double tempsDouche = q.getDoucheDuree();
		int doucheParJour = q.getDoucheFrequence();
		double energieParJourDouche = tempsDouche * doucheParJour * energiePourUneDouche;
		
		
		//Bouilloire
		final double tempsUtilisationBouilloireJour = 0.33;
		final double energieBouilloire = 2.2;
		double energieParJourBouilloire = q.getBouilloire() * energieBouilloire * tempsUtilisationBouilloireJour;
		
		
		//Plaque de cuisson électrique
		final double energiePCE = 3;
		final double tempsUtilisationPCEJour = q.getPlaqueCuisson() / 60;
		double energieParJourPCE = energiePCE * tempsUtilisationPCEJour;
		
		//Four
		final double energieFour = 3;
		final double tempsUtilisationFourJour = q.getFour() / 60;
		double energieParJourFour = energieFour * tempsUtilisationFourJour;
		
		//Four micro-ondes
		/*final double energieFMO = 1.2;
		final double tempsUtilisationFMOJour = 0.33;
		double energieParJourFMO = q.getMicroOndes() * energieFMO * tempsUtilisationFMOJour;*/
		
		//Lave-linge
		final double energieLaveLinge = 3;
		final double tempsUtilisationLaveLingeJour = q.getLaveLinge() / 60;
		double energieParJourLaveLinge = energieLaveLinge * tempsUtilisationLaveLingeJour;
		
		//Sèche-linge
		final double energieSecheLinge = 3;
		final double tempsUtilisationSecheLingeJour = q.getSecheLinge() / 60;
		double energieParJourSecheLinge = energieSecheLinge * tempsUtilisationSecheLingeJour;
		
		//Lave-vaisselle
		final double energieLaveVaisselle = 2.5;
		final double tempsUtilisationLaveVaisselleJour = q.getLaveVaisselle() / 60;
		double energieParJourLaveVaisselle = energieLaveVaisselle * tempsUtilisationLaveVaisselleJour;
		
		//Réfrigérateur
		final double energieRefrigerateur = 0.02;
		final double tempsUtilisationRefrigerateurJour = 24;
		double energieParJourRefrigerateur = q.getRefrigirateur() * energieRefrigerateur * tempsUtilisationRefrigerateurJour;
		
		//Congélateur
		final double energieCongelateur = 0.09;
		final double tempsUtilisationCongelateurJour = 24;
		double energieParJourCongelateur = q.getCongelateur() * energieCongelateur * tempsUtilisationCongelateurJour;
		
		double energieConsoJour = energieParJourDouche + energieParJourBouilloire + energieParJourPCE + energieParJourFour + energieParJourLaveLinge + energieParJourSecheLinge + energieParJourLaveVaisselle + energieParJourRefrigerateur + energieParJourCongelateur;
	
		return Math.round(energieConsoJour*100.0)/100.0;
	}
	
	double consoNutrition(Question q) {
		//energie vegetalien
		double energieVegetalien = 1.5 * q.getVegetalien();

		//energie fruit et legume
		double energieFruitLegume = 1.5 * q.getFruitETLegume();

		//energie laitier
		double energieLaitier = 1.5 * q.getProduitLaitier();

		//energie oeuf
		double energieOeuf = 1 * q.getOeufs();

		//energie viande
		double energieViande = 4 * q.getViande();

		//energie boisson
		double energieBoisson = 4 * q.getCanette();

		//energie emballage
		double energieEmballage = 4 * (q.getEmballage()==0 ? 1 : 0);

		final double energieEngrais = 2;
		final double energieAgriculture = 0.9;

		//energie chat
		double energieChat = 2 * q.getChat();

		//energie chien
		double energieChien = 9 * q.getChien();

		//energie cheval
		double energieCheval = 17 * q.getCheval();
		

		double energieConsoJour = energieVegetalien+energieFruitLegume+energieLaitier+energieOeuf+energieViande+energieBoisson+energieEmballage+energieEngrais+energieAgriculture+energieChat+energieChien+energieCheval;

		
		return Math.round(energieConsoJour*100.0)/100.0 ;
	}

	double consoEclairage() {
		final double eclairageHabitat = 2.7, eclairageBureau = 1.3, centPourCentLED = 1;
		final double energieConsoEclairageHabitat = eclairageHabitat / centPourCentLED;
		final double energieConsoEclairageBureau = eclairageBureau / centPourCentLED;
		
		return Math.round((energieConsoEclairageHabitat + energieConsoEclairageBureau)*100.0)/100.0;
	}
	
	double consoProduitsBruns() {
		final double consoInformatiqueEtAutresProduitsBruns = 5, plusDunEquipementNumParPers = 1.5; 
		final double produitsEnVeille = 0.6; //Base de 25W pendant 24h
		double energieConsoParAppreil = 0;
		double energieConsoChargeurs = 0.01;
		
		return Math.round((consoInformatiqueEtAutresProduitsBruns * plusDunEquipementNumParPers)*100.0)/100.0;
	}

	double consoMarchandise(Question q) {
		final double energieConstruction = 3;

		//energie equipement numerique reseau
		double energieNumRes = (3*q.getEquipementNumerique()*1.5)+(3*q.getInternet()*q.getVideos());

		//energiefabrication vehicule
		final double coeffTauxRemplacement = 3;
		double energieFabVehicule = coeffTauxRemplacement * 14;

		//energie materiel
		final double energieConsoMateriel = 3 * 12;

		//energie vetements
		double energieVetement = energieConsoMateriel * q.getVetements();

		//energie consommee
		double energieConsomme = energieConsoMateriel - energieVetement ;

		//energie consomme transport
		final double energieConsoTransport = 12;

		//energie finale
		double energieConsoJour = energieConstruction + energieNumRes + energieFabVehicule + energieConsomme + energieConsoTransport ;
		
		
		return energieConsoJour ;
	}
	
	double servicesPublic() {
		final double energieSecteurSante = 1.17, energieSecteurDefense = 5, energieUniversite = 0.29, energieCollectivitesLocales = 1.51;
		
		return Math.round((energieSecteurSante + energieSecteurDefense + energieUniversite + energieCollectivitesLocales)*100.0)/100.0;
	}

}
