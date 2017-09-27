package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductImp;
import model.Product;

//@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductImp dbm;
	public static final String lIST_PRODUCTS = "productList.jsp";
	public static final String INSERT_OR_EDIT = "product.jsp";
	public static final String CART = "cart.jsp";
	public static final String DETAIL = "ProductDetail";

	@Override
	public void init() throws ServletException {
		dbm = new ProductImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward;
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("delete")) {
			forward = lIST_PRODUCTS;
			int productId = Integer.parseInt(request.getParameter("productId"));
			dbm.deleteProduct(productId);
			request.setAttribute("products", dbm.getAllProducts());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int productId = Integer.parseInt(request.getParameter("productId"));
			Product product = dbm.getProductById(productId);
			request.setAttribute("action", "edit");
			request.setAttribute("cProduct", product);
		} else if (action.equalsIgnoreCase("insert")) {
			request.setAttribute("action", "insert");
			forward = INSERT_OR_EDIT;
		} else {
			forward = lIST_PRODUCTS;
			request.setAttribute("products", dbm.getAllProducts());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String prId = request.getParameter("productId");
		String prName = request.getParameter("name");
		String price = request.getParameter("price");
		String prDescription = request.getParameter("description");
		String prImage = request.getParameter("image");
		String prQuantity= request.getParameter("quantity");
		Product product = new Product(Integer.parseInt(prId), prName, price, prDescription, prImage, Integer.parseInt(prQuantity));
		
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("edit")) {
			dbm.updateProduct(product);
		}
		else { 
			dbm.addProduct(product);
		}
		RequestDispatcher view = request.getRequestDispatcher(lIST_PRODUCTS);
		request.setAttribute("products", dbm.getAllProducts());
		view.forward(request, response);

	}
}