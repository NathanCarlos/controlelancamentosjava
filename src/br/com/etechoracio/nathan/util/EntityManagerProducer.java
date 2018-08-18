package br.com.etechoracio.nathan.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	
	public static EntityManager createEntityManager(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ETEC");
		return emf.createEntityManager();
	}

}
