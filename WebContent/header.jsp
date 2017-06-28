<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>SupCommerce</title>
</head>
<body>
	<div class="container">
				    	<%	
					if (session.getAttribute("username") != null) {
						out.print("<h4 class=\"pull-right\">Bonjour " + session.getAttribute("username") + "</h4>");
					}
					else{
						out.print("<h4 class=\"pull-right\">Anonymous</h4>");
					}
				%>  	   
		<nav class="navbar navbar-light" style="background-color: #b7f2ff;">
		<a class="navbar-brand" href="/SupCommerce/listProduct">ListProduct</a>
		<a class="navbar-brand" href="/SupCommerce/listCategory">ListCategory</a>
		
		
				<c:choose>
	    <c:when test="${empty sessionScope.username}">
			<a class="navbar-brand pull-right" href="/SupCommerce/login.jsp">Login</a>
	    </c:when>    
	    <c:otherwise>
	    	<a class="navbar-brand" href="/SupCommerce/auth/addProduct">Add Product</a>
	    	<a class="navbar-brand" href="/SupCommerce/auth/addCategory">Add Category</a>
	    	<a class="navbar-brand pull-right" href="/SupCommerce/logout">Logout</a>
		</c:otherwise>
	</c:choose>
		</nav>
		
		<div class="container">
		