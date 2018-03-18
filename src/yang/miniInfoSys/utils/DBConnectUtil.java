package yang.miniInfoSys.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectUtil {

	/**
	 * һ���������ӵĻ�����
	 */
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/miniinfosys?useSSL=false";
	private String username = "root";
	private String password = "123456";
	private Connection con;

	public DBConnectUtil() throws ClassNotFoundException, SQLException {
		
	}
	/**
	 * ����һ�����ݿ�����
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
	 * �ر����ݿ�����
	 * @throws SQLException
	 */
	public void closeCon() throws SQLException {
		con.close();
	}

}
