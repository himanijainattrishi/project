<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
body
{
    background: url('${pageContext.request.contextPath}/resources/img/shopping.jpg') fixed;
    background-size: cover;
    padding: 0;
    margin: 0;
}

</style>

</head>
<body>
<h2><center>Shopping Cart</center></h2>




<c:forEach items="${categoryList}" var="category">
<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> ${category.name} <span class="caret"></span></a>
   <ul class="dropdown-menu" role="menu">
     
						<c:forEach items="${productList}" var="product">
						<c:if test="${(product.category_id).equals (category.id)}">
						
						<li><a href="<c:url value='/display/${product.id}'/>">${product.name}</a></li>
						</c:if>
						</c:forEach>
						
					 </ul> 
			</c:forEach>

<center>${msg}</center>
<center>${role}</center>
<center>${successmessage}</center>
<center>${errormessage}</center>
${loginmessage}<br>
<hr>


<c:if test="${isAdmin==true }">
<jsp:include page="Admin/AdminHome.jsp"></jsp:include>

</c:if>
<c:if test="${empty loginmessage }">
<a href="login">login</a><br>
<a href="Registration">Register</a><br>
</c:if>
<c:if test="${ not empty loginmessage}">
<a href="logout">logout</a><br>
</c:if>
<c:if test="${isAdmin==false }">
<a href="cart">My Carts</a>
</c:if>
<c:if test="${!empty selectedProduct.name}">
<%@ include file="selectedproduct.jsp" %>
</c:if>





<c:if test="${isuserclickedlogin==true}">
<jsp:include page="login.jsp"></jsp:include>
</c:if>

<c:if test="${not empty errormessage}">
<jsp:include page="login.jsp"></jsp:include>
</c:if>


<c:if test="${isuserclickedRegister==true}">
<jsp:include page="Registration.jsp"></jsp:include>
</c:if>

<c:if test="${isUserclickedcart == true}">
	<a href="cart">My Carts</a>
	</c:if>
	
<c:if test="${displayCart == true}">
<a href="cart">My Carts</a>
</c:if>
</body>
</html>