<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<%@include file="../header.jsp" %>
	<form action="/SupCommerce/auth/addCategory" method="POST">
		<div class="form-group">
			<h3>New Category</h3>
		  	name:<br>
			<input name="name" type="text" value=""><br>
			<input type="submit" value="Submit" class="btn btn-default">
		</div>
	</form> 
	<%@include file="../footer.jsp" %>
