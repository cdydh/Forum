package Servlet;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

/**
 * Servlet implementation class topicServlet
 */
@WebServlet("/topicServlet")
public class topicServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Topic topic = new Topic();
		TopicServiceImpl topicservice = new TopicServiceImpl();
		BoardServiceImpl boardservice = new BoardServiceImpl();
		String boardId = boardservice.getboardid(request.getParameter("boardname"));
		int userId = (int) session.getAttribute("userId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");  
		Date postTime = new Date();		
		topic.setBoardId(boardId);
		topic.setUserId(userId);
		topic.setTitle(title);
		topic.setContent(content);
		topic.setPostTime(postTime);
		topicservice.topicPublish(topic);
		response.sendRedirect("topicshowServlet"+"?"+boardId);
		//request.getRequestDispatcher("topicshowServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
