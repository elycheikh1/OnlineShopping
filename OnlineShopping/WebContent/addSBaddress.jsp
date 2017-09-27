<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address Info</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <link rel="stylesheet" href="CSS/styleMain.css">
</head>
<body>
<jsp:include page="page_header.jsp" />
	
	<div class="mainContainer">
		
	<h3>Shipping and Billing address information</h3>
	<form action="AddressController" method="post">
		<table width=500px align=center>
		<tr><td><label>Shipping Address:</label><input type="text" required name="sAddress" placeholder="St No., zip code, city, state" class="form-control" /></td></tr>
			<tr><td><label>Billing Address:</label><input type="text" required name="bAddress" placeholder="St No., zip code, city, state" class="form-control" /></td></tr>
			<tr><td><br /><input type="submit" value="Continue" class="btn btn-primary" /></td></tr>
		</table>
	</form>
	<p><c:out value = "${store}"></c:out></p>
	</div>
</body>
<jsp:include page="page_footer.jsp" />
</html>

