package com.mock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mock.entities.User;
import com.mock.services.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	 @RequestMapping(method = RequestMethod.GET)
	  public List<User> getAllUsers() {
	    return this.userService.getAllUsers();
	  }
	
	

}
