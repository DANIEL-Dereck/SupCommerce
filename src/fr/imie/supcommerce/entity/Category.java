package fr.imie.supcommerce.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@XmlRootElement(name="category")
@XmlTransient
public class Category {	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@OneToMany(mappedBy="category")
	private Collection<Product> pruduct;
	
	
	public Category() {
	}
	
	public Category(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@XmlTransient
	public Collection<Product> getPruduct() {
		return pruduct;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPruduct(Collection<Product> pruduct) {
		this.pruduct = pruduct;
	}
	
	@Override
	public String toString() {
		return "id: " + id + "<br> name: " + name + "]";
	}
}
