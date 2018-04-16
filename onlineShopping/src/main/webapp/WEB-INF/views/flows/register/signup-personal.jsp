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
					<h6>Sign Up - Personal</h6>
				</div>
				<div class="card-body">
					<sf:form class="form-horizontal" method="POST" id="registerForm"
						modelAttribute="user">

						<div class="form-group">
							<label class="col-form-label" for="firstName">First Name</label>
							<sf:input type="text" class="form-control" path="firstName"
								id="firstName" />
							<sf:errors path="firstName" cssClass="help-block" element="em"/>	
						</div>

						<div class="form-group">
							<label class="col-form-label" for="lastName">Last Name</label>
							<sf:input type="text" class="form-control" path="lastName"
								id="lastName" />
							<sf:errors path="lastName" cssClass="help-block" element="em"/>		
						</div>
						
						<div class="form-group">
							<label class="col-form-label" for="email">Email</label>
							<sf:input type="text" class="form-control" path="email"
								id="email" />
							<sf:errors path="email" cssClass="help-block" element="em"/>		
						</div>
						
						<div class="form-group">
							<label class="col-form-label" for="contactNumber">Contact Number</label>
							<sf:input type="text" class="form-control" path="contactNumber"
								id="contactNumber" />
							<sf:errors path="contactNumber" cssClass="help-block" element="em"/>	
						</div>

						<div class="form-group">
							<label class="col-form-label" for="password">Password</label>
							<sf:input type="password" class="form-control" path="password"
								id="password" />
							<sf:errors path="password" cssClass="help-block" element="em"/>	
						</div>
						
						<div class="form-group">
							<label class="col-form-label" for="confirmPassword">Confirm Password</label>
							<sf:input type="password" class="form-control" path="confirmPassword"
								id="confirmPassword" />
							<sf:errors path="confirmPassword" cssClass="help-block" element="em"/>	
						</div>

						<fieldset class="form-group">
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
						</fieldset>

						<div class="row">
							<div class="col-md-12 text-right">
								<button type="submit" class="btn btn-primary" name="_eventId_billing">
								Next-Billing<span class="glyphicon glyphicon-chevron-right"></span>
								</button>
									
								<!-- Hidden fields for Product -->

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

