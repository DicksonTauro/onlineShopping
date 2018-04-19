<div class="row">
	<div class="col-md-12">
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a
					href="${contextRoot}/show/all/products">Products</a></li>
				<li class="breadcrumb-item active" aria-current="page">${product.name}</li>
			</ol>
		</nav>
	</div>
</div>

<div class="row">
	<div class="col-md-4">
		<div class="thumbnail">
			<img src="${contextRoot}/resources/images/${product.code}.jpg"
				class="img img-responsive productImage" />
		</div>
	</div>
	<div class="col-md-8">
		<h3>${product.name}</h3>
		<hr />
		<h4>Company : ${product.brand}</h4>
		<hr />
		<p>${product.description}</p>
		<hr />
		<h4>
			Price: <strong>&#8377;</strong>${product.unitPrice} /-
		</h4>
		<hr />


		<c:choose>
			<c:when test="${product.quantity < 1}">
				<h6>
					Quantity Available: <span style="color: red">Out of Stock</span>
				</h6>
			</c:when>
			<c:otherwise>
				<h6>Quantity Available: ${product.quantity}</h6>
			</c:otherwise>
		</c:choose>

        <security:authorize access="hasAuthority('USER')">
		<c:choose>
			<c:when test="${product.quantity < 1}">
				<a href="javascript:void(0)"
					class="btn btn-success disabled"><strike>Add to cart</strike></a>
			</c:when>
			<c:otherwise>
				<a href="${contextRoot}/cart/add/${product.id}/product"
					class="btn btn-success">Add to cart</a>
			</c:otherwise>

		</c:choose>
       </security:authorize>
       <security:authorize access="hasAuthority('ADMIN')">
       
       <a href="${contextRoot}/manage/${product.id}/product"
					class="btn btn-success">Edit</a>
       </security:authorize>
		<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>


	</div>
</div>

