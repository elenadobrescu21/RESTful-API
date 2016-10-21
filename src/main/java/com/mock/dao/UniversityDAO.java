package com.mock.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mock.entities.*;

@Repository
public class UniversityDAO {
	
	private List<University> allUniversities;
	
	 public UniversityDAO(){
	    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mock");   
		EntityManager entityManager = emfactory.createEntityManager();

	    this.allUniversities = new ArrayList<University>();
	    Query query = entityManager.createQuery("SELECT e FROM University e");
	    this.allUniversities= (List<University>) query.getResultList();
	    entityManager.close();
	    emfactory.close();

	 }

	public List<University> getAllUniversities() {
		return allUniversities;
	}

	public void setAllUniversities(List<University> allUniversities) {
		this.allUniversities = allUniversities;
	}
	 
	public void addUniversity(University university) {
    	this.allUniversities.add(university);
    	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mock");   
	    EntityManager entityManager2 = emfactory.createEntityManager();
    	entityManager2.getTransaction().begin();
    	entityManager2.persist(university);
    	entityManager2.getTransaction().commit();
    	entityManager2.close();
    	emfactory.close();
    	
    } 

}
