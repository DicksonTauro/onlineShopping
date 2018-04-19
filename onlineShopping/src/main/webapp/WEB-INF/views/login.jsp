<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="fonts" value="/resources/fonts" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/my-app.css" rel="stylesheet">

<%-- <link href="${css}/dataTables.bootstrap.css" rel="stylesheet"> --%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">
<link href="${css}/jquery.dataTables.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<a class="navbar-brand" href="${contextRoot}/home">Online
					Shopping</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item" id="home"><a class="nav-link"
							href="${contextRoot}/home">Home <!--  <span class="sr-only">(current)</span> -->
						</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- Page Content -->
		<div class="container">
		<br>
			<c:if test="${not empty error}">
				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<div class="alert alert-danger" role="alert">${error}</div>
					</div>
				</div>
			</c:if>
			<c:if test="${not empty logout}">
				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<div class="alert alert-success" role="alert">${logout}</div>
					</div>
				</div>
			</c:if>
			<div class="row">
				<div class="col-md-offset-3 col-md-6">

					<div class="card ">
						<div class="card-header">
							<h6>Login</h6>
						</div>
						<div class="card-body">
						
						<form action="${contextRoot}/login" method="post" id="loginForm">
						
						<div class="form-group">
							<label class="col-form-label" for="username">User Name</label>
							<input type="text" class="form-control" name="username" id="username"/>
						</div>
						
						<div class="form-group">
							<label class="col-form-label" for="password">Password</label>
							<input type="password" class="form-control" name="password" id="password"/>
						</div>

						<div class="row">
							<div class="col-md-12 text-right">
								<input type="submit" class="btn btn-primary" value="login"/>
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							</div>
						</div> 
						
						</form>
						</div>
						<div class="card-footer">
							New User ? <a href="${contextRoot}/register"> Register Here</a>
						</div>
					</div>
				</div>
			</div>

</div>

			<%@ include file="./shared/footer.jsp"%>
			<!-- Footer -->

		</div>




		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/my-app.js"></script>
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/jquery.validate.js"></script>
		<%-- 	<script src="${js}/dataTables.bootstrap.js"></script> --%>
		<script src="${js}/dataTables.bootstrap4.js"></script>
</body>

</html>
