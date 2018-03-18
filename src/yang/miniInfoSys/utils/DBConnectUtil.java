package yang.miniInfoSys.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectUtil {

	/**
	 * 一个数据连接的基本类
	 */
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/miniinfosys?useSSL=false";
	private String username = "root";
	private String password = "123456";
	private Connection con;

	public DBConnectUtil() throws ClassNotFoundException, SQLException {
		
	}
	/**
	 * 返回一个数据库连接
	 * @return
	 */
	public Connection getCon(){
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * 关闭数据库连接
	 * @throws SQLException
	 */
	public void closeCon() throws SQLException {
		con.close();
	}

}
