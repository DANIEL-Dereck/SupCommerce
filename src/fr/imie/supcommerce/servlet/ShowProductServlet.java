package fr.imie.supcommerce.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.dao.DaoFactory;
import fr.imie.supcommerce.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/showProduct")
public class ShowProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product p = new Product();
		Long id = Long.parseLong(req.getParameter("id"));
		p = DaoFactory.productDao().selectProduct(id);
		if (p != null) {
			req.setAttribute("p", p);
		} else {
			req.setAttribute("p", null);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/showProduct.jsp");
		rd.forward(req, resp);				
	}
}
