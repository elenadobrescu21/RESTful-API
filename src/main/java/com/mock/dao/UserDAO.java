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
    
    public void addUser(User user) {
    	this.allUsers.add(user);
    	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mock");   
	    EntityManager entityManager2 = emfactory.createEntityManager();
    	entityManager2.getTransaction().begin();
    	entityManager2.persist(user);
    	entityManager2.getTransaction().commit();
    	entityManager2.close();
    	emfactory.close();
    	
    }
    
    public void deleteUser(int id) {
    	
    	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mock");   
	    EntityManager entityManager2 = emfactory.createEntityManager();
    	entityManager2.getTransaction().begin();
    	User user= entityManager2.find(User.class, id);
    	entityManager2.remove(user);
    	entityManager2.getTransaction().commit();
    	entityManager2.close();
        emfactory.close();
    	for(int i=0; i<allUsers.size(); i++) {
    		if(allUsers.get(i).getId() == id) {
    			allUsers.remove(i);
    		}
    	}
    }
   
    


}
