package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Reply;
import Entity.Topic;
import Util.Jdbc;
import Util.ResultSetHandler;

public class ReplyDaoImpl implements ReplyDao{

	@Override
	public List<Reply> SelectAll(String topicid) {
		String sql = "select * from reply where TopicId=?";
		Object obj = Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				List<Reply> replylist = new ArrayList<>();
				while(rs.next()) {
					Reply reply = new Reply();
					reply.setReplyId(rs.getInt("ReplyId"));
					reply.setUserId(rs.getInt("UserId"));
					reply.setTopicId(rs.getString("TopicId"));
					reply.setContent(rs.getString("Content"));
					reply.setReplyTime(rs.getDate("ReplyTime"));
					replylist.add(reply);
				}
				return replylist;
			}
		},topicid);
		return (List<Reply>)obj;
	}
	
	@Override
	public int SelectReplyId() {
		String sql = "select ReplyId from reply order by reply.ReplyId desc limit 1";
		int obj = (int)Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				int ReplyId = 0;
				while(rs.next()) {
					ReplyId=rs.getInt("ReplyId");
				}
				return ReplyId;
			}
		});
		return obj;		
	}
	
	@Override
	public void Insert(Reply reply) {
		int replyId = SelectReplyId();
		Object[] replytemp={replyId+1,reply.getUserId(),reply.getTopicId(),reply.getContent(),reply.getReplyTime()}; 
		String sql ="Insert into reply values(?,?,?,?,?)";
		Jdbc.executeUpdate(sql, replytemp);
	}

	

}
