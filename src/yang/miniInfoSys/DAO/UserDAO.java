package yang.miniInfoSys.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import yang.miniInfoSys.model.User;
import yang.miniInfoSys.utils.DBConnectUtil;

public class UserDAO {
	
	/**
	 * 查找数据所有数据
	 * @return
	 * @throws Exception
	 */
	public List<User> findAllUser() throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnectUtil dbc = new DBConnectUtil();
		con = dbc.getCon();
		String sql = "Select * from user";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<User> uList = new ArrayList<User>();
		while (rs.next()) {
			User u = new User();
			u.setUsername(rs.getString(2));
			u.setPasswd(rs.getString(3));
			u.setSex(rs.getString(4));
			u.setTell(rs.getString(5));
			uList.add(u);
		}
		con.close();
		return uList;
	}
	
	/**
	 * 登陆系统
	 * @param username
	 * @param passwd
	 * @return
	 * @throws Exception
	 */
	public boolean login(String username,String passwd) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnectUtil dbc = new DBConnectUtil();
		con = dbc.getCon();
		String sql = "select * from user where username = ? and passwd=? ";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, passwd);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 增加一个用户
	 * @param u
	 * @return
	 * @throws Exception
	 */
	public boolean saveUser(User u) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnectUtil dbc = new DBConnectUtil();
		con = dbc.getCon();
		String sql = "insert into user(username,passwd,sex,tell) values(?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, u.getUsername());
		pstmt.setString(2, u.getPasswd());
		pstmt.setString(3, u.getSex());
		pstmt.setString(4, u.getTell());
		int rowcount = pstmt.executeUpdate();
		if(rowcount>0){
			return true;
		}
		return false;
	}
	/**
	 * 查找一个用户名是否存在
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public boolean findTheUserName(String username) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnectUtil dbc = new DBConnectUtil();
		con = dbc.getCon();
		String sql = "select * from user where username = ? ";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, username);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			return true;
		}else {
			return false;
		}
	}
}
