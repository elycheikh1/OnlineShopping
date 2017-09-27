'use strict'
$(document).ready(function() {
	ajax_call();
	//setInterval(ajax_call, 1000*30);

	function ajax_call(){
		var time = 1;
		setTimeout(function(){
			$.ajax({
				url: "Home",
				type: "POST",
				data: {"action": "listProducts"},
				success: ajaxSuccess,
				//complete: ajax_call
			});
		}, time);

		
		function ajaxSuccess(data){
			
			$("#listProducts").empty();
			$.each(data, function(i,item) {
				console.log("name: "+this.name + ", price: " + this.price + ", image: " + this.image)
				var img = $("<img>", {
					"style": "float:left",
					"alt": "product_image",
					"src": this.image,
					"height": "300px",
					"width": "300px",
					/*"class":"img-circle"*/
				
				});
				var a = $("<a>", {
					"style": "float:left",
					"href": "ProductDetail?productId="+this.productId
				});
				
				a.append(img);
				var prName = $("<p>").html("<h4><strong>" +"$"+ this.name + "</strong></h4>");
				var prPrice= $("<p>").html("<h3>" + this.price + "</h3>");
				var prLeft= $("<p>").html("<h3>"+this.quantity +" left in store </h3>");
				
				var div = $("<div>");//.append(a).append(prName).append(prPrice).append(prLeft);
				div.append(a);
				div.append(prName);
				div.append(prPrice);
				div.append(prLeft);
				$("#listProducts").append(div);
				$("#listProducts").append("<hr>");
				//$("#listProducts").append("name: "+this.name + ", price: " + this.price + ", image: " + this.image);
			});
		}
	}	
});