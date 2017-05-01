<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<a href="manage_categories"><button type="button" class="btn btn-primary">Manage Categories</button></a><br>
<a href="manage_products"><button type="button" class="btn btn-success">Manage Products</button></a><br>
<a href="manage_suppliers"><button type="button" class="btn btn-info">Manage Suppliers</button></a><br>
</div>
<br>

<c:if test="${isUserClickedCategories==true }">
<jsp:include page="Category.jsp"></jsp:include>

</c:if>

<c:if test="${isUserClickedProducts==true }">
<jsp:include page="product.jsp"></jsp:include>

</c:if>

<c:if test="${isUserClickedSuppliers==true }">
<jsp:include page="supplier.jsp"></jsp:include>

</c:if>



</body>
</html>