package org.CYJE.Ogre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//supprimer le exclude dès que la security est faite
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class OgreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OgreApplication.class, args);
	}

}	
