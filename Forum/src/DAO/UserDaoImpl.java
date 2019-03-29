package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.User;
import Util.Jdbc;
import Util.ResultSetHandler;



public class UserDaoImpl implements UserDao {
	public List<User> selectAll() {
		String sql = "select * from user where username =? id = ?";
		Object obj = Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				List<User> userlist = new ArrayList<>();
				while(rs.next()) {
					User user = new User();
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					userlist.add(user);
				}
				return userlist;
			}
		});
		return (List<User>)obj;		
	}
	
	public User selectUser(User user) {
		String sql = "select * from user where UserName =? AND UserPwd=?";
		User usertemp = (User)user;
		String username = usertemp.getUsername();
		String password = usertemp.getPassword();
		String[] userArray = {username,password};
		User obj = (User)Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				User userone = new User();
				userone.setUsername("null");
				userone.setPassword("null");
				while(rs.next()) {
					userone.setUsername(rs.getString("UserName"));
					userone.setPassword(rs.getString("UserPwd"));
				}
				return userone;
			}
		},userArray);
		return (User)obj;		
	}
	
	public int selectlastmember() {
		String sql = "select UserId from user order by user.UserId desc limit 1";
		int obj = (int)Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				int member = 0;
				while(rs.next()) {
					member=rs.getInt("UserId");
				}
				return member;
			}
		});
		return obj;		
	}
	
	public String selectlastmembername() {
		String sql = "select UserName,UserId from user order by user.UserId desc limit 1";
		String obj = (String)Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				String membername=null;
				while(rs.next()) {
					membername=rs.getString("UserName");
				}
				return membername;
			}
		});
		return obj;	
	}
	
	public int selectuserid(String username) {
		String sql = "select UserId from user where UserName=?";
		int obj = (int)Jdbc.executeQuery(sql, new ResultSetHandler() {
			public Object handle(ResultSet rs) throws SQLException {
				int UserId = 0;
				while(rs.next()) {
					UserId=rs.getInt("UserId");
				}
				return UserId;
			}
		},username);
		return obj;		
	} 
	
	public void update(String[] user){
		String sql ="update user set password=? where username=?";
		Jdbc.executeUpdate(sql, user);
	}
	public void insert(Object user,String table){
		if(table.equals("user")){
			User usertemp = (User)user;
			String username = usertemp.getUsername();
			String password = usertemp.getPassword();
			String[] userArray = {username,password};
			String sql ="insert into user values(NULL,?,?)";
			Jdbc.executeUpdate(sql, userArray);
		}
	}
	public void delete(String id){
		String sql ="delete from user where username=?";
		Jdbc.executeUpdate(sql, id);
	}
}
