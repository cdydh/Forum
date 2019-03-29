package Service;

import java.util.List;

import DAO.TopicDaoImpl;
import Entity.Topic;

public class TopicServiceImpl implements TopicService {
	
	TopicDaoImpl topicdao = new TopicDaoImpl();
	public void topicPublish(Topic topic) {
		topicdao.topicInsert(topic);
	}

	public List<Topic> topicRead(String boardid) {
		return topicdao.topicSelect(boardid);
	}

	@Override
	public void topicEdit(Topic topic) {
		topicdao.topicUpdate(topic);
	}

	@Override
	public void topicDelete(int topicId) {
		topicdao.topicDelete(topicId);
	}

	@Override
	public String gettopicContent(int topicId) {
		return topicdao.selectcontent(topicId);
	}

	@Override
	public int countusernumber(int topicId) {
		return topicdao.countusernumber(topicId);
	}

	@Override
	public String getTitle(int topicId) {
		return topicdao.selectTitle(topicId);
	}

	@Override
	public String getAuthor(int topicId) {
		return topicdao.selectUsername(topicId);
	}

	@Override
	public List<Topic> listAll() {
		return topicdao.selectAll();
	}

}
