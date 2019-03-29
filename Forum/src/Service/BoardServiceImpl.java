package Service;

import java.util.List;

import DAO.BoardDaoImpl;
import Entity.Board;

public class BoardServiceImpl implements BoardService {
	BoardDaoImpl boarddao = new BoardDaoImpl();
	
	@Override
	public List<Board> show() {	
		return boarddao.SelectAll();
	}

	@Override
	public int getpostnumber() {
		return boarddao.SelectBoardId();
	}

	@Override
	public int gettodaypostnumber() {
		return boarddao.SelectToday();
	}

	@Override
	public int getyesterdaypostnumber() {
		return boarddao.SelectYesterday();
	}

	@Override
	public String getboardid(String boardname) {
		return boarddao.SelectidByname(boardname);
	}

}
