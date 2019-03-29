package Service;

import java.util.List;
import Entity.User;
import java.util.ArrayList;

public interface UserService {
	abstract List<User> list();
	abstract public void insertUser(User user);
	abstract public int getmember();
	abstract public String getmembername();
	abstract public int getid(String username);
}
