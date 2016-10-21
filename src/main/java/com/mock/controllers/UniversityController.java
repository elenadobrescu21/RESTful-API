package com.mock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mock.entities.University;
import com.mock.entities.User;
import com.mock.services.UniversityService;

@RestController
@RequestMapping(value="/university")
public class UniversityController {
	
	@Autowired
	public UniversityService universityService;
	
//	@RequestMapping(method = RequestMethod.GET)
//	  public List<University> getAllUsers() {
//	    return this.universityService.getAllUniversities();
//	}
//	
//	 @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	  public void insertUniversity(@RequestBody University university){
//		 universityService.addUniversity(university);
//	 }
	
	
	

}
