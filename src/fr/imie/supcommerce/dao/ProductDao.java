package fr.imie.supcommerce.dao;

import java.util.Collection;

import fr.imie.supcommerce.entity.Product;

public interface ProductDao {
	public Collection<Product> selectAllProduct();
	public Product selectProduct(Long id);
	public void addProduct(Product product);
	public int removeProduct(Product product);
	public int removeProduct(Long id);
	public int updateProduct(Product product);
}
