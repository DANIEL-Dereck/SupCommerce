package fr.imie.supcommerce.servlet;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.dao.DaoFactory;
import fr.imie.supcommerce.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/listProduct")
public class ListProductServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Collection<Product> productList = DaoFactory.productDao().selectAllProduct(); 
		req.setAttribute("productList", productList);
		RequestDispatcher rd = req.getRequestDispatcher("/listProduct.jsp");
		rd.forward(req, resp);
	}
}
