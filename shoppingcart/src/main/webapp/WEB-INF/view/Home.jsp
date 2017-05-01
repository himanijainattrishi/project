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
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>


</style>

</head>
<body>
<h2><center>Shopping Cart</center></h2>



<%-- <c:forEach items="${categoryList}" var="category">
<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> ${category.name} <span class="caret"></span></a>
   <ul class="dropdown-menu" role="menu">
     
						<c:forEach items="${productList}" var="product">
						<c:if test="${(product.category_id).equals (category.id)}">
						
						<li><a href="<c:url value='/displayPage/${product.id}'/>">${product.name}</a></li>
						</c:if>
						</c:forEach>
						
					 </ul> 
			</c:forEach>
			
			<br>
			<br>
			<br> --%>
			
<nav class="navbar navbar-inverse">
  
    <ul class="nav navbar-nav">
      <li class="active"><a href="Home">Home</a></li>
      
      <c:forEach items="${categoryList}" var="category">
<li class="active" class="dropdown" ><a class="dropdown-toggle" data-toggle="dropdown" href="#"> ${category.name} <span class="caret"></span></a>
   <ul class="dropdown-menu" role="menu">
                        
						<c:forEach items="${productList}" var="product">
						<c:if test="${(product.category_id).equals (category.id)}">
						
						<li><a href="<c:url value='/displayPage/${product.id}'/>">${product.name}</a></li>
						</c:if>
						</c:forEach>
						
					 </ul> 
			</c:forEach>
      <li class="active"><a href="AboutUs">About Us</a></li>
    </ul>
   
</nav>
  
	
			


<center>${msg}</center>
<center>${role}</center>
<center>${successmessage}</center>
<center>${errormessage}</center>
${loginmessage}<br>

<jsp:include page="courosal.jsp"></jsp:include>


			
			

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
<c:if test="${isAdmin==false } ">
<a href="cart">My Carts</a>
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
	<jsp:include page="cart.jsp"></jsp:include>
	</c:if> 

 <c:if test="${displayCart == true}">
<a href="cart">My Cart</a>
</c:if>


<c:if test="${isAdmin==false }">
<c:forEach items="${productList}" var="product">
			<tr>


				<td>
					<div class="col-md-4">
						<a href="showproduct/${product.id}"> <img height="150px"
							width="150px" alt="${product.id }"
							src="<c:url value="/resources/img/${product.id }.jpg"></c:url>"></a>
						<%-- <td><c:url var="action" value="/product1/${product.id}"></c:url> --%>
						<c:url var="action" value="/product1"></c:url>
							<form:form action="${action}" modelAttribute="cart">
								<td id="td1"><c:out value="${product.name}" /><br>
								<td id="td1"><c:out value="${product.price}" /> <input
									type="submit" class="btn btn-primary" value="Add To Cart" /><br>
							</form:form></td>
						<br>
						

					</div>
			</tr>
			
		</c:forEach>
		
		</c:if>
		
		
		
		
		<c:choose>
		<c:when test="${isUserclickedcart}">
			<c:import url="/WEB-INF/view/bb.jsp"></c:import>
		</c:when>
	</c:choose> 
</body>
</html>