package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Board;
import Entity.User;
import Util.Jdbc;
import Util.ResultSetHandler;

public class BoardDaoImpl implements BoardDao{

	@Override
	public List<Board> SelectAll() {
		String sql = "select * from board";
		Object obj = Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				List<Board> boardlist = new ArrayList<>();
				while(rs.next()) {
					Board board = new Board();
					board.setBoardId(rs.getInt("BoardID"));
					board.setBoardName(rs.getString("BoardName"));
					board.setRemark(rs.getString("Remark"));
					boardlist.add(board);
				}
				return boardlist;
			}
		});
		return (List<Board>)obj;	
	}

	@Override
	public int SelectBoardId() {
		String sql = "select TopicId from topic order by topic.TopicId desc limit 1";
		int obj = (int)Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				int post = 0;
				while(rs.next()) {
					post=rs.getInt("TopicId");
				}
				return post;
			}
		});
		return obj;		
	}

	@Override
	public int SelectToday() {
		String sql = "select count(*)as count from topic where to_days(PostTime) = to_days(now())";
		int obj = (int)Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				int todaynumber = 0;
				while(rs.next()) {
					todaynumber=rs.getInt("count");
				}
				return todaynumber;
			}
		});
		return obj;	
	}

	@Override
	public int SelectYesterday() {
		String sql = "SELECT count(*)as count FROM topic WHERE TO_DAYS(NOW( )) - TO_DAYS(PostTime) >= 1";
		int obj = (int)Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				int yesterdaynumber = 0;
				while(rs.next()) {
					yesterdaynumber=rs.getInt("count");
				}
				return yesterdaynumber;
			}
		});
		return obj;
	}

	@Override
	public String SelectidByname(String boardname) {
		String sql = "select BoardId from board where BoardName=?";
		String obj = (String)Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				String BoardId = null;
				while(rs.next()) {
					BoardId=rs.getString("BoardId");
				}
				return BoardId;
			}
		},boardname);
		return obj;	
	}

}
