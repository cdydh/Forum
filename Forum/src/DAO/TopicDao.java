package DAO;

import java.util.List;

import Entity.Topic;

public interface TopicDao {
	abstract public int selecttopicid();
	abstract public void topicInsert(Topic topic);
	abstract public List<Topic> topicSelect(String boardid);
	abstract public List<Topic> selectAll();
	abstract public void topicUpdate(Topic topic);
	abstract public void topicDelete(int topicId);
	abstract public String selectcontent(int topicId);
	abstract public int countusernumber(int topicId);
	abstract public String selectTitle(int topicId);
	abstract public String selectUsername(int topicId);
}
