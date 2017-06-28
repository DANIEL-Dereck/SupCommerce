package fr.imie.supcommerce.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.dao.DaoFactory;


@SuppressWarnings("serial")
@WebServlet(urlPatterns="/auth/removeProduct")
public class RemoveProductServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		Long id;

		if (req.getParameter("id") != null) {
			id = Long.parseLong(req.getParameter("id"));
			
			if (DaoFactory.productDao().selectProduct(id) != null) {
				DaoFactory.productDao().removeProduct(id);
				}
			}
		resp.sendRedirect("/SupCommerce/listProduct.jsp");
	}

}
