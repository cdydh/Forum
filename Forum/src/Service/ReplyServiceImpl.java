package Service;

import java.util.List;

import DAO.ReplyDaoImpl;
import Entity.Reply;

public class ReplyServiceImpl implements ReplyService {
	ReplyDaoImpl replydao = new ReplyDaoImpl();
	@Override
	public List<Reply> list(String topicid) {
		return replydao.SelectAll(topicid);
	}
	@Override
	public void answer(Reply reply) {
		replydao.Insert(reply);
	}

}
