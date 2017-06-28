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
import fr.imie.supcommerce.entity.Product;

@Path("/product")
public class ProductResource {
	/*XML*/
	@GET @Produces(MediaType.APPLICATION_XML) @Path("/xml")
	public Collection<Product> getAllProductsInXml(){
		return DaoFactory.productDao().selectAllProduct();
	}
	
	@GET @Produces(MediaType.APPLICATION_XML) @Path("/xml/{productId}")
	public Product getProductInXml(@PathParam("productId") Long productId){
		      Product product = DaoFactory.productDao().selectProduct(productId);
		      return product;
		}

	/*JSON*/
	@GET @Produces(MediaType.APPLICATION_JSON) @Path("/json")
	public Collection<Product> getAllProductsInJson(){
		return DaoFactory.productDao().selectAllProduct();
		}

	@GET @Produces(MediaType.APPLICATION_JSON) @Path("/json/{productId}")
	public Product getProductInJson(@PathParam("productId") Long productId){
	      Product product = DaoFactory.productDao().selectProduct(productId);
	      return product;
	      }

	/*REMOVE*/
	@DELETE @Path("/remove/{productId}")
	public void removeProduct(Long productId){
		DaoFactory.productDao().removeProduct(productId);
	}

}
