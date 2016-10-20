package com.mock.dao;

import com.mock.entities.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	
	private EntityManager entityManager;
    private List<User> allUsers;
    
    public UserDAO(){
    	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mock");   
	    EntityManager entityManager = emfactory.createEntityManager();
	    entityManager.getTransaction().begin();
    	this.allUsers = new ArrayList<User>();
    	Query query = entityManager.createQuery("SELECT e FROM User e");
        this.allUsers= (List<User>) query.getResultList();
        entityManager.close();
        emfactory.close();
    }
    
    
    public User getUser(int id) {
    	return this.allUsers.get(id);
    }
    
    public List<User> getAllUsers() {
    	return this.allUsers;
    }
   
    
    public void printAllUsers() {
    	for(User e : this.allUsers) {
    		System.out.println(e.getUsername());
    	}
    }

}
