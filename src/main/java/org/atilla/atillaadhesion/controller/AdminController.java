package org.atilla.atillaadhesion.controller;

import org.atilla.atillaadhesion.entity.Adherant;
import org.atilla.atillaadhesion.service.AdherantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/admin")
@Controller
public class AdminController {
	
	private AdherantService adherantService;
	
	@Autowired
	public AdminController(AdherantService adherantService) {
		this.adherantService = adherantService;
	}
	
	@GetMapping("/adherants")
    public String adherants(Model model){
        model.addAttribute("adherants",adherantService.getAdherants());
		String MLstring = adherantService.getMailingList();
        model.addAttribute("mailinglist",MLstring);
        return("admin/adherants");
    }

	@GetMapping("/cotisants")
    public String cotisants(Model model){
		model.addAttribute("cotisants",adherantService.getCotisants());
		String MLstring = adherantService.getMailingListCotisants();
        model.addAttribute("mailinglist",MLstring);
        return("admin/cotisants");
    }
	
//	@DeleteMapping("deleteA/{id}")
	@RequestMapping(value = "deleteA/{id}", method = RequestMethod.GET)
	public String deleteAdherant(@PathVariable int id){
		Adherant adherant = adherantService.getAdherant(id);
		
		if (adherant == null) {
			throw new RuntimeException("Adherant not found avec id = " + id);
		}
		adherantService.deleteAdherant(id);
		return"redirect:/admin/adherants";
	}
	
//	@DeleteMapping("deleteC/{id}")
	@RequestMapping(value = "deleteC/{id}", method = RequestMethod.GET)
	public String deleteCotisant(@PathVariable int id){
		Adherant adherant = adherantService.getAdherant(id);
		
		if (adherant == null) {
			throw new RuntimeException("Adherant not found avec id = " + id);
		}
		adherantService.deleteAdherant(id);
		return"redirect:/admin/cotisants";
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
	
	
	@GetMapping("/adherant/{id}")
    public String pagePersoAdherant(Model model,@PathVariable int id){
        model.addAttribute("adherant",adherantService.getAdherant(id));
        return("admin/information");
    }

}
