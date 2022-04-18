package org.CYJE.Ogre.controller;

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

}
