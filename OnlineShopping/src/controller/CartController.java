package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductImp;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/Cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductImp dao;
	
	public CartController() {   
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		dao = new ProductImp();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("cart.jsp");
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Cart cart = (Cart) session.getAttribute("cart");

		int productId = Integer.parseInt(request.getParameter("productId"));
		Product product = dao.getProductById(productId);
		cart.removeProduct(product); // add to product Cart
		session.setAttribute("cart", cart);
		
		RequestDispatcher view = request.getRequestDispatcher("cart.jsp");
		view.forward(request, response);
	}

}
