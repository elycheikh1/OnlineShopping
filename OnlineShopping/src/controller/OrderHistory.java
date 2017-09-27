package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.History;
import model.User;

@WebServlet("/OrderHistory")
public class OrderHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderHistory() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("orderhistory.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		User user = (User)request.getSession().getAttribute("user_info");
		if(user != null) {
			List<History> history = mapper.readValue(new File(user.getUsername() + ".json"), List.class);     
			String jsonInString = mapper.writeValueAsString(history);

			response.setContentType("text/json");
		    response.setCharacterEncoding("UTF-8");
	
		    out.write(jsonInString);
		}
	    out.close();
	}

}
