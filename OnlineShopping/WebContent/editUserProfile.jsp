<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
    <link rel="stylesheet" href="CSS/styleMain.css">
</head>
<body>
<jsp:include page="page_header.jsp" />
	<div class="mainContainer">
		
	<h4>Fill the bellow form to change you current username or/and password:</h4>

		<div class="box col-sm-8">
		<form action="UserController" method="post">
		 <table class="table2"><tr><td>
		 
<%-- 		<fieldset class="border1">
		 <legend> Current: </legend>
		 	Current User Name: <input type="text" value="${cookie.user.value}" name="user_name" class="form-control" />
			Current Password: <input type="password" name="pass" class="form-control"/>
		 </fieldset> --%>
		 
		</td><td>
		<fieldset class="border1">
		 <legend> New: </legend>
		 	New User Name: <input required type="text" name="newuser_name" class="form-control" />
			New Password: <input required type="password" name="newpass" class="form-control"/>
		 </fieldset>
		</td></tr>
		</table>
		
			<input class="btn btn-primary" type="submit" value="change" />
		
		</form> 
		<span style="color: red">${err_msg}</span>
		</div>
	</div>
	<hr>
<jsp:include page="page_footer.jsp" />	
</body>
</html>