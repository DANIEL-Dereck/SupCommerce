<%@taglib 
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List" %>
<%@ page import="fr.imie.supcommerce.entity.Product" %>
	<%@include file="../header.jsp" %>
		<c:choose>
	    <c:when test="${empty p}">
   	        <h2 class="alert alert-warning" ><c:out value="product not found" /></h2>
	    </c:when>    
	    <c:otherwise>
			<tr>
				<td><c:out value="${p.name}" /></td>
				<td><c:out value="${p.description}" /></td>
				<td><c:out value="${p.price}" /></td>
				<td>
					<form action="/SupCommerce/auth/removeProduct" method="POST">
						<div class="form-group">
						  <input name="id" type="hidden" value="${p.id}"><br>
						  <input type="submit" value="REMOVE" class="btn btn-default">
					  	</div>
					</form> 
				</td>
			</tr>
		</c:otherwise>
	</c:choose>
	<%@include file="./footer.jsp" %>
