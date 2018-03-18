package yang.miniInfoSys.view;

import java.util.Scanner;

public class LoginView {
	
	/**
	 * 初始化系统界面
	 * @throws Exception 
	 */
	public void init() throws Exception {
		System.out.println("-------------------------------");
		System.out.println("--- 欢迎使用XXX智障管理系统-----");
		System.out.println("---                       -----");
		System.out.println("---1. 登陆系统                         -----");
		System.out.println("---2. 注册用户                         -----");
		System.out.println("---3. 退出系统                         -----");
		System.out.println("-------------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您的操作：");
		int c = sc.nextInt();
		switch(c) {
			case 1: new MainView().login();
					break;
			case 2: new RegisterUser().saveUser();
					break; 
			case 3: new ExitSys().exitSys();
					break;
		}
	}
	
	/**
	 * 本系统的总入口
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new LoginView().init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
