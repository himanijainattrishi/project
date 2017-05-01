<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
</head>
<body>
${successMessage }
<c:set var="imageFolder" value="resources/img/" />
	<table border=""8>
		<tr>
			<th align="left" width="80">Cart ID</th>
			<th align="left" width="120">Product Name</th>
			<th align="left" width="200">Status</th>
			<th align="left" width="80">Price</th>
                        
			<th colspan="2" align="center" width="60">Action</th>

		</tr>
		<c:forEach items="${myCartList}" var="myCart">
			<tr>
				<td align="left">${myCart.id}</td>
				<td align="left">${myCart.productName}</td>
				<td align="left">${myCart.status}</td>
				<td align="left">${myCart.price}</td>
				<td align="left"><a
					href="<c:url value='/cart/delete/${myCart.id}'  />">Delete</a></td>
					
				
</c:forEach>
	</table>

	<br>
	<a href="cart_checkout">Checkout </a>
	<br>
	<br>


</body>
</html>