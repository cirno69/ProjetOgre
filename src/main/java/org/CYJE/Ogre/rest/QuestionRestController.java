package org.CYJE.Ogre.rest;

import java.util.List;

import org.CYJE.Ogre.entity.Question;
import org.CYJE.Ogre.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
