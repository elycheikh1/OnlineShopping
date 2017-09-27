package controller;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Address;
import model.Cart;
import model.History;
import model.Payment;
import model.User;


@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public PaymentController() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("payment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Address address = (Address)session.getAttribute("address");
		Cart cart = (Cart)session.getAttribute("cart");
		User user = (User)session.getAttribute("user_info");
		
		String cardType = request.getParameter("cardtype");
		
		 String cardNumber = request.getParameter("cardnumber");
		 String securityCode = request.getParameter("secure");
		 String month = request.getParameter("month");
		 String edxpirationDate = month + "/" + request.getParameter("year");
		 
		 Payment payment = new Payment(cardType,cardNumber,  securityCode, edxpirationDate);
		 session.setAttribute("payment", payment);

		 String pInfo = cardType +" " + cardNumber + " " + securityCode + " " + edxpirationDate;
		 System.out.println(pInfo);
		 ObjectMapper mapper = new ObjectMapper();
			History history = new History(Instant.now().toString(), cart.getProducts(), address.getShipping()
					, address.getBilling(), pInfo, user.getUsername());
			//String json = mapper.writeValueAsString(history);
			List<History> historyList = new ArrayList<>();
			try {
				historyList = mapper.readValue(new File(user.getUsername() + ".json"), List.class); 
			} catch(IOException e) {
				e.printStackTrace();
			}
			//List<History> historyList = new ArrayList<>();
			historyList.add(history);
			try {  

		        mapper.writeValue(new File(user.getUsername() + ".json"), historyList );

		    } catch (IOException e) {  
		        e.printStackTrace();  
		    }
		 response.sendRedirect("confirmation.jsp");
		 
	}

}
