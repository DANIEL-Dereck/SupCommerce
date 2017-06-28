package fr.imie.supcommerce.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.imie.supcommerce.util.PersistenceManager;

@WebListener
public class PersistenceAppListner implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent evt) {
		PersistenceManager.closeEntityManagerFactory();
	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {

	}

}
