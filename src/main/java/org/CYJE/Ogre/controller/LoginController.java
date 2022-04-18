package org.CYJE.Ogre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("connexion")
	public String showLogin() {
		
		return "connexion";
	}
	
	@GetMapping("erreur-501")
	public String ShowerreurAuthorization() {
		return "erreur-501";
	}

}
