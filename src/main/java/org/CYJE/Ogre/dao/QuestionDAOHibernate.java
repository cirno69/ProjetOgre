package org.CYJE.Ogre.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.CYJE.Ogre.entity.Question;
import org.CYJE.Ogre.dao.QuestionDAO;
//import 
import org.hibernate.Session;
import org.hibernate.query.Query;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class QuestionDAOHibernate implements QuestionDAO {
	
	private EntityManager entityManager; //moins de config à faire par rapport à SessionFactory
	
	@Autowired
	public QuestionDAOHibernate(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Question> getQuestion() {
	    
		Session session = entityManager.unwrap(Session.class); //session hibernate
		Query<Question> query = session.createQuery("SELECT a FROM Question a", Question.class);
		List<Question> questions = query.getResultList();
		return questions;
	}
	
	@Override
	public Question getReponse(int id) {
		Session session = entityManager.unwrap(Session.class);
		Question reponse = session.get(Question.class,id);
		return reponse;
	}

	@Override
	public void saveReponse(Question reponses) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(reponses);
	}
}
