package org.CYJE.Ogre.controller;

import java.util.List;

import org.CYJE.Ogre.entity.Adherant;
import org.CYJE.Ogre.entity.Question;
import org.CYJE.Ogre.service.AdherantService;
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
	
	@GetMapping("/form")
	public String showForm(Model model) {
		Question question = new Question();
		model.addAttribute("question", question);
		return "form";
	}
	
//	@GetMapping("edit/{id}")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String showEditForm(Model model, @PathVariable int id) { 
		Question question = questionService.getReponse(id);
		model.addAttribute("question", question);
		return "formEdit.html";
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
		
		do {
			
			if(listeQ.get(i).getEmail().equalsIgnoreCase(emailUtilisateur)) {
				trouve = true;
				q = listeQ.get(i);
			}
			else
				i++;
			
		}while(!trouve);
		
		if(q!=null) {
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
			
		    model.addAttribute("res", energieParJourSeul + energieParJourFamillePourUnePersonne);
		}
		else
			model.addAttribute("res", "Rien");
	    
		return "resultats";
	}
}
