package Service;

import java.util.List;

import Entity.Topic;

public interface TopicService {
	abstract public void topicPublish(Topic topic);
	abstract public List<Topic> topicRead(String boardid);
	abstract public List<Topic> listAll();
	abstract public void topicEdit(Topic topic);
	abstract public void topicDelete(int topicId);
	abstract public String gettopicContent(int topicId);
	abstract public int countusernumber(int topicId);
	abstract public String getTitle(int topicId);
	abstract public String getAuthor(int topicId);
}
