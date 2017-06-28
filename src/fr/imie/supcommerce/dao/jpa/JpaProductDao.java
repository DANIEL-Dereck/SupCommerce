package fr.imie.supcommerce.dao.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.supcommerce.dao.ProductDao;
import fr.imie.supcommerce.entity.Product;

public class JpaProductDao implements ProductDao{
	EntityManagerFactory emf = null;
	
	@SuppressWarnings("unused")
	private JpaProductDao(){}

	public JpaProductDao(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public Collection<Product> selectAllProduct() {
		Collection<Product> product;
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Product AS p");
		product = query.getResultList();
		em.close();
		return product;
	}

	@Override
	public Product selectProduct(Long id) {
		Product product;
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Product AS p WHERE p.id = ?1");
		query.setParameter(1,id);
		product = (Product)query.getSingleResult();
		em.close();
		return product;
	}

	@Override
	public void addProduct(Product product) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(product);
			t.commit();
		} finally {
			if (t.isActive()) {
				t.rollback();
			}
		}	
		em.close();
	}

	@Override
	public int removeProduct(Product product) {
		int nbrDeleted = 0;
		EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            Query query = em.createQuery("DELETE FROM Product AS product WHERE product.id = :id");
            query.setParameter("id", product.getId());
            nbrDeleted = query.executeUpdate();

            t.commit();
        } finally {
            if (t.isActive()) t.rollback();
            em.close();
        }
		return nbrDeleted;
	}
	
	@Override
	public int removeProduct(Long id) {
		int nbrDeleted = 0;
		EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            Query query = em.createQuery("DELETE FROM Product AS product WHERE product.id = :id");
            query.setParameter("id", id);
            nbrDeleted = query.executeUpdate();
            t.commit();
        } finally {
            if (t.isActive()) t.rollback();
            em.close();
        }
		return nbrDeleted;
	}

	@Override
	public int updateProduct(Product product) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("UPDATE p FROM Product AS p Where p = ?1");
		query.setParameter(1,product);
		int nbrUpdate = query.executeUpdate();
		em.close();
		return nbrUpdate;
	}

}
