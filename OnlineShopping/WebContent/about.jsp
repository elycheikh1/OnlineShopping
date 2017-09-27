<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Waga webstore</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <link rel="stylesheet" href="CSS/styleMain.css">
</head>
<body>
<jsp:include page="page_header.jsp" />

	<div class="container">

      <!-- Introduction Row -->
      <h1 class="my-4">
        <small>It's Nice to Meet You!</small>
      </h1>
      

      <!-- Team Members Row -->
      <div class="row">
        <div class="col-lg-12">
          <h2 class="my-4">Our Team</h2>
        </div>
        <div class="col-sm-3 text-center mb-4">
          <img class="rounded-circle img-fluid d-block mx-auto" src="images/200x200.png" alt="">
          <h3>Eshan Kuthu
          </h3>
        
        </div>
        <div class="col-sm-3 text-center mb-4">
          <img class="rounded-circle img-fluid d-block mx-auto" src="images/200x200.png" alt="">
          <h3>Ely Cheikh Deddah
          </h3>
         
        </div>
        <div class="col-sm-3 text-center mb-4">
          <img class="rounded-circle img-fluid d-block mx-auto" src="images/200x200.png" alt="">
          <h3>Henok Gebremenfes 
            
          </h3>
          
        </div>
             <div class="col-sm-3 text-center mb-4">
          <img class="rounded-circle img-fluid d-block mx-auto" src="images/200x200.png" alt="">
          <h3>Selamawit Gebrerufael
           
          </h3>
         
        </div>
        

    </div>
			

</div>
<div class="container">
 <h1 class="my-4">
        <small>Leave message, How you find our Project ?</small>
      </h1>
<form action="AboutController" method="post">
  				<p><label>Email: <input type="text" name="uemail"  class="form-control"></label></p>
 			 	<p><label>Comment:<textarea name="comment" cols="60" rows="8" class="form-control" placeholder="Any comment"></textarea> </label></p>
 			 	<input type="submit" value="submit" class="btn btn-primary"/>
			</form>
	</div>

	<jsp:include page="page_footer.jsp" />
</body>
</html>