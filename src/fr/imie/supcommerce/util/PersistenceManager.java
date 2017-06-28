package fr.imie.supcommerce.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	private static EntityManagerFactory emf;
	
	// init
	public static EntityManagerFactory
	getEntityManagerFactory(){
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("PersisanceUnit");
		}
		return emf;
	}
	
	public static void closeEntityManagerFactory(){
		if(emf != null && emf.isOpen()) emf.close();
	}
}
