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

import com.mock.entities.University;
import com.mock.entities.User;
import com.mock.services.UserService;
import com.mysql.fabric.Response;


@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	 @RequestMapping(method = RequestMethod.GET)
	  public ResponseEntity getAllUsers() {
	    if(this.userService.getAllUsers().isEmpty()) {
	    	return new ResponseEntity<String>("List of users is empty", new HttpHeaders(), HttpStatus.NOT_FOUND);
	    } 
	    else {
	    	return new ResponseEntity<List<User>>(this.userService.getAllUsers(), new HttpHeaders(), HttpStatus.OK);
	    }
	  }
	 
	  
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public  ResponseEntity getUserById(@PathVariable("id") int id){
	        if(userService.getUserById(id) != null) {
	        	 return new ResponseEntity<User>(userService.getUserById(id), new HttpHeaders(), HttpStatus.OK);
	        } 
	        else {
	        	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
	        }
	   }
	 
	 @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity insertUser(@RequestBody User user){
	
		 	System.out.println(user.getEmail());
		    boolean userNameExistent = false;
		    boolean emailExistent = false;
		    for(User u : userService.getAllUsers()) {
		    	if(u.getUsername().equals(user.getUsername())) {
		    		userNameExistent = true;
		    		break;
		    	}
		    }
		    for(User us : userService.getAllUsers()) {
		    	if(us.getEmail().equals(user.getEmail())){
		    		emailExistent = true;
		    		break;
		    	}
		    }
		    
		    if(userNameExistent || emailExistent) {
			    if(userNameExistent == true) {
			    	return new ResponseEntity<String>("Username already exits", new HttpHeaders(), HttpStatus.IM_USED);
			    }
			    if(emailExistent == true) {
			    	return new ResponseEntity<String>("Email already in use", new HttpHeaders(), HttpStatus.IM_USED);
			    } 
		    } 
		    else {
		    	userService.addUser(user);
		    	return new ResponseEntity<String>("User has been created", new HttpHeaders(), HttpStatus.OK);
		    }
			return null;
		           
	    }
	 
	 @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	    public void deleteUserById(@PathVariable("id") int id){
	        userService.deleteUser(id);
	  }
	 
//	 @RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE) 
//	   public void addUniversity(@RequestBody University university) {
//		 
//	 }
	 
	 @RequestMapping(value = "/error")
	    public String error() {
	        return "Error handling";
	    }
	
	

}
