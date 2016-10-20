package com.mock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	 
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public  ResponseEntity getStudentById(@PathVariable("id") int id){
	        if(userService.getUserById(id) != null) {
	        	 return new ResponseEntity<User>(userService.getUserById(id), new HttpHeaders(), HttpStatus.OK);
	        } 
	        else {
	        	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
	        }
	   }
	 
	 @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public void insertStudent(@RequestBody User user){
	        userService.addUser(user);
	    }
	 
	 @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	    public void deleteUserById(@PathVariable("id") int id){
	        userService.deleteUser(id);
	    }
	 
	 @RequestMapping(value = "/error")
	    public String error() {
	        return "Error handling";
	    }
	
	

}
