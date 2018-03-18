package yang.miniInfoSys.view;

import java.util.Scanner;

import yang.miniInfoSys.controller.UserService;
import yang.miniInfoSys.model.User;

public class RegisterUser {
	
	/**
	 * 注册一个用户
	 * @throws Exception 
	 */
	public void saveUser() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您的用户名:");
		String username = sc.next();
		System.out.println("请输入您的密码:");
		String passwd = sc.next();
		System.out.println("请确认您的密码:");
		String passwd2 = sc.next();
		System.out.println("请输入您的性别:");
		String sex = sc.next();
		System.out.println("请输入您的电话:");
		String tell = sc.next();
		if(username.equals("") || passwd.equals("") ) {
			System.out.println("您的姓名或者密码为空，请重新注册！");
			new LoginView().init();
		}else if(!passwd2.equals(passwd)) {
			System.out.println("您两次密码输入不一致！请重新注册！");
			new LoginView().init();
		}else {
			User user = new User(username, passwd, sex, tell);
			UserService uService = new UserService();
			boolean flag = uService.saveUser(user);
			if(flag) {
				System.out.println("注册成功！");
				new LoginView().init();
			}else {
				System.out.println("注册失败！请重新注册！");
				new LoginView().init();
			}
		}
		
	}
}
