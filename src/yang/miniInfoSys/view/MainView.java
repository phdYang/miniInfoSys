package yang.miniInfoSys.view;

import java.util.List;
import java.util.Scanner;

import yang.miniInfoSys.controller.UserService;
import yang.miniInfoSys.model.User;

public class MainView {
	
	/**
	 * 显示本界面
	 * @throws Exception 
	 */
	public void viewThis(String username) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------------------------------------");
		System.out.println("-------------------------------------------");
		System.out.println("---------欢迎"+username+"登录XXX智障系统---------");
		System.out.println("---------1.继续浏览                               ---------");
		System.out.println("---------2.查看所有用户                        ---------");
		System.out.println("---------0.退出                                       ---------");
		System.out.println("-------------------------------------------");
		System.out.println("-------------------------------------------");
		int c = sc.nextInt();
		switch(c) {
		case 1:contiView(username);
			   break;
		case 2:showUser(username);
			   break;
		case 0:new LoginView().init();
			   break;
		}
	}
	/**
	 * 登陆系统的DEMO
	 * @throws Exception 
	 */
	public void login() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您的用户名：");
		String username = sc.next();
		System.out.println("请输入您的密码：");
		String passwd = sc.next();
		UserService uService = new UserService();
		if(uService.login(username, passwd)) {
			System.out.println("登陆成功!欢迎"+username+"使用本系统");
			viewThis(username);
		}else {
			System.out.println("登陆失败");
			new LoginView().init();
		}
	}
	/**
	 * 继续观看
	 */
	public void contiView(String username) {
		while(true) {
			try {
				viewThis(username);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 显示所有用户
	 * @throws Exception
	 */
	public void showUser(String username) throws Exception {
		UserService uService = new UserService();
		List<User> uList = uService.showUser();
		System.out.println("------------------------------------");
		System.out.println("-----姓名                性别              电话            -------");
		for (int i = 0; i < uList.size(); i++) {
			User u = uList.get(i);
			System.out.println("-----"+u.getUsername()+"      "+u.getSex()+"       "+u.getTell()+"-------");
		}
		System.out.println("------------------------------------");
		viewThis(username);
	}
}
