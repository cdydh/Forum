package DAO;

import java.util.List;

import Entity.Reply;

public interface ReplyDao {
	abstract public List<Reply> SelectAll(String topicid);
	abstract public void Insert(Reply reply);
	abstract public int SelectReplyId();
}
