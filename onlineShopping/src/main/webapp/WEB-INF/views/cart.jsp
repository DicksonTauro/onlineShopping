<div class="container">
<c:if test="${not empty message}">
				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<div class="alert alert-success" role="alert">${message}</div>
					</div>
				</div>
			</c:if>
<c:choose>
<c:when test="${not empty cartLines }">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${cartLines}" var ="cartLine">
                
                  <tr>
                        <td class="col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="${images}/${cartLine.product.code}.jpg" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">${cartLine.product.name} 
                                <c:if test="${ cartLine.activeInd==false }">
                                <strong>(Not Available)</strong>
                                </c:if>
                                
                                
                                </a></h4>
                                <h5 class="media-heading"> by <a href="#">${cartLine.product.brand}</a></h5>
                               <!--  <span>Status: </span><span class="text-success"><strong>In Stock</strong></span> -->
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                        <input type="number" class="form-control"  value="${cartLine.productCount}" min="1" max="3" id="count_${cartLine.id}">
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>&#8377; ${cartLine.buyingPrice }</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>&#8377; ${cartLine.total}</strong></td>
                        <td class="col-sm-3 col-md-3">
                        <div>
                        <button type="button" name="refreshCart" value="${cartLine.id}" class="btn btn-info btn-sm">Refresh</button>
                        <a href="${contextRoot}/cart/${cartLine.id}/delete" class="btn btn-danger btn-sm" >
                           Remove
                        </a></div></td>
                    </tr>
                
                
                </c:forEach>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td class="text-right"><h3><strong> &#8377; ${userModel.cart.grandTotal}</strong></h3></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <a href="${contextRoot}/show/all/products" class="btn btn-default">
                           Continue Shopping
                        </a></td>
                        <td>
                        <button type="button" class="btn btn-success">
                            Checkout <span class="glyphicon glyphicon-play"></span>
                        </button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</c:when>


<c:otherwise>
<div class="jumbotron">
<div class="text-center">
<h3>  Your Cart is empty</h3>
</div>
</div>

</c:otherwise>

</c:choose>

</div>

<div class="modal fade" id="error-infoModal" tabindex="-1" role="dialog"
	aria-labelledby="confirmModal" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="error-infoModalLabel"></h5>
			</div>
			<div class="modal-body" id="error-infoModal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal"
					aria-label="Close">Ok</button>
			</div>
		</div>
	</div>
</div>