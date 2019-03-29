package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {}
	}
	
	static final String url = "jdbc:mysql://localhost:3306/shixundb";
	static final String user ="root";
	static final String password ="123";
	
	public static Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(url,user,password);	
		return conn;
	}
	
	public static void closeAll(ResultSet rs,Statement stmt,Connection coon){
		try{
			if(rs !=null){
				rs.close();
			}
		} catch(SQLException e){}
		try{
			if(stmt !=null){
				stmt.close();
			}
		} catch(SQLException e){}
		try{
			if(coon !=null){
				coon.close();
			}
		} catch(SQLException e){}
	}
	
	public static int executeUpdate(String sql, Object... parameters){
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			if(parameters != null && parameters.length > 0){
				for(int i=0;i<parameters.length;i++){
					stmt.setObject((i+1), parameters[i]);
				}
			}
			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally{
			closeAll(null,stmt,conn);
		}	
	}
	
	public static Object executeQuery(String sql,ResultSetHandler handler,Object... parameters){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			if (parameters != null && parameters.length > 0) {
				for (int i = 0; i < parameters.length; i++) {
					stmt.setObject((i + 1), parameters[i]);
				}
			}
			rs = stmt.executeQuery();
			// 读取结果集的过程不确定
			Object obj = handler.handle(rs); // obj 也许是个实体, 也许是个实体集合, 也许是个int, 也许是个 . . . 
			return obj;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeAll(rs, stmt, conn);
		}
		
	}
}
