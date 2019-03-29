package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.Topic;
import Service.BoardServiceImpl;
import Service.TopicServiceImpl;


@WebServlet("/topicshowServlet")
public class topicshowServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TopicServiceImpl topicservice = new TopicServiceImpl();		
		List<Topic> topiclist = new ArrayList<Topic>();
		String boardid = request.getQueryString();
		topiclist = topicservice.topicRead(boardid);
		request.setAttribute("topictemp", topiclist);
		request.getRequestDispatcher("publish.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
