

	<div class="row">
		<!-- To Display Side sideBar -->
		<div class="col-md-3">
			<%@ include file="./shared/sidebar.jsp"%>
		</div>

		<!-- To dispalay products -->
		<div class="col-md-9">
			<!-- Added BreadCrum component -->
			<div class="row">
				<div class="col-md-12">
					<c:if test="${userClickAllProducts==true}">
					  <script> 
					window.categoryId = '';
					</script>
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
								<li class="breadcrumb-item active" aria-current="page">All
									products</li>
							</ol>
						</nav>
					</c:if>

					<c:if test="${userClickCategoryProducts==true}">
					<script> 
					
					window.categoryId = ${category.id}
					
					</script>
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
								<li class="breadcrumb-item active">Category</li>
								<li class="breadcrumb-item active" aria-current="page">${category.name}</li>
							</ol>
						</nav>
					</c:if>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<table id="productListTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>quantity</th>
								<th></th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
