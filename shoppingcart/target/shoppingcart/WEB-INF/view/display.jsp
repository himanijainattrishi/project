<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%---- <%@ include file="./header.jsp" %>--%>
	
	<div class="container">

		 <div class="row"> 
			<div class="col-md-6">
				<img src='<c:url value="/resources/img/${product.name}.jpg" />' alt="image" height="200" width="160" /> 
			</div>
			<div class="col-md-6">

				<h3>${product.name}</h3>
				
				<p>
					<strong>Item Code : </strong><span class="label label-warning">${product.id}</span>
				</p>
				<p>
					<strong>category</strong> : ${product.category.name}
				</p>
				
				<h4>${product.price}Rupees</h4>
				
					 <%-- <a href="<spring:url value="/myCart/add/${product.id}"/>" class="btn btn-warning btn-large"> <span
						class="glyphicon-shopping-cart glyphicon"> </span>Add To Cart
					</a>  --%>
					
	<a href="${session.getContextPath()}/shoppingcart/Order/${product.id}" class="btn btn-danger btn-large"> <span
	class="glyphicon-shopping-cart glyphicon"></span> Add To Cart</a></div>
				
			</div>
		</div>
	
</body>
</html>