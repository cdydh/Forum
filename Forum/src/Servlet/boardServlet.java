package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Board;
import Service.BoardServiceImpl;
import Service.UserServiceImpl;

/**
 * Servlet implementation class boardServlet
 */
@WebServlet("/boardServlet")
public class boardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardServiceImpl boardservice = new BoardServiceImpl();
		UserServiceImpl userservice = new UserServiceImpl();
		List<Board> boardlist = new ArrayList<>();
		int member;
		String membername;
		int postnumber;
		int todaynumber;
		int yesterdaynumber;
		member = userservice.getmember();
		membername = userservice.getmembername();
		postnumber = boardservice.getpostnumber();
		todaynumber = boardservice.gettodaypostnumber();
		yesterdaynumber = boardservice.getyesterdaypostnumber();
		boardlist=boardservice.show();
		request.setAttribute("membertemp",member);
		request.setAttribute("membernametemp", membername);
		request.setAttribute("postnumbertemp", postnumber);
		request.setAttribute("todaynumbertemp", todaynumber);
		request.setAttribute("yesterdaynumber", yesterdaynumber);
		request.setAttribute("boardtemp", boardlist);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
