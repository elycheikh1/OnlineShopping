<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	
	<div class="loginmodal-container">
			
		<h3>Customer information</h3>
			<br><form action="CustomerController" method="post">
		
			<table class="table1">
				<tr><td><label>Full Name:</label><input required type="text" pattern = "^[a-zA-Z\-]+$" name="name"  class="form-control" /></td></tr>
				<tr><td><label>E-mail:</label><input  type="text" name="email"  class="form-control"  pattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$" /></td></tr>
				<tr><td><label>Phone:</label><input required type="text" name="phone"  class="form-control" pattern = "^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$" /></td></tr>
				<tr><td><label>User Name:</label><input type="text" required name="uName" class="form-control"/></td></tr>
				<!-- <tr><td><label>Password:</label><input type="password" required name="pwd"  class="form-control" pattern = "^(?=.*[0-9])(?=.*[A-Z])[a-zA-Z0-9!@#$%^&*]{6,16}$"/></td></tr> -->
				<tr><td><label>Password:</label><input type="password" required name="pwd"  class="form-control"/></td></tr>
				<tr><td><br /><input type="submit" value="Continue" class="btn btn-primary" /></td></tr>
			</table>
		</form>
	</div>
	</div>
<jsp:include page="page_footer.jsp" />
</body>
</html>

	