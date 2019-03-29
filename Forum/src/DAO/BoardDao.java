package DAO;

import java.util.List;

import Entity.Board;

public interface BoardDao {
	abstract public List<Board>SelectAll();
	abstract public int SelectBoardId();
	abstract public int SelectToday();
	abstract public int SelectYesterday();
	abstract public String SelectidByname(String boardname);
}
