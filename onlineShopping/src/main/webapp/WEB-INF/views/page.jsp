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
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName }">

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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">
<link href="${css}/jquery.dataTables.css" rel="stylesheet">

</head>

<body>
   
   
   	<div class="wrapper">
		<!-- Navigation -->
		<%@ include file="./shared/header.jsp"%>
		<!-- Page Content -->
		<div class="container">
		
					<div class="content">
						<c:if test="${userClickHome == true }">
							<%@ include file="home.jsp"%>
						</c:if>
						<c:if test="${userClickContact == true }">
							<%@ include file="contact.jsp"%>
						</c:if>
						<c:if test="${userClickAbout == true }">
							<%@ include file="about.jsp"%>
						</c:if>
						<c:if test="${userClickAllProducts == true }">
							<%@ include file="listProduct.jsp"%>
						</c:if>
						<c:if test="${userClickCategoryProducts == true }">
							<%@ include file="listProduct.jsp"%>
						</c:if>
						<c:if test="${userClickShowProduct == true }">
							<%@ include file="product.jsp"%>
						</c:if>
						<!-- Load only when user click manage product value set in ProductManagementController-->
						<c:if test="${userClickManageProducts == true }">
							<%@ include file="manageProducts.jsp"%>
						</c:if>
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
