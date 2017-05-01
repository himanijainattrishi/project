<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
<b>show product</b>
<div class="container">
		<div class="container">
         
		 <div class="row"> 
			<div class="col-md-6">
			
				<%-- <img src='<c:url value="/resources/img/${product.name}.jpg" />' alt="image" height="200" width="160" />  --%>
				<img  height="300px" width="300px" alt="${product.id}" src="<c:url value="/resources/img/${product.id}.jpg"></c:url>">
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
				<a href="${session.getContextPath()}/shoppingcart/order/${product.id}"><font size=10>Add to cart</font></a></div>
				</div>
		</div> 
		</div>
		</div>
</body>
</html>