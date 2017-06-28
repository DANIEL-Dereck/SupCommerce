package fr.imie.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.dao.DaoFactory;
import fr.imie.supcommerce.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/basicInsert")
public class InsertSomeProductServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		if (req.getParameter("name") == null || req.getParameter("description") == null || req.getParameter("price") == null) {
			out.println("<p>paramètres incorrects<p>");	
			resp.sendRedirect("/SupCommerce/auth/addProduct.jsp");
		}
		else{
			Product product = new Product(req.getParameter("name"), req.getParameter("description"), Float.parseFloat(req.getParameter("price")));
			DaoFactory.productDao().addProduct(product);
			out.println("<p>Ajout Product with ID:"+product.getId()+" OK!<p>");
			resp.sendRedirect("/SupCommerce/showProduct?id="+product.getId());
		}			
	}
}
