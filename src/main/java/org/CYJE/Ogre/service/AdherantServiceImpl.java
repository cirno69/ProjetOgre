package org.CYJE.Ogre.service;

import java.util.List;

import org.CYJE.Ogre.dao.AdherantDAO;
import org.CYJE.Ogre.entity.Adherant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdherantServiceImpl implements AdherantService {

	private AdherantDAO adherantDAO;
	
	
	@Autowired
	public AdherantServiceImpl(AdherantDAO adherantDAO) {
		this.adherantDAO = adherantDAO;
	}

	@Override
	@Transactional
	public List<Adherant> getAdherants() {
		return adherantDAO.getAdherants();
	}
	
	@Override
	@Transactional
	public List<Adherant> getCotisants() {
		return adherantDAO.getCotisants();
	}
	
	@Override
	@Transactional
	public String getMailingList(){
		return adherantDAO.getMailingList();
	}
	
	@Override
	@Transactional
	public String getMailingListCotisants() {
		return adherantDAO.getMailingListCotisants();
	}
	
	@Override
	@Transactional
	public Adherant getAdherant(int id) {
		return adherantDAO.getAdherant(id);
	}

	@Override
	@Transactional
	public void saveAdherant(Adherant adherant) {
		adherantDAO.saveAdherant(adherant);
	}

	@Override
	@Transactional
	public void deleteAdherant(int id) {
		adherantDAO.deleteAdherant(id);
	}

	@Override
	@Transactional
	public List<Adherant> getCotisantsNonValides() {
		return adherantDAO.getCotisantsNonValides();
	}
	
	@Override
	@Transactional
	public void validateCotisant(Adherant adherant) {
		adherantDAO.validateCotisant(adherant);
		
	}

	@Override
	@Transactional
	public void unvalidateCotisant(Adherant adherant) {
		adherantDAO.unvalidateCotisant(adherant);
		
	}


}
