<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<br>
<div class="row">
	<c:if test="${not empty message }">
		<div class="col-md-12">

			<div class="${Class} alert alert-dismissible">

				<button type="button" class="close" data-dismiss="alert">&times;</button>
				${message}
			</div>


		</div>

	</c:if>

	<div class="col-md-offset-2 col-md-8">
		<div class="card ">
			<div class="card-header">
				<h6>Product Management</h6>
			</div>
			<div class="card-body">
				<sf:form class="form-horizontal" modelAttribute="product"
					action="${contextRoot}/manage/products" method="POST"
					enctype="multipart/form-data">
					<div class="form-group">
						<label class="col-form-label" for="name">Product Name</label>
						<sf:input type="text" class="form-control" path="name" id="name"
							placeholder="Product Name" />

						<sf:errors path="name" cssClass="help-block" element="em" />
					</div>

					<div class="form-group">
						<label class="col-form-label" for="brand"> Brand Name</label>
						<sf:input type="text" class="form-control" path="brand" id="brand"
							placeholder="Brand Name" />
						<sf:errors path="brand" cssClass="help-block" element="em" />
					</div>

					<div class="form-group">
						<label class="col-form-label" for="description">
							Description</label>
						<sf:textarea rows="4" cols="50" class="form-control"
							path="description" id="description"
							placeholder="Product description"></sf:textarea>
						<sf:errors path="description" cssClass="help-block" element="em" />
					</div>

					<div class="form-group">
						<label class="col-form-label" for="unitPrice"> Unit price</label>
						<sf:input type="text" class="form-control" path="unitPrice"
							id="unitPrice" placeholder="Unit price" />
						<sf:errors path="unitPrice" cssClass="help-block" element="em" />
					</div>

					<div class="form-group">
						<label class="col-form-label" for="quantity"> Quantity
							Available</label>
						<sf:input type="text" class="form-control" path="quantity"
							id="quantity" placeholder="Quantity Available" />
						<sf:errors path="quantity" cssClass="help-block" element="em" />
					</div>
					<!-- file element for image  -->
					<div class="form-group">
						<label class="col-form-label" for="file"> Select an image
							Available</label>
						<sf:input type="file" class="form-control" path="file" id="file" />
						<sf:errors path="file" cssClass="help-block" element="em" />
					</div>

					<div class="form-group">
						<label class="col-form-label" for="categoryId"> Select
							Category</label>
						<sf:select class="form-control" path="categoryId" id="categoryId"
							items="${categories}" itemLabel="name" itemValue="id">
						</sf:select>
						<br />
						<c:if test="${product.id == null}">
							<div class="text-right">
								<button type="button" class="btn btn-info btn-sm"
									data-toggle="modal" data-target="#createCategory">Add
									Category</button>
							</div>
						</c:if>
					</div>


					<div class="row">
						<div class="col-md-12 text-right">
							<input type="submit" class="  btn btn-primary" name="submit"
								id="submit" value="Submit">
							<!-- Hidden fields for Product -->
							<sf:hidden path="id" />
							<sf:hidden path="code" />
							<sf:hidden path="supplierId" />
							<sf:hidden path="activeInd" />
							<sf:hidden path="purchases" />
							<sf:hidden path="views" />
						</div>
					</div>


				</sf:form>

			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-12">
		<h3>Available Products</h3>
	</div>
	<div class="col-md-12">
		<div style="overflow: auto">
			<table id="adminsProductTable"
				class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Quantity</th>
						<th>Unit Price</th>
						<th>Active</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody id="tableBody">
				</tbody>


			</table>

		</div>


	</div>

</div>

<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog"
	aria-labelledby="confirmModal" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel"></h5>
			</div>
			<div class="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="confirm">Yes</button>
				<button type="button" class="btn btn-secondary" id="closed">No</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="infoModal" tabindex="-1" role="dialog"
	aria-labelledby="confirmModal" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="infoModalLabel"></h5>
			</div>
			<div class="modal-body" id="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal"
					aria-label="Close">Ok</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="createCategory" tabindex="-1" role="dialog"
	aria-labelledby="confirmModal" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Add New Category</h5>
			</div>
			<div class="modal-body">
				<sf:form modelAttribute="category" id="categoryForm"
					action="${contextRoot}/manage/category" method="POST">

					<div class="form-group">
						<label for="category_name" class="col-form-label">Category
							Name</label>
						<sf:input type="text" class="form-control" id="category_name"
							path="name" />
					</div>


					<div class="form-group">
						<label for="category_desc" class="col-form-label">Description</label>
						<sf:textarea type="text" class="form-control" id="category_desc"
							path="description" />
					</div>

					<div class="modal-footer">
						<div class="row">
							<div class="col-md-12 text-right">
								<input type="submit" class="  btn btn-primary" name="submit"
									id="submit" value="Submit">
								<button type="button" class="btn btn-primary"
									data-dismiss="modal" aria-label="Close">Close</button>
								<!-- Hidden fields for Product -->
							</div>
						</div>
						</div>
				</sf:form>
			</div>

		</div>


	</div>
</div>
