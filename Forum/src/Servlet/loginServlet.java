package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDaoImpl;
import Entity.User;
import Service.UserServiceImpl;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginName = request.getParameter("loginName");
		String loginPassword = request.getParameter("loginPassword");
		UserServiceImpl userservice = new UserServiceImpl();
		User usertemp = new User();
		usertemp.setUsername(loginName);
		usertemp.setPassword(loginPassword);
		User user = userservice.loginService(usertemp);
		if(!(user.getUsername().equals("null"))){
			HttpSession session = request.getSession();
			int userId = userservice.getid(loginName);
			session.setAttribute("userId", userId);
			session.setAttribute("loginName", loginName);
			session.setAttribute("loginPassword", loginPassword);
			if("yes".equals(request.getParameter("rememberMe"))){
				Cookie cookie = new Cookie("RM",loginName);
				cookie.setMaxAge(7*24*60*60);
				response.addCookie(cookie);
			}
			response.sendRedirect("boardServlet");
		}
		else{
			response.sendRedirect("errorpage.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
