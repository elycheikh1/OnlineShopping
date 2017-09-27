package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.ProductImp;
import model.Cart;
import model.Product;

//@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductImp dbm;  
	
    public Home() { super();}
    
    @Override
    public void init() throws ServletException {
    	dbm = new ProductImp();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Cart cart;
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("cart") == null) {
			cart = new Cart(null, new ArrayList<>());
		} else {
			cart = (Cart) session.getAttribute("cart");
		}
		if (action.equalsIgnoreCase("addToCart")) {
			
			int productId = Integer.parseInt(request.getParameter("productId"));
			Product product = dbm.getProductById(productId);
			cart.addProduct(product); // add to product Cart
			session.setAttribute("cart", cart);
			RequestDispatcher view = request.getRequestDispatcher("home.jsp");
			view.forward(request, response);
		}	
		else if(action.equalsIgnoreCase("reset")){
			session.setAttribute("cart", null);
			RequestDispatcher view = request.getRequestDispatcher("home.jsp");
			view.forward(request, response);
		}
		else{
			
			doPost(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(dbm.getAllProducts());
		System.out.println(json);
	    response.setContentType("text/json");
	    response.setCharacterEncoding("UTF-8");

	    out.write(json);
	    out.close();
	}

}
