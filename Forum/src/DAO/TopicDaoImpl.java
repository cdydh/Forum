package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Topic;
import Entity.User;
import Util.Jdbc;
import Util.ResultSetHandler;

public class TopicDaoImpl implements TopicDao {
	public int selecttopicid() {
		String sql = "select TopicId from topic order by topic.TopicId desc limit 1";
		int obj = (int)Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				int TopicId = 0;
				while(rs.next()) {
					TopicId=rs.getInt("TopicId");
				}
				return TopicId;
			}
		});
		return obj;		
	} 
	
	public void topicInsert(Topic topic) {
		int TopicId = selecttopicid();
		Object[] topictemp={TopicId+1,topic.getBoardId()
				,topic.getUserId(),topic.getTitle(),topic.getContent(),topic.getPostTime()}; 
		String sql ="Insert into topic values(?,?,?,?,?,?)";
		Jdbc.executeUpdate(sql, topictemp);
	}

	public List<Topic> topicSelect(String boardid) {
		String sql = "select * from topic where BoardId=?";
		Object obj = Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				List<Topic> topiclist = new ArrayList<>();
				while(rs.next()) {
					Topic topic = new Topic();
					topic.setTopicId(rs.getInt("TopicId"));
					topic.setBoardId(rs.getString("BoardId"));
					topic.setUserId(rs.getInt("UserId"));
					topic.setTitle(rs.getString("Title"));
					topic.setContent(rs.getString("Content"));
					topic.setPostTime(rs.getDate("PostTime"));
					topiclist.add(topic);
				}
				return topiclist;
			}
		},boardid);
		return (List<Topic>)obj;
	}
	
	@Override
	public List<Topic> selectAll() {
		String sql = "select * from topic";
		Object obj = Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				List<Topic> topiclist = new ArrayList<>();
				while(rs.next()) {
					Topic topic = new Topic();
					topic.setTopicId(rs.getInt("TopicId"));
					topic.setBoardId(rs.getString("BoardId"));
					topic.setUserId(rs.getInt("UserId"));
					topic.setTitle(rs.getString("Title"));
					topic.setContent(rs.getString("Content"));
					topic.setPostTime(rs.getDate("PostTime"));
					topiclist.add(topic);
				}
				return topiclist;
			}
		});
		return (List<Topic>)obj;
	}

	@Override
	public void topicUpdate(Topic topic) {
		Object[] topictemp={topic.getTopicId(),topic.getBoardId()
				,topic.getUserId(),topic.getTitle(),topic.getContent(),topic.getPostTime(),topic.getTopicId()}; 
		String sql ="UPDATE topic SET TopicId=?,BoardId=?,UserId=?,Title=?,Content=?,PostTime=? WHERE TopicId=?";
		Jdbc.executeUpdate(sql, topictemp);
	}

	@Override
	public void topicDelete(int topicId) {
		String sql = "DELETE FROM topic WHERE TopicId=?";
		Jdbc.executeUpdate(sql, topicId);
	}

	@Override
	public String selectcontent(int topicId) {
		String sql = "select Content from topic where TopicId=?";
		Object obj = Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				String content = null;
				while(rs.next()) {
					content = rs.getString("Content");
				}
				return content;
			}
		},topicId);
		return (String)obj;
	}

	@Override
	public int countusernumber(int topicId) {
		String sql = "select count(*) as count from reply where TopicId=?";
		Object obj = Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				int count = 0;
				while(rs.next()) {
					count = rs.getInt("count");
				}
				return count;
			}
		},topicId);
		return (int)obj;
	}

	@Override
	public String selectTitle(int topicId) {
		String sql = "select Title from topic where TopicId=?";
		Object obj = Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				String title = null;
				while(rs.next()) {
					title = rs.getString("Title");
				}
				return title;
			}
		},topicId);
		return (String)obj;
	}

	@Override
	public String selectUsername(int topicId) {
		String sql = "select UserName from `user`,`topic` WHERE `user`.UserId=topic.UserId and TopicId=?";
		Object obj = Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				String username = null;
				while(rs.next()) {
					username = rs.getString("UserName");
				}
				return username;
			}
		},topicId);
		return (String)obj;
	}
	
}
