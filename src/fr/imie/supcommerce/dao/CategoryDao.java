package fr.imie.supcommerce.dao;

import java.util.Collection;

import fr.imie.supcommerce.entity.Category;

public interface CategoryDao {
	public Collection<Category> selectAllCategory();
	public Category selectCategory(int id);
	public void addCategory(Category Category);
	public int removeCategory(Category Category);
	public int removeCategory(int id);
	public int updateCategory(Category Category);
}
