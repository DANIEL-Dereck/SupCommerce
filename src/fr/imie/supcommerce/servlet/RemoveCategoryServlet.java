package fr.imie.supcommerce.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.dao.DaoFactory;


@SuppressWarnings("serial")
@WebServlet(urlPatterns="/auth/removeCategory")
public class RemoveCategoryServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		int id;

		if (req.getParameter("id") != null) {
			id = Integer.parseInt(req.getParameter("id"));
			
			if (DaoFactory.categoryDao().selectCategory(id) != null) {
				DaoFactory.categoryDao().removeCategory(id);
				}
			}
		resp.sendRedirect("/SupCommerce/listCategory");
	}
}
