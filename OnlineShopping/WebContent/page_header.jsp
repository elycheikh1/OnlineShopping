<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ct" uri="WEB-INF/custom.tld"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> shopping</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="javaScript/header.js"></script>
<link rel="stylesheet" href="CSS/styleHF.css">
<link rel="stylesheet" href="CSS/styleMain.css">
<link rel="stylesheet" href="CSS/main.css">
</head>
<body>

	<div class="mainContainer">
		<c:choose>
			<c:when test="${admin != null}">
				<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#"></a>
					</div>
					<ul class="nav navbar-nav">
						<li class="active"><a href="home.jsp">Home</a></li>
						<li><a href="about.jsp">About</a></li>
						<li><a href="Cart">Cart</a></li>
						<li><a class="lnk" href="orderhistory.jsp">Order History</a></li>
						<li><a class="lnk" href="editUserProfile.jsp">Account</a></li>
						<li><a class="lnk"
							href="ProductController.do?action=listProducts">Manage
								Products</a></li>
						<li><a href="logout">LogOut</a></li>
					</ul>
				</div>
				</nav>
			</c:when>
			<c:when test="${user_info != null}">
				<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#"></a>
					</div>
					<ul class="nav navbar-nav">
						<li class="active"><a href="home.jsp">Home</a></li>
						<li><a href="about.jsp">About</a></li>
						<li><a href="Cart">Cart</a></li>
						<li><a class="lnk" href="orderhistory.jsp">Order History</a></li>
						<li><a href="logout">LogOut</a></li>
					</ul>
				</div>
				</nav>
			</c:when>
			<c:otherwise>
				<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#"></a>
					</div>
					<ul class="nav navbar-nav">
						<li class="active"><a href="home.jsp">Home</a></li>
						<li><a href="about.jsp">About</a></li>
						<li><a href="Cart">Cart</a></li>
						<li><a href="adminlogin.jsp">Login</a></li>
					</ul>
				</div>
				</nav>
			</c:otherwise>
		</c:choose>
		
		
	</div>
	<!--  <div id="dateTimeTicker" Style="font-color='blue';"  align="right">
	<script>new Date()</script>
		<ct:currentDateTime dateFormat="E yyyy.MM.dd" fontColor="blue"
			fontSize="15px" timeFormat="hh:mm:ss a zzz" />
	</div>-->
	<hr>



</body>
</html>