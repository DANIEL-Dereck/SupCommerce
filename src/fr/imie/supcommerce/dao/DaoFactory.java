package fr.imie.supcommerce.dao;

import fr.imie.supcommerce.dao.jpa.JpaCategoryDao;
import fr.imie.supcommerce.dao.jpa.JpaProductDao;
import fr.imie.supcommerce.util.PersistenceManager;

public class DaoFactory {
	private DaoFactory(){
		
	}
	
	public static ProductDao productDao(){
		return new JpaProductDao(PersistenceManager.getEntityManagerFactory());
	}

	public static CategoryDao categoryDao(){
		return new JpaCategoryDao(PersistenceManager.getEntityManagerFactory());
	}

}
