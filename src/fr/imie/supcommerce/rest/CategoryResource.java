package fr.imie.supcommerce.rest;

import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.imie.supcommerce.dao.DaoFactory;
import fr.imie.supcommerce.entity.Category;

@Path("/category")
public class CategoryResource {
	/*XML*/
	@GET @Produces(MediaType.APPLICATION_XML) @Path("/xml")
	public Collection<Category> getAllCategoryInXml(){
		return DaoFactory.categoryDao().selectAllCategory();
	}
	
	@GET @Produces(MediaType.APPLICATION_XML) @Path("/xml/{categoryId}")
	public Category getCategoryInXml(@PathParam("categoryId") int categoryId){
		      Category category = DaoFactory.categoryDao().selectCategory(categoryId);
		      return category;
		}

	/*JSON*/
	@GET @Produces(MediaType.APPLICATION_JSON) @Path("/json")
	public Collection<Category> getAllCategoryInJson(){
		return DaoFactory.categoryDao().selectAllCategory();
		}

	@GET @Produces(MediaType.APPLICATION_JSON) @Path("/json/{categoryId}")
	public Category getCategoryInJson(@PathParam("categoryId") int categoryId){
	      Category category = DaoFactory.categoryDao().selectCategory(categoryId);
	      return category;
	      }

	/*REMOVE*/
	@DELETE @Path("/remove/{categoryId}")
	public void removeCategory(int categoryId){
		DaoFactory.categoryDao().removeCategory(categoryId);
	}

}
