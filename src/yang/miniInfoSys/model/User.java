package yang.miniInfoSys.model;

public class User {
	/**
	 * 本类是User类，包含登陆本系统的用户的一些信息
	 */
	private String username;
	private String passwd;
	private String sex;
	private String tell;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String passwd, String sex, String tell) {
		super();
		this.username = username;
		this.passwd = passwd;
		this.sex = sex;
		this.tell = tell;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", passwd=" + passwd + ", sex=" + sex + ", tell=" + tell + "]";
	}
	
}
