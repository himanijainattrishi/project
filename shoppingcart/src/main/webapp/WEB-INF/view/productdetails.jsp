<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page isELIgnored="false" %>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Home page</title>

    <!-- Bootstrap Core CSS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.3/angular.min.js"></script> 
    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<br><br>
<br><br>
<div class="container" id="product-section">


  <div class="row">
   <div class="col-md-5">
    <img src="resources/images/${product.id}.jpg" class="image-responsive" height="300" width="300"/>
  
   </div>
   <div class="col-md-7">
   <div class="row">
   <div class="col-md-12">
   <h1>${product.name}</h1>
 
   </div>
   </div>
   
   
   <div class="row">
 <div class="col-md-12">
  <span class="label label-primary">Color</span>
  <%=request.getParameter("category") %>
  <%=request.getParameter("name") %>
 <%--  <span class="monospaced">${product.color}</span> --%>
 </div>
</div>
  



<div class="row">
 <div class="col-md-12">
  <p class="description">
 <%--  ${product.desc} --%>
  </p>
 </div>
</div>


<div class="row">
 <div class="col-md-3">
  <span class="sr-only">Four out of Five Stars</span>
  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
  <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
  <span class="label label-success">61</span>
 </div>
 <div class="col-md-3">
  <span class="monospaced">Write a Review</span>
 </div>
</div>
   
<div class="row">
 <div class="col-md-12 bottom-rule">
  <h2 class="product-price">${product.price}</h2>
 </div>
</div>

<div class="row add-to-cart">
 <div class="col-md-3 product-qty">
  <span class="btn btn-default btn-lg btn-qty">
   <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
  </span>
 
 </div>

 <div class="col-md-9">
  <!-- <button class="btn btn-lg btn-brand btn-full-width">
   Add to Cart
  </button>
  -->   <%-- <a href="${session.getContextPath()}/Ecommerce/order/${product.id}">add to cart</a></div> --%>
</div><!-- end row -->

<div class="row">
 <div class="col-md-4 text-center">
  <span class="monospaced">In Stock</span>
 </div>
 <div class="col-md-4 col-md-offset-1 text-center">
  <a class="monospaced" href="index">Add to Shopping List</a>
 </div>
</div><!-- end row -->
<div class="row">
 <div class="col-md-12 bottom-rule top-10"></div>
</div><!-- end row -->

<div class="row">
 <div class="col-md-12 top-10">
  <p>To order by telephone,please call 1-800-555-1212</p>
 </div>
</div>


  <a href="${session.getContextPath()}/shoppingcart/order/${product.id}"><font size=10>Add to cart</font></a></div>
</div>
</div>
</div>
</div>
<%-- <img src="resources/images/${p.id}.jpg" height="150" width="150"/>
${p.id}--%></body>
</html>