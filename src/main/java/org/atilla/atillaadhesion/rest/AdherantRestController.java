package org.atilla.atillaadhesion.rest;

import java.util.List;

import org.atilla.atillaadhesion.entity.Adherant;
import org.atilla.atillaadhesion.service.AdherantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//api de test
@RestController
@RequestMapping("/api")
public class AdherantRestController {
	
	private AdherantService	 adherantService;
	
	@Autowired
	public AdherantRestController(AdherantService adherantService) {
		this.adherantService = adherantService;
	}
	
	@GetMapping("/adherants")
	public List	<Adherant> getAdherants() {
		return adherantService.getAdherants();
	}
	
	@GetMapping("/adherants/cotisants")
	public List <Adherant> getCotisants() {
		return adherantService.getCotisants();
	}
	
	@GetMapping("/adherants/{id}")
	public Adherant getAdherant(@PathVariable int id) {
		Adherant adherant = adherantService.getAdherant(id);
		if (adherant == null) {
			throw new RuntimeException("Adherant not found avec id = " + id);
		}
		return adherant;
	}
	
	@PostMapping("/adherants")
	public Adherant addAdherant(@RequestBody Adherant adherant) {
		adherant.setId(0);
		adherantService.saveAdherant(adherant);
		return adherant;
	}
	
	@PutMapping("/adherants")
	public Adherant updateAdherant(@RequestBody Adherant adherant) {
		adherantService.saveAdherant(adherant);
		return adherant;
	}
	
	@DeleteMapping("/adherants/{id}")
	public String deleteAdherant(@PathVariable int id) {
		Adherant adherant = adherantService.getAdherant(id);
		if (adherant == null) {
			throw new RuntimeException("Adherant not found avec id = " + id);
		}
		adherantService.deleteAdherant(id);
		
		return "Adherant with id = " + id + " is deleted";
	}

	public void delete(){
		System.out.println("Hello World");
	}
	
	
	

}
