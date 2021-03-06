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



<%---<jsp:include page="../Menu/CategoryBarFirst.jsp"></jsp:include>
<jsp:include page="../Menu/CategoryMenu.jsp"></jsp:include>---%>

<a href="manage_categories">Manage Category</a> &nbsp; &nbsp; <a
			href="manage_suppliers">Manage Supplier</a> &nbsp; &nbsp; <a
			href="manage_products">Manage Product</a> &nbsp; &nbsp;
			
${Message}			

<center>
<h2> Manage Product Details </h2>

<c:if test="${empty product.name}">
<c:url var="addAction" value="/manage_product_create"></c:url>
</c:if>

<c:if test="${!empty product.name}">
<c:url var="addAction" value="/manage_product_update"></c:url>
</c:if>

	<form:form action="${addAction}" commandName="product"  method="post" enctype="multipart/form-data" >

<table border="7">
<thead>

<tr>

<td><form:label path="id"><spring:message text="id" /></form:label></td>

	<c:choose>
	<c:when test="${not empty product.id} ">
	<td><form:hidden path="id"  readonly="true"/></td>
	</c:when>
	<c:otherwise>
	<td><form:input path="id" required="true" /></td>
	</c:otherwise>
	</c:choose>
	</tr>

<tr>
<td><form:label path="name"><spring:message text="Name" /></form:label></td>
<td><form:input path="name" required="true" title="Name should not be empty"/></td>
</tr>

<tr>
<td><form:label path="price"><spring:message text="Price" /></form:label></td>
<td><form:input path="price" required="true" title="Enter Price"/></td>
</tr>



<tr><td>Category ID:</td><td><form:select path="category_id" required="true"><spring:message text="Category_id"/>
				<c:forEach items="${categoryList}" var="category">
								<form:option class="form-control" value="${category.id}">${category.id}</form:option>
							</c:forEach>
								</form:select></td></tr>

<tr><td>Supplier ID:</td><td><form:select path="supplier_id" required="true"><spring:message text="Supplier_id"/>
				<c:forEach items="${supplierList}" var="supplier">
								<form:option class="form-control" value="${supplier.id}">${supplier.id}</form:option>
							</c:forEach>
								</form:select></td></tr>
								
					<%---- <tr>
					<td>Image: </td>
					<td><form:input type="file"
							class=" btn btn-default btn-block form-control" path="image"
							required="true" /></td>
							</tr>--%>
							
     <tr>
        <td>
            <form:label path="image">
                <spring:message text="Photo to upload"/>
            </form:label>
        </td>
        <td>
            <form:input type="file" path="image" />
        </td><td></td>
        
    </tr>
							
							 
							
       
							
										
<tr>
<td colspan="2"><c:if test="${!empty product.name}"><input type="submit" value="<spring:message text="Update Product"/>" />
	</c:if>
	<c:if test="${empty product.name}">
	<input type="submit" value="<spring:message text="Create Product"/>" />
	</c:if>
	</td>
	</tr>

</table>
</form:form>
<br>
	
<h3>Product List</h3>
	<c:if test="${!empty productList}">
	<table class="tg">
			<tr>
			<th width="80">id</th>
			<th width="120">Name</th>
			<th width="120">Price</th>
			<th width="120">Category_id</th>
			<th width="120">Supplier_id</th>
			<!-- <th width="60">Image</th> -->
			<th width="60">Edit</th>
			<th width="60">Delete</th>
			</tr>
	<c:forEach items="${productList}" var="product">
			<tr>
			<td>${product.id}</td>
			<td>${product.name}</td>
			<td>${product.price}</td>
			<td>${product.category_id}</td>
			<td>${product.supplier_id}</td>

			 <td><div class="thumbnail">
			<img height="100px" width="100px" alt="${product.id}"src="<c:url value="/resources/img/${product.id}.jpg"></c:url>">
			</div> 
			
			<td><a href="<c:url value='/manage_product_edit/${product.id}' />">Edit</a></td>
					
			<td><a href="<c:url value='/manage_product_delete/${product.id}' />">Delete</a></td>
			</tr>
	</c:forEach>
	</table>
	</c:if>

</center>

<%---<jsp:include page="../Menu/Footer.jsp"></jsp:include>---%>
</body>
</html>