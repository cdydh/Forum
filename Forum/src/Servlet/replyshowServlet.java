package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Reply;
import Entity.Topic;
import Service.ReplyServiceImpl;
import Service.TopicServiceImpl;


@WebServlet("/replyshowServlet")
public class replyshowServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyServiceImpl replyservice = new ReplyServiceImpl();
		TopicServiceImpl topicservice = new TopicServiceImpl();
		List<Reply> replylist = new ArrayList<>();
		List<Topic> topiclist = new ArrayList<Topic>();
		String topicid = request.getQueryString();
		String title =topicservice.getTitle(Integer.parseInt(topicid));
		String content = topicservice.gettopicContent(Integer.parseInt(topicid));
		String username = topicservice.getAuthor(Integer.parseInt(topicid));
		int replynumber = topicservice.countusernumber(Integer.parseInt(topicid));
		replylist = replyservice.list(topicid);
		topiclist = topicservice.listAll();
		request.setAttribute("username", username);
		request.setAttribute("titletemp", title);
		request.setAttribute("replynumbertemp", replynumber);
		request.setAttribute("topicidtemp", topicid);
		request.setAttribute("contenttemp", content);
		request.setAttribute("topiclisttemp", topiclist);
		request.setAttribute("replytemp", replylist);
		request.getRequestDispatcher("post.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
