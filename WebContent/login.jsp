<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<%@include file="./header.jsp" %>
	<form action="/SupCommerce/login" method="POST">
		<div class="form-group">
		  login: 
		  <input name="username" type="text" value="Name"><br><br>
		  <input type="submit" value="Submit" class="btn btn-default">
	  	</div>
	</form> 
	<%@include file="./footer.jsp" %>