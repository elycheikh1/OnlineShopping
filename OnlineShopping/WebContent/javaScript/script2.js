$(function() {
	ajax_call();
	// setInterval(ajax_call, 1000*30);

	function ajax_call() {
		$.ajax({
			url : "OrderHistory",
			type : "POST",
			success : ajaxSuccess
		});
	}
	// $.get("ProductController.do", {"action": "listProducts"})
	// .done(ajaxSuccess)
	// .fail(ajaxFailure);

	function ajaxSuccess(data) {
		// var objs =
		$("#box").empty();
		// var json = data;
		$.each(data, function() {
			var d = $("<p>").html("<strong>Date: " + this.date + "</strong>");
			var sh = $("<p>").html(
					"<em>Shipped To: " + this.shippingAddress + "</em>");
			var bill = $("<p>").html(
					"<em>Bill Sent To: " + this.billingAddress + "</em>");
			var tb = $("<table class=\"table\">");
			var th = $("<thead>");
			var tr = $("<tr>");
			tr.append($("<th>Id</th>"));
			tr.append($("<th>Name</th>"));
			tr.append($("<th>Price</th>"));
			th.append(tr);
			var tbody = $("<tbody>");
			var productList = this.products;
			$.each(productList, function() {
				var trBody = $("<tr>");
				trBody.append("<td>" + this.productId + "</td>");
				trBody.append("<td>" + this.name + "</td>");
				trBody.append("<td>" + this.price + "</td>");
				tbody.append(trBody);
			});
			tb.append(th);
			tb.append(tbody);

			$("#box").append(d);
			$("#box").append(sh);
			$("#box").append(bill);
			$("#box").append(tb);
			$("#box").append("<hr>");
		});

	}
	// $("#listProducts").append("name: "+this.name + ", price: " + this.price +
	// ", image: " + this.image);
});