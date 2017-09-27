<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="style.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <link rel="stylesheet" href="CSS/styleMain.css">
  
<title>Add New Product</title>
</head>
<body>
<jsp:include page="page_header.jsp" />
	<div class="mainContainer">
	<form action="ProductController.do" method="post">
		<fieldset class="table1 border1 ">
		 <legend> product management: </legend>
			<p>
				<label for="productId">Product ID</label> <input type="text"
					name="productId" value="<c:out value="${cProduct.productId}" />"
					placeholder="Product ID[will be generated if not provided]" class="form-control"/>
			</p>
			<p>
				<label for="name">Name</label> <input type="text"
					name="name" value="<c:out value="${cProduct.name}" />"
					placeholder="Name" class="form-control"/>
			</p>
			<p>
				<label for="price">Price</label> <input type="text"
					name="price" value="<c:out value="${cProduct.price}" />"
					placeholder="Price" class="form-control"/>
			</p>
			<p>
				<label for="description">Description</label> <input type="text"
					name="description" value="<c:out value="${cProduct.description}" />"
					placeholder="Description" class="form-control"/>
			</p>
			<p>
				<label for="image">Image</label> <input type="text"
					name="image" value="<c:out value="${cProduct.image}" />"
					placeholder="Image" class="form-control"/>
			</p>
			<p>
				<label for="quantity">Quantity</label> <input type="text"
					name="quantity" value="<c:out value="${cProduct.quantity}" />"
					placeholder="Quantity" class="form-control"/>
			</p>
			<input type="hidden" name="action" value="${action}"/>
			<div>
				<input type="submit" value="Submit" class="btn btn-primary"/>
			</div>
		</fieldset>
	</form>
	</div>
<jsp:include page="page_footer.jsp" />
</body>
</html>