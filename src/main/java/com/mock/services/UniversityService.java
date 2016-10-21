package com.mock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.dao.UniversityDAO;
import com.mock.entities.*;

@Service
public class UniversityService {
	
	@Autowired
	private UniversityDAO universityDAO;
	
	public List<University> getAllUniversities() {
		return this.universityDAO.getAllUniversities();
	}
	
	public void addUniversity(University university) {
		this.universityDAO.addUniversity(university);
		
	}


}
