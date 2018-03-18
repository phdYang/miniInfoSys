package yang.miniInfoSys.view;

import java.util.Scanner;

import yang.miniInfoSys.controller.UserService;
import yang.miniInfoSys.model.User;

public class RegisterUser {
	
	/**
	 * ע��һ���û�
	 * @throws Exception 
	 */
	public void saveUser() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("�����������û���:");
		String username = sc.next();
		System.out.println("��������������:");
		String passwd = sc.next();
		System.out.println("��ȷ����������:");
		String passwd2 = sc.next();
		System.out.println("�����������Ա�:");
		String sex = sc.next();
		System.out.println("���������ĵ绰:");
		String tell = sc.next();
		if(username.equals("") || passwd.equals("") ) {
			System.out.println("����������������Ϊ�գ�������ע�ᣡ");
			new LoginView().init();
		}else if(!passwd2.equals(passwd)) {
			System.out.println("�������������벻һ�£�������ע�ᣡ");
			new LoginView().init();
		}else {
			User user = new User(username, passwd, sex, tell);
			UserService uService = new UserService();
			boolean flag = uService.saveUser(user);
			if(flag) {
				System.out.println("ע��ɹ���");
				new LoginView().init();
			}else {
				System.out.println("ע��ʧ�ܣ�������ע�ᣡ");
				new LoginView().init();
			}
		}
		
	}
}
