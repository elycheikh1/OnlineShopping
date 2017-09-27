package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserImp;
import model.User;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserController() {}
	private UserImp userDb;
	//private AddressImp addressDb;


	@Override
	public void init() throws ServletException {
		userDb = new UserImp();
		//addressDb = new AddressImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("at first userController");
		
	/*	String username = request.getParameter("user_name");
		String password = request.getParameter("pass");*/
		String newUsername = request.getParameter("newuser_name");
		String newPassword = request.getParameter("newpass");
		
		User newUser = new User(newUsername,newPassword, false);
		
		User user = (User) request.getSession().getAttribute("user_info");
		newUser.setUserid(user.getUserid());
		System.out.println(user.getUserid() + " " +user.getUsername()+ " "+ user.getPassword());
		
		
		userDb.updateUserAccount(user.getUserid(), newUser);

		request.getSession().setAttribute("user_info", user);
		response.sendRedirect("addSBaddress.jsp");
	}

}
