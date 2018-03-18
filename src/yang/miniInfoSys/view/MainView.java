package yang.miniInfoSys.view;

import java.util.List;
import java.util.Scanner;

import yang.miniInfoSys.controller.UserService;
import yang.miniInfoSys.model.User;

public class MainView {
	
	/**
	 * ��ʾ������
	 * @throws Exception 
	 */
	public void viewThis(String username) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------------------------------------");
		System.out.println("-------------------------------------------");
		System.out.println("---------��ӭ"+username+"��¼XXX����ϵͳ---------");
		System.out.println("---------1.�������                               ---------");
		System.out.println("---------2.�鿴�����û�                        ---------");
		System.out.println("---------0.�˳�                                       ---------");
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
	 * ��½ϵͳ��DEMO
	 * @throws Exception 
	 */
	public void login() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("�����������û�����");
		String username = sc.next();
		System.out.println("�������������룺");
		String passwd = sc.next();
		UserService uService = new UserService();
		if(uService.login(username, passwd)) {
			System.out.println("��½�ɹ�!��ӭ"+username+"ʹ�ñ�ϵͳ");
			viewThis(username);
		}else {
			System.out.println("��½ʧ��");
			new LoginView().init();
		}
	}
	/**
	 * �����ۿ�
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
	 * ��ʾ�����û�
	 * @throws Exception
	 */
	public void showUser(String username) throws Exception {
		UserService uService = new UserService();
		List<User> uList = uService.showUser();
		System.out.println("------------------------------------");
		System.out.println("-----����                �Ա�              �绰            -------");
		for (int i = 0; i < uList.size(); i++) {
			User u = uList.get(i);
			System.out.println("-----"+u.getUsername()+"      "+u.getSex()+"       "+u.getTell()+"-------");
		}
		System.out.println("------------------------------------");
		viewThis(username);
	}
}
