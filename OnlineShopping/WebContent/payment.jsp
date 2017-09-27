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
		
	
	<form action="PaymentController" method="post">
	
		<fieldset class="border1 paymentBox"><legend>Payment Information:</legend>
    	<div>
        	<p><label>Card Type:</p>
	        <label> <input name="cardtype" type="radio" value="visa" />VISA</label> | 
	        <label> <input name="cardtype" type="radio" value="americanExpress" />American Express</label>  | 
	        <label> <input name="cardtype" type="radio" value="mastercard" />Mastercard</label>
		</div> 
		<br>
		<div>	
		   <label for=cardnumber>Card Number: 
		   <input name=cardnumber pattern="\d{12,}" type="text" required class="form-control"/></label><br />
		   <label for=secure>Security Code: 
		   <input name=secure pattern="\d{3}" type="text" size="3" maxlength="3" required class="form-control" /></label><br />
		   <label for="namecard">Expiration date:
		   <input  name="month" pattern="\d{2}" type="text" placeholder="mm" size="2" maxlength="2" required class="form-control card"/>
		   /<input  name="year" type="text" pattern="\d{2}" placeholder="yy"  size=2 maxlength=2 required class="form-control card"/></label>
		</div>
	</fieldset>
	<br>
       <input type=submit value="Buy it" class="btn btn-primary" />
  </form>
</div>
	<jsp:include page="page_footer.jsp" />
</body>
</html>

	