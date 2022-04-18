package org.CYJE.Ogre.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	
@Entity
@Table(name="questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="questionId")
	private int id;
	
	@Column(name="sectionId")
	private int sectionId;
	
	@Column(name="priority")
	private int priority;
	
	@Column(name="questionTypeId")
	private int questionTypeId;
	
	@Column(name="Text") //date_de_naissance
	private String text;
	
	//Constructeurs
	public Question() {
		//obligatoire pour que hibernate fonctionne
	}

	public Question(int id, int sectionId, int priority, int questionTypeId, String text) {
		this.id = id;
		this.sectionId = sectionId;
		this.priority = priority;
		this.questionTypeId = questionTypeId;
		this.text = text;
	}
	
	//Getters et Setters
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId (int sectionId) {
		this.sectionId = sectionId;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(int questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	//toString for debugging
	@Override
	public String toString() {
		return "questions [id=" + id + ", sectionId=" + sectionId + ", priority=" + priority + ", questionTypeId=" + questionTypeId + ", text="
				+ text +"]";
	}
	

	
	

	
	
	

}
