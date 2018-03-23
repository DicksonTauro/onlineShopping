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

				<div class="navbar-header">

					<a class="navbar-brand" href="${contextRoot}/home">Home</a>
				</div>

			</div>


		</nav>
		<!-- Page Content -->
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="jumbotron ">
						<h1>${errorTitle}</h1>
						<hr />
						<blockquote class="error-msg-break">${errorDescription}</blockquote>
					</div>
			<!-- Footer -->
			</div>
			</div>

		</div>
<%@ include file="./shared/footer.jsp"%>
</div>


		
		
</body>

</html>
