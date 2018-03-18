package yang.miniInfoSys.controller;

import java.util.List;

import yang.miniInfoSys.DAO.UserDAO;
import yang.miniInfoSys.model.User;

public class UserService {
	
	/**
	 * ��½ϵͳ
	 * @param username �û���
	 * @param passwd ����
	 * @return �ɹ� true ʧ�� false
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
	 * ����һ���û�
	 * @param user ע�����Ϣ
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
	 * ��ʾ�����û�
	 * @return
	 * @throws Exception 
	 */
	public List<User> showUser() throws Exception{
		UserDAO uDAO = new UserDAO();
		List<User> uList = uDAO.findAllUser();
		return uList;
	}
}
