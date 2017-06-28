package fr.imie.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.dao.DaoFactory;
import fr.imie.supcommerce.entity.Category;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/auth/addCategory")
public class AddCategoryServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/auth/addCategory.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		if (req.getParameter("name") == null) {
			out.println("<p>paramètres incorrects<p>");	
			resp.sendRedirect("/SupCommerce/auth/addCategory.jsp");
		}
		else{
			Category category = new Category(req.getParameter("name"));
			DaoFactory.categoryDao().addCategory(category);
			out.println("<p>Ajout OK!<p>");
			resp.sendRedirect("/SupCommerce/showCategory?id="+category.getId());
		}			
	}
}
