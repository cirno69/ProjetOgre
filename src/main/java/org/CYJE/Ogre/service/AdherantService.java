package org.CYJE.Ogre.service;

import java.util.List;

import org.CYJE.Ogre.entity.Adherant;

public interface AdherantService {
	
	public List<Adherant> getAdherants();
	public String getMailingList();
	public String getMailingListCotisants();
	public List<Adherant> getCotisants();
	public Adherant getAdherant(int id); 
	public void saveAdherant(Adherant adherant);
	public void deleteAdherant(int id);
	public List<Adherant> getCotisantsNonValides();
	public void validateCotisant(Adherant adherant);
	public void unvalidateCotisant(Adherant adherant);
}
