package com.swastik.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swastik.dao.Offer;
import com.swastik.dao.OffersDAO;
import com.swastik.dao.User;
import com.swastik.dao.UsersDAO;

@Service("usersService")
public class UsersService {
	
	
	private UsersDAO usersDao;
	
	@Autowired
	public void setUsersDao(UsersDAO usersDao) {
		this.usersDao = usersDao;
	}

	public void create(User user){
		usersDao.create(user);
	}
}
