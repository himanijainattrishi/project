
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="true"%>
<%@page isELIgnored="false" %>

<head>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.3/angular.min.js"></script> 
    </head>

       <td>${p.category}</td> 
     <td>
        <c:if test="${!empty list}"> 
	<table class="tg">
	<tr>
		<th width="80">Product ID</th>
		<th width="120">Product Name</th>
		<th width="120">Product Price</th>
		
	</tr>
	<c:forEach items="${list}" var="product">
		<tr>
			<td>${product.id}</td>
			<td>${product.name}</td>
			<td>${product.price}</td>
			
		</tr>
	<%-- </c:forEach> --%>
	<!-- </table> -->
<%--  </c:if>  --%>
   
    <form action="${session.getContextPath()}/shoppingcart/showproduct/${product.id}" method="post">
   <input type="hidden" value=${product.id} name="id"/>
       <input type="hidden" value=${product.name} name="name"/>
       <input type="hidden" value=${product.price} name="price"/>
       
     
      <input type="hidden" value=${product.category} name="category"/> 
         
        <input type="submit" value="MoreDetails"></form></td>

     
    </tr>   
</tbody>         
       </c:forEach>
    </table></div>
    </c:if> 
</div> 