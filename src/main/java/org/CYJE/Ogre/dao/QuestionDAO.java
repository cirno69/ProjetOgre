package org.CYJE.Ogre.dao;

import java.util.List;

import org.CYJE.Ogre.entity.Question;

public interface QuestionDAO {
	
	public List<Question> getQuestion();
	public Question getReponse(int id);

    Question getReponse(String email);

    public void saveReponse(Question reponses);
	public void deleteReponse(int id);
}
