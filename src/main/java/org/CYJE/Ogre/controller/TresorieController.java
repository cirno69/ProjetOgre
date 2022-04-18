package org.CYJE.Ogre.controller;

import org.CYJE.Ogre.entity.Adherant;
import org.CYJE.Ogre.service.AdherantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/tresorie")
@Controller
public class TresorieController {
	
	private AdherantService adherantService;
	
	@Autowired
	public TresorieController(AdherantService adherantService) {
		this.adherantService = adherantService;
	}
	
	@GetMapping("/validation")
    public String adherants(Model model){
        model.addAttribute("adherants",adherantService.getCotisantsNonValides());
        return("tresorie/validate");
    }
	

	@RequestMapping(value = "validation/validate/{id}", method = RequestMethod.GET)
	public String validate(@PathVariable int id){
		Adherant adherant = adherantService.getAdherant(id);
		adherantService.validateCotisant(adherant);
		return "redirect:/tresorie/validation";
		
	}

	
	@RequestMapping(value = "validation/unvalidate/{id}", method = RequestMethod.GET)
	public String unvalidate(@PathVariable int id){
		Adherant adherant = adherantService.getAdherant(id);
		adherantService.unvalidateCotisant(adherant);
		return "redirect:/tresorie/validation";
		
	}	
}

