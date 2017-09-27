package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductImp;
import model.Product;

@WebServlet("/ProductDetail")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductImp dbm;
	  
  
    public DetailController() {super();}

    @Override
    public void init() throws ServletException {
    	dbm = new ProductImp();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		Product product = dbm.getProductById(productId);
		request.getSession().setAttribute("product", product);
		System.out.println(product.getName());
		
		request.getRequestDispatcher("productDetail.jsp").forward(request, response);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
