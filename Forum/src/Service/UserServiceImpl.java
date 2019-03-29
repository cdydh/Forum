package Service;

import java.util.List;

import Entity.User;
import DAO.UserDaoImpl;

public class UserServiceImpl implements UserService {

	UserDaoImpl userdao = new UserDaoImpl();
	
	public List<User> list() {
		return userdao.selectAll();
	}
	public void insertUser(User user){
		userdao.insert(user, "user");
	}
	public User loginService(User user){
		return userdao.selectUser(user);
	}
	@Override
	public int getmember() {
		return userdao.selectlastmember();
	}
	@Override
	public String getmembername() {
		return userdao.selectlastmembername();
	}
	@Override
	public int getid(String username) {
		return userdao.selectuserid(username);
	}

}
