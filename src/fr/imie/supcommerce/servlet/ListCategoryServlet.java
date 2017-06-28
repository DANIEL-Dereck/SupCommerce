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
import fr.imie.supcommerce.entity.Category;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/listCategory")
public class ListCategoryServlet  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Collection<Category> categoryList = DaoFactory.categoryDao().selectAllCategory();
		req.setAttribute("categoryList", categoryList);
		RequestDispatcher rd = req.getRequestDispatcher("/listCategory.jsp");
		rd.forward(req, resp);
	}
}
