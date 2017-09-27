package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerImp;
import dao.UserImp;
import model.Customer;
import model.User;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerImp dbm;
    private UserImp userDb;
      
    public CustomerController() {
    }

    @Override
    public void init() throws ServletException {
    	dbm = new CustomerImp();
    	userDb = new UserImp();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addCustomerInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String uName = request.getParameter("uName");
		String pwd = request.getParameter("pwd");
		
		User user = new User(uName,pwd,false);
		User currentUser = userDb.addUser(user);
	
		//User currentUser = userDb.getUserById(user.getUsername());
		
		Customer customer = new Customer(name, email, phone, currentUser.getUserid());
		dbm.saveCustomer(customer);
		
		request.getSession().setAttribute("customer", customer);
		request.getSession().setAttribute("user_info", currentUser);
		request.getSession().setAttribute("userName", currentUser.getUsername());
		
		response.sendRedirect("AddressController");
	}

}
