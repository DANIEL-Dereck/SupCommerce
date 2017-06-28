package fr.imie.supcommerce.dao.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.supcommerce.dao.CategoryDao;
import fr.imie.supcommerce.entity.Category;

public class JpaCategoryDao implements CategoryDao{
	EntityManagerFactory emf = null;
	
	@SuppressWarnings("unused")
	private JpaCategoryDao(){}

	public JpaCategoryDao(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public Collection<Category> selectAllCategory() {
		Collection<Category> category;
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT c FROM Category AS c");
		category = query.getResultList();
		em.close();
		return category;
	}

	@Override
	public Category selectCategory(int id) {
		Category category = new Category();
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT c FROM Category AS c WHERE c.id = ?1");
		query.setParameter(1,id);
		category = (Category)query.getSingleResult();
		em.close();
		return category;
	}

	@Override
	public void addCategory(Category category) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(category);
			t.commit();
		} finally {
			if (t.isActive()) {
				t.rollback();
			}
		}	
		em.close();
	}

	@Override
	public int removeCategory(Category category) {
		int nbrDeleted = 0;
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			Query query = em.createQuery("DELETE c FROM Category AS c WHERE c = ?1");
			query.setParameter(1,category);
			nbrDeleted = query.executeUpdate();
			t.commit();
		} finally {
			if (t.isActive()) {
				t.rollback();
			}
		}	
		em.close();
		return nbrDeleted;
	}
	@Override
	public int removeCategory(int id) {
		int nbrDeleted = 0;
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			Query query = em.createQuery("DELETE c FROM Category AS c WHERE c = ?1");
			query.setParameter(1,id);
			nbrDeleted = query.executeUpdate();
			t.commit();
		} finally {
			if (t.isActive()) {
				t.rollback();
			}
		}	
		em.close();
		return nbrDeleted;
	}

	@Override
	public int updateCategory(Category category) {
		int nbrUpdate = 0;
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			Query query = em.createQuery("UPDATE c FROM Category AS c SET ?1");
			query.setParameter(1,category);
			nbrUpdate = query.executeUpdate();
			t.commit();
		} finally {
			if (t.isActive()) {
				t.rollback();
			}
		}	
		em.close();
		return nbrUpdate;
	}
}
