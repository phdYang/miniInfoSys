package yang.miniInfoSys.controller;

import java.util.List;

import yang.miniInfoSys.DAO.UserDAO;
import yang.miniInfoSys.model.User;

public class UserService {
	
	/**
	 * 登陆系统
	 * @param username 用户名
	 * @param passwd 密码
	 * @return 成功 true 失败 false
	 * @throws Exception 
	 */
	public boolean login(String username,String passwd) throws Exception {
		UserDAO uDAO = new UserDAO();
		if(uDAO.login(username, passwd)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 保存一个用户
	 * @param user 注册的信息
	 * @return
	 * @throws Exception 
	 */
	public boolean saveUser(User user) throws Exception {
		UserDAO uDAO = new UserDAO();
		if(uDAO.saveUser(user)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 显示所有用户
	 * @return
	 * @throws Exception 
	 */
	public List<User> showUser() throws Exception{
		UserDAO uDAO = new UserDAO();
		List<User> uList = uDAO.findAllUser();
		return uList;
	}
}
