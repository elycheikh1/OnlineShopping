<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Z shopping: login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="CSS/styleMain.css">

</head>
<body>
	<jsp:include page="page_header.jsp" />

	<div class="mainContainer">

		<div class="loginmodal-container">
			<h1>Login to Your Account</h1>
			<br>
			<form action="weblogin" method="post">
				<input required type="text" name="user_name" placeholder="Username">
				<input required type="password" name="pass" placeholder="Password">
				<input type="submit" name="login" class="login loginmodal-submit"
					value="Login"> <input type="hidden" name="logintype"
					value="admin" />
			</form>

			<div class="login-help">
				<span style="color: red">${err_msg}</span> <a
					href="CustomerController">Register</a>

			</div>
		</div>
	</div>


	<hr>
	<jsp:include page="page_footer.jsp" />
</body>
</html>