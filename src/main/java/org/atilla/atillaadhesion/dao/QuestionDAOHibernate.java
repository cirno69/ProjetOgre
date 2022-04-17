package org.atilla.atillaadhesion.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.atilla.atillaadhesion.entity.Question;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
		Query<Question> query = session.createQuery("from Question", Question.class);
		List<Question> questions = query.getResultList();
		return questions;
	}
	
}
