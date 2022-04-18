package org.CYJE.Ogre.controller;

import org.CYJE.Ogre.entity.Adherant;
import org.CYJE.Ogre.service.AdherantService;
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


@Controller
public class FormController {
	
	private AdherantService adherantService;
	
	@Autowired
	public FormController(AdherantService adherantService) {
		this.adherantService = adherantService;
	}
	
	@GetMapping("/form")
	public String showForm(Model model) {
		Adherant adherant = new Adherant();
		model.addAttribute("adherant",adherant);
		return "form";
	}
	
//	@GetMapping("edit/{id}")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String showEditForm(Model model, @PathVariable int id) { 
		Adherant adherant = adherantService.getAdherant(id);
		model.addAttribute("adherant",adherant);
		return "formEdit.html";
	}

	@PostMapping("/save")
	public String saveAdherant(@ModelAttribute("adherant") Adherant adherant) {
		adherantService.saveAdherant(adherant);
		return "redirect:/";
	}
	

	
	
	@PutMapping("/edit")
	public String editAdherant(@ModelAttribute("adherant") Adherant adherant) {
		adherantService.saveAdherant(adherant);
		return "redirect:/";
	}

}
