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



${Message}

<c:if test="${ not empty loginmessage}">
<a href="logout"><button type="button" class="btn btn-danger">logout</button></a><br>
</c:if>

<h1>Add a Category</h1>
	<c:url var="addAction" value="/manage_category_add"></c:url>
	<form:form action="${addAction}" commandName="category"  method="post">
		<table>
			<tr>
				<td><form:label path="id"> <spring:message text="ID" />	</form:label></td>
				<c:choose>
					<c:when test="${!empty category.id}">
						<td><form:input path="id" disabled="true" readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td><form:input path="id" pattern=".{5,20}" required="true"
								title="id should contains 5 to 20 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
				<td><form:label path="name">	<spring:message text="Name" /> </form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="description"> <spring:message text="Description"/></form:label></td>
				<td><form:input path="description" required="true" /></td>
			</tr>
			
				
			<tr>
				<td colspan="2"><c:if test="${!empty category.name}">
				        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="submit" value="<spring:message text="Edit Category"/>" />
					</c:if> <c:if test="${empty category.name}">
					    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="submit" value="<spring:message text="Add Category"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Category List</h3>
	<c:if test="${!empty categoryList}">
		<table class="tg" border="1" style="padding-left:200px;">
			<tr>
				<th width="120">Category ID</th>
				<th width="120">Category Name</th>
				<th width="250">Category Description</th>
				<th width="80">Edit</th>
				<th width="80">Delete</th>
			</tr>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a href="<c:url value='/manage_category_edit/${category.id}' />">Edit</a></td>
					
					<td><a href="<c:url value='/manage_category_delete/${category.id}' />">Delete</a></td>
				</tr>
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
	

</body>
</html>