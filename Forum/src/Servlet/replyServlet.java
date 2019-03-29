package Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.Reply;
import Service.ReplyServiceImpl;


@WebServlet("/replyServlet")
public class replyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String topicid = request.getQueryString();
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		Reply reply = new Reply();
		Date replytime = new Date();
		ReplyServiceImpl replyservice = new ReplyServiceImpl();
		int userId = (int) session.getAttribute("userId");
		reply.setUserId(userId);
		reply.setTopicId(topicid);
		reply.setContent(content);
		reply.setReplyTime(replytime);
		replyservice.answer(reply);
		response.sendRedirect("replyshowServlet"+"?"+topicid);
		//request.getRequestDispatcher("replyshowServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
