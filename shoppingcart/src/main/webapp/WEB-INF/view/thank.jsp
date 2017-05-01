<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
	
	 <%-- <%@include file="Header.jsp" %> --%>
	 <div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<sf:form class="form-signin" modelAttribute="address">


				
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-8">THANK YOU <b>${address.cname} </b> </div></div><br><br>
						<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-8"><b>  YOUR ORDER WILL BE DISPATCH IN
							${address.caddress}
							</b>
							<input class="btn btn-info" name="_eventId_submit" type="submit"
								value="BACK TO HOME PAGE" />
						</div></div>
					</div>
					<br />

				</sf:form>

			</div>
		</div>
		
		 
		


