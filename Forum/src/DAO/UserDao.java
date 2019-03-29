package DAO;

import java.util.List;

import Entity.User;

public interface UserDao {
	abstract List<User> selectAll();
	abstract public int selectlastmember();
	abstract public String selectlastmembername();
	abstract public int selectuserid(String username);
}
