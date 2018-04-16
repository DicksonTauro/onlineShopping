<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>
<br />
<!-- Page Content -->
<div class="content">
<div class="container">

	<div class="row">
			<div class="col-md-offset-2 col-md-8">
			<div class="card ">
				<div class="card-header">
					<h6>Sign Up - Billing-Address</h6>
				</div>
				<div class="card-body">
					<sf:form class="form-horizontal" method="POST" id="billingForm"
						modelAttribute="billing">

						<div class="form-group">
							<label class="col-form-label" for="addressLineOne">AddressLine 1</label>
							<sf:input type="text" class="form-control" path="addressLineOne"
								id="addressLineOne" />
							<sf:errors path="addressLineOne" cssClass="help-block" element="em"/>	
						</div>

						<div class="form-group">
							<label class="col-form-label" for="addressLineTwo">AdressLine 2</label>
							<sf:input type="text" class="form-control" path="addressLineTwo"
								id="addressLineTwo" />
							<sf:errors path="addressLineTwo" cssClass="help-block" element="em"/>	
						</div>
						
						<div class="form-group">
							<label class="col-form-label" for="city">city</label>
							<sf:input type="text" class="form-control" path="city"
								id="city" />
							<sf:errors path="city" cssClass="help-block" element="em"/>	
						</div>

						<div class="form-group">
							<label class="col-form-label" for="state">state</label>
							<sf:input type="text" class="form-control" path="state"
								id="state" />
							<sf:errors path="state" cssClass="help-block" element="em"/>	
						</div>
						
						<div class="form-group">
							<label class="col-form-label" for="country">country</label>
							<sf:input type="text" class="form-control" path="country"
								id="country" />
							<sf:errors path="country" cssClass="help-block" element="em"/>	
						</div>
						
						<div class="form-group">
							<label class="col-form-label" for="postalCode">Postal Code</label>
							<sf:input type="text" class="form-control" path="postalCode"
								id="postalCode" />
							<sf:errors path="postalCode" cssClass="help-block" element="em"/>	
						</div>
						
					

						<%-- <fieldset class="form-group">
							<legend class="col-form-label">Select Role</legend>

							<div class="form-check form-check-inline">
								<label class="form-check-label"> 
								<sf:radiobutton class="form-check-input" path="role" value="USER" checked="checked"  /> User
								</label>
							</div>
							<div class="form-check form-check-inline">
								<label class="form-check-label"> 
								<sf:radiobutton
									class="form-check-input"  path="role" value="SUPPLIER"/>Supplier
									
								</label>
							</div>
						</fieldset> --%>

						<div class="row">
							<div class="col-md-12 text-right">
								<button type="submit" class="btn btn-primary" name="_eventId_personal">
								previous-pesonal<span class="glyphicon glyphicon-chevron-right"></span>
								</button>
								
								<button type="submit" class="btn btn-primary" name="_eventId_confirm">
								Next-confirm<span class="glyphicon glyphicon-chevron-right"></span>
								</button>
									

							</div>
						</div> 
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<br/>
<%@include file="../shared/flows-footer.jsp"%>