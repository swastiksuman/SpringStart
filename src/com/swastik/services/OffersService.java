package com.swastik.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swastik.dao.Offer;
import com.swastik.dao.OffersDAO;

@Service("offersService")
public class OffersService {
	
	
	private OffersDAO offersDao;
	
	@Autowired
	public void setOffersDao(OffersDAO offersDao) {
		this.offersDao = offersDao;
	}

	public List<Offer> getCurrent() {
		return offersDao.getOffers();
	}
	
	public void create(Offer offer){
		offersDao.create(offer);
	}

	public void throwTestException() {
		offersDao.getOffer(99999);
	}
	
	public Offer getOffer(int id){
		return offersDao.getOffer(id);
	}
	
	public Offer getOffer(String name){
		return offersDao.getOffer(name);
	}
}
