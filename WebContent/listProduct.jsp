<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="fr.imie.supcommerce.entity.Product"%>

<%@include file="./header.jsp"%>

<c:choose>
	<c:when test="${empty productList}">
		<h2 class="alert alert-warning">
			<c:out value="No product found" />
		</h2>
	</c:when>
	<c:otherwise>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productList}" var="p">
					<tr>
						<td><c:out value="${p.name}" /></td>
						<td><c:out value="${p.description}" /></td>
						<td><c:out value="${p.price}" /></td>
						<td>
							<form action="/SupCommerce/auth/removeProduct" method="POST">
								<div class="form-group">
									<input name="id" type="hidden" value="${p.id}"><br>
									  <button type="submit" class="btn btn-danger">
    									<span class="glyphicon glyphicon-trash"></span>
									  </button>
								</div>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>

<%@include file="./footer.jsp"%>
