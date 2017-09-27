
//include('page_header.jsp');
$(document).ready(function(){
	$("#dateTimeTicker").html(new Date())
    // Setup and switch-on DateTime ticking clock
    setInterval(() => {   	
 $("#dateTimeTicker").html(new Date());
		
    }, 1000);
    
});