package Service;

import java.util.List;

import Entity.Reply;

public interface ReplyService {
	abstract public List<Reply> list(String topicid);
	abstract public void answer(Reply reply);
}
