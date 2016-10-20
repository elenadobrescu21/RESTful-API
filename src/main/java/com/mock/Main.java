package com.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mock.dao.UserDAO;
import com.mock.entities.University;
import com.mock.entities.User;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		
		SpringApplication.run(Main.class, args);
//		
//		  EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mock");   
//	      EntityManager entitymanager = emfactory.createEntityManager();
//	      entitymanager.getTransaction().begin();
//	      University politehnica = new University(1, "Politehnica");
//	      User firstUser = new User("elena_dobrescu", "aaa", "Elena", "Dobrescu");
//	      firstUser.addFavouriteUniversity(politehnica);
//	      entitymanager.persist(politehnica);
//	      entitymanager.persist( firstUser);
//	      entitymanager.getTransaction().commit();
//	      List<User> users = new ArrayList<User>();
//	      UserDAO userDAO = new UserDAO(entitymanager);
//	      userDAO.getAllUsers();
//	      userDAO.printAllUsers();
//	   
//	      entitymanager.close();
//	      emfactory.close();
//	      
	      
	}

}
