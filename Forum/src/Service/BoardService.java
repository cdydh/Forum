package Service;

import java.util.List;

import Entity.Board;

public interface BoardService {
	abstract public List<Board> show(); 
	abstract public int getpostnumber();
	abstract public int gettodaypostnumber();
	abstract public int getyesterdaypostnumber();
	abstract public String getboardid(String boardname);
}
