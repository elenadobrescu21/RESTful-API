package com.mock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.dao.UserDAO;
import com.mock.entities.*;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public List<User> getAllUsers() {
		return this.userDAO.getAllUsers();
	}
	
	public User getUserById(int id) {
		return this.userDAO.getUser(id);
	}
	
	public void addUser(User user) {
		this.userDAO.addUser(user);
	}
	
	public void deleteUser(int id) {
		this.userDAO.deleteUser(id);
	}

}
