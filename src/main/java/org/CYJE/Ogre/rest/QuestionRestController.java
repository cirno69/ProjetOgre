package org.CYJE.Ogre.rest;

import java.util.List;

import org.CYJE.Ogre.entity.Question;
import org.CYJE.Ogre.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//api de test
@RestController
@RequestMapping("/api")
public class QuestionRestController {
	
	private QuestionService	 questionService;
	
	@Autowired
	public QuestionRestController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@GetMapping("/questions")
	public List	<Question> getQuestion() {
		return questionService.getQuestion();
	}

	@GetMapping("/reponses/{id}")
	public Question getReponses(@PathVariable int id) {
		Question reponses = questionService.getReponse(id);
		if (reponses == null) {
			throw new RuntimeException("Reponses not found avec id = " + id);
		}
		return reponses;
	}
}
