package org.atilla.atillaadhesion.service;

import java.util.List;

import org.atilla.atillaadhesion.dao.QuestionDAO;
import org.atilla.atillaadhesion.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionServiceImpl implements QuestionService {

	private QuestionDAO questionDAO;
	
	
	@Autowired
	public QuestionServiceImpl(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}

	@Override
	@Transactional
	public List<Question> getQuestion() {
		return questionDAO.getQuestion();
	}
	


}
