<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart...</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="CSS/styleMain.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"
	rel='stylesheet' type='text/css'>
</head>
<body>
	<jsp:include page="page_header.jsp" />
	<div class="mainContainer">




		<div class="container">
			<div class="row">


				<div class="col-md-10 col-md-offset-1">

					<div class="panel panel-default panel-table">
						<div class="panel-heading">
							<div class="row">
								<div class="col col-xs-6">
									<h3 class="panel-title">List of selected products</h3>
								</div>

							</div>
						</div>
						<div class="panel-body">
							<table class="table ">
								<thead>
									<tr>
										<th scope="row"><em class="fa fa-cog"></em></th>
										<th class="hidden-xs">Product ID</th>
										<th>Product Name</th>
										<th>Price</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${cart.products}" var="product">
										<tr>
											<td>
												<form class="form-horizontal" action="Cart" method="POST">
													<input type="submit" name="remove" value="Remove From Cart"
														class="btn btn-primary" /> <input type="hidden"
														name="productId"
														value=<c:out value="${product.productId}"/> />
												</form>
											</td>
											<td><c:out value="${product.productId}" /></td>
											<td><c:out value="${product.name}" /></td>
											<td><c:out value="${product.price}" /></td>
											

										</tr>
									</c:forEach>

								</tbody>
							</table>
							<div class="panel-footer">
								<div class="row">
									<div >
										<c:if test="${ cart.products[0] != null }">
											<p>
											
													<a href="AddressController" class="btn btn-primary" role="button">Continue to Billing and
													Shipping Address</a>
											</p>
										</c:if>
									</div>
								</div>

							</div>

						</div>

					</div>
				</div>
			</div>



		</div>
		<jsp:include page="page_footer.jsp" />
</body>
</html>