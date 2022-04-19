package org.CYJE.Ogre.service;

import java.util.List;

import org.CYJE.Ogre.dao.QuestionDAO;
import org.CYJE.Ogre.entity.Question;
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

	@Override
	@Transactional
	public Question getReponse(int id) {
		return questionDAO.getReponse(id);
	}

	@Override
	@Transactional
	public void saveReponse(Question reponses) {
		questionDAO.saveReponse(reponses);
	}

	@Override
	@Transactional
	public void deleteReponse(int id) {
		questionDAO.deleteReponse(id);
	}

}
