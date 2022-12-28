package com.jsp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.mobile.Mobile;
import com.jsp.sim.Sim;

public class MobileController {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("milind");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Mobile mobile = new Mobile();
		mobile.setName("M30s");
		mobile.setPrice(13000);
		
		Sim s1 = new Sim();
		s1.setService("Jio");
		s1.setService_type("prepaid");
		
		Sim s2 = new Sim();
		s2.setService("Airtel");
		s2.setService_type("prepaid");
		
		List<Sim> s = new ArrayList();
		s.add(s1);
		s.add(s2);
		
		mobile.setSim(s);
		
		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityTransaction.commit();
		System.out.println("All Good");
	}
}