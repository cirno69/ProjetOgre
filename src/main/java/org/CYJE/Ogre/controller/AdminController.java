package org.CYJE.Ogre.controller;

import org.CYJE.Ogre.entity.Question;
import org.CYJE.Ogre.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin")
@Controller
public class AdminController {
	
	private QuestionService questionService;
	
	@Autowired
	public AdminController(QuestionService questionService) {
		this.questionService = questionService;
	}

	@GetMapping("/participants")
	public String adherants(Model model){
		model.addAttribute("participants",questionService.getQuestion());
		//String MLstring = questionService.getMailingList();
		//model.addAttribute("mailinglist",MLstring);
		return("admin/participants");
	}

	@GetMapping("/resultats-participants")
	public String resultatsParticipants(Model model){
		return("admin/resultats-participants");
	}

	@RequestMapping(value = "/api/getResult/{email}", method = RequestMethod.GET)
	@ResponseBody
	public String getResultatsParticipant(@PathVariable String email){
		Question reponse = questionService.getReponse(email);
		if (reponse == null) {
			return "{\"success\":false,\"error\":\"Aucun participant avec cet email.\"}";
		}
		String tmp = "";
		tmp += "\"id\":" + reponse.getId() + ",";

		FormController f = new FormController();
		tmp += "\"voiture\":" + f.consoVoiture(reponse) + ",";
		tmp += "\"avion\":" + f.consoAvion(reponse) + ",";
		tmp += "\"train\":" + f.consoTrain(reponse) + ",";
		tmp += "\"chauffage\":" + f.consoChauffageProPerso(reponse) + ",";
		tmp += "\"clim\":" + f.consoClim(reponse) + ",";
		tmp += "\"tache\":" + f.consoTachesQuotidiennes(reponse) + ",";
		tmp += "\"nutrition\":" + f.consoNutrition(reponse) + ",";
		tmp += "\"eclairage\":" + f.consoEclairage() + ",";
		tmp += "\"produitBruns\":" + f.consoProduitsBruns() + ",";
		tmp += "\"marchandise\":" + f.consoMarchandise(reponse) + ",";
		tmp += "\"servicePublic\":" + f.servicesPublic();
		return "{\"resultat\": " + reponse.toJSON() + ",\"conso\": {" + tmp + "}}";
	}

	
//	@DeleteMapping("deleteA/{id}")

	@RequestMapping(value = "deleteA/{id}", method = RequestMethod.GET)
	public String deleteAdherant(@PathVariable int id){
		Question reponse = questionService.getReponse(id);
		if (reponse == null) {
			throw new RuntimeException("Adherant not found avec id = " + id);
		}
		questionService.deleteReponse(id);
		return"redirect:/admin/participants";
	}
	

//	@GetMapping("edit/{id}")
/*
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String showEditForm(Model model, @PathVariable int id) { 
		Adherant adherant = adherantService.getAdherant(id);
		model.addAttribute("adherant",adherant);
		return "formEdit.html";
	}*/
	/*
	@PostMapping("/save")
	public String saveAdherant(@ModelAttribute("adherant") Adherant adherant) {
		adherantService.saveAdherant(adherant);
		return "redirect:/";
	}
	*/
	
	/*
	@GetMapping("/adherant/{id}")
    public String pagePersoAdherant(Model model,@PathVariable int id){
        model.addAttribute("adherant",adherantService.getAdherant(id));
        return("admin/information");
    }
*/
}
