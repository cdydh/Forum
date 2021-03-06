package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.User;
import Service.UserServiceImpl;


@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username;
		String password;
		String confirmpassword;
		username = request.getParameter("username");
		password = request.getParameter("password");
		confirmpassword = request.getParameter("confirmpassword");
		User user = new User();
		UserServiceImpl userservice = new UserServiceImpl();
		if(password.equals(confirmpassword)){
			user.setUsername(username);
			user.setPassword(password);
			userservice.insertUser(user);
			response.sendRedirect("success.jsp");
		}
		else{
			request.setAttribute("error", "注册失败，请重新注册!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
