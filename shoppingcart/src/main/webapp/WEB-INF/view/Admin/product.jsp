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


			
${Message}		

<c:if test="${ not empty loginmessage}">
<a href="logout"><button type="button" class="btn btn-danger">logout</button></a><br>
</c:if>	

<h1>Add a product</h1>







<c:url var="addAction" value="/manage_product_add?${_csrf.parameterName}=${_csrf.token}"></c:url>
<form:form action="${addAction}" commandName="product" enctype="multipart/form-data" method="post">
		<table>
		
		<tr>
				<td><form:label path="id"> <spring:message text="ID" />	</form:label></td>
				<c:choose> 
					 <c:when test="${!empty product.id}">
						<td><form:input path="id" disabled="true" readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td><form:input path="id" pattern=".{3,20}" required="true"
								title="id should contains 3 to 20 characters" /></td>
					 </c:otherwise>
				</c:choose>
				</tr>
         <tr>
        <td>
            <form:label path="name">
                <spring:message text="Name"/>
            </form:label>
        </td>
        <td> <form:input path="name" /></td>
            <td><form:errors path="name" cssStyle="color:#00ff00;"/></td>
      
    </tr>
    <tr>
     <td>
           
    
            <form:label path="price">
                <spring:message text="Price"/>
            </form:label>
        </td>
        <td>
            <form:input path="price" />
        </td>
         <td><form:errors path="price" cssStyle="color:#00ff00;"/></td>
    </tr>
    
     
    
    
    
    
         <tr>
				<td><form:label path="category">
						<spring:message text="Category" />
					</form:label></td>
				<td><form:select path="category.name" items="${categoryList}"
						itemValue="name" itemLabel="name" /></td>
			</tr>
 
     <tr>
				<td><form:label path="supplier">
						<spring:message text="Supplier" />
					</form:label></td>
					<td><form:select path="supplier.name" items="${supplierList}"
					itemValue="name" itemLabel="name" /></td>
     </tr> 
     
     
     
            
    
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
				 <td colspan="2"><c:if test="${!empty product.name}">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="submit" value="<spring:message text="Edit Product"/>"/> 
					 </c:if>  <c:if test="${empty product.name}">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="submit" value="<spring:message text="Add Product"/>" />
					</c:if>
			</tr>
    
    
     </table> 
 </form:form>
<h3>Product List</h3>

<c:if test="${!empty productList}">

		<table class="tg" border="1" style="padding-left:200px;" id="products"> 
			<tr>
				<th width="80">Product ID</th>
				<th width="120">Product Name</th>
			     <th width="80">Price</th>
				<th width="120">Product Category</th>
				<th width="120">Product Supplier</th>
				<th width="120">Product Image</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			 <c:forEach items="${productList}" var="product"> 
			<!-- <tr ng-repeat="product in prod|filter:searchText"> -->
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
				     <td>${product.price}</td>
					<td>${product.category.name}</td>
					<td>${product.supplier.name}</td>
										
					<td><img  height="300px" width="300px" alt="${product.id}" src="<c:url value="/resources/img/${product.id}.jpg"></c:url>"></td>
                     <td><a href="<c:url value='/manage_product_edit/${product.id}' />">Edit</a></td> 
					
					<td><a href="<c:url value='/manage_product_delete/${product.id}' />">Delete</a></td>
					</tr>
				
        </tbody>
    </c:forEach> 
  </table>
   
 </c:if>

 

  
 <br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


<%---<jsp:include page="../Menu/Footer.jsp"></jsp:include>---%>
</body>
</html>