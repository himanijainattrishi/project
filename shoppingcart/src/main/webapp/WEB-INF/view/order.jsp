<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%--  <%@include file="header.jsp" %> --%>
	
		<br>
		<br>
		<br>
		<div class="container">
		<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-5">ORDER DETAILS</div>
		<div class="col-md-3"></div>
		</div>
		
		
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-10">
				<sf:form modelAttribute="cart" method="post">


					<table class="table table-striped">
						<thead>
							<tr>
                                 <th>ID</th>
								<th>Name</th>
								
								
								<th>Categ</th>
							
								<th>Price</th>
								<th>Quantity</th>
								<th>Total Amount</th>
								
							</tr>
						</thead>

						<tbody>
	<c:forEach items="${sessionScope.cart.listitem}" var="product">
	 <c:set var="sum" value="${sum+ product.p.price * product.quantity}"></c:set> 
							<tr>
							<td>${product.p.id}</td>
								<td>${product.p.name}</td>
								
							
								<td>${product.p.category}</td>
							
								<td>${product.p.price}</td>
						 <td>${product.quantity}</td>  
						 <td>${product.p.price* product.quantity}</td> 
						 	<td><a class="btn btn-danger"
								href="<c:url value='${session.getContextPath()}/deletecart/${product.p.id}' />">Delete  <span class="glyphicon glyphicon-remove-sign"></span></a></td>
							</tr>
</c:forEach>
						</tbody>
	<tr>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	
	
	<td><b>Total Amount::</td>
	<td><b>${sum}</td>
					</table>
					</div>
					
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-4"></div>
						<div class="col-md-4">
							<input class="btn btn-info" name="_eventId_submit" type="submit"
								value="Next" />
								
					
					</div>
					</div>
				

				</sf:form>

			</div>