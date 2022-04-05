package org.atilla.atillaadhesion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String HomePage(/*Model model*/) {
        //boolean isAdmin = true;
        //model.addAttribute("isAdmin",isAdmin);
        return("homepage");
    }
}
