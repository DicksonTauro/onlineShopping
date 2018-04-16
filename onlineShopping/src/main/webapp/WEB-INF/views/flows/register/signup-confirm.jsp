<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>
<br />
<!-- Page Content -->
<div class="content">
	<div class="container">

		<div class="row">
			<div class="col-md-6">
				<div class="card ">
					<div class="card-header">
						<h6>User Details</h6>
					</div>
					<div class="card-body">
					<div class="text-center">
					<h4>${registerModel.user.firstName} ${registerModel.user.lastName}</h4>
					<h5>${registerModel.user.email}</h5>
					<h5>${registerModel.user.contactNumber}</h5>
					<h5>${registerModel.user.role}</h5>
					</div>
					
					</div>
					<div class="card-footer">
					<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="card ">
					<div class="card-header">
						<h6>Address Details</h6>
					</div>
					<div class="card-body">
					<div class="text-center">
					<h5>${registerModel.address.addressLineOne} </h5>
					<h5>${registerModel.address.addressLineTwo} </h5>
					<h5>${registerModel.address.city}  - ${registerModel.address.postalCode} </h5>
					<h5>${registerModel.address.state} </h5>
					<h5>${registerModel.address.country} </h5>
					</div>
					
					</div>
					<div class="card-footer">
					<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
					</div>
				</div>
			</div>
		</div>
	<br/>
		<div class="row">
			<div class="col-md-12">
			<div class="text-center">
			<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary">Confirm</a>
			
			</div>
			</div>
		</div>
	</div>
</div>
<br />
<%@include file="../shared/flows-footer.jsp"%>