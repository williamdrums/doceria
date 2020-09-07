package br.com.doceria.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("doces_PU");
	
	public EntityManager getEntityManager() {
		
		return entityManagerFactory.createEntityManager();
	}
	
}
