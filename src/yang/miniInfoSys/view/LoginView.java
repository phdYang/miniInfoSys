package yang.miniInfoSys.view;

import java.util.Scanner;

public class LoginView {
	
	/**
	 * ��ʼ��ϵͳ����
	 * @throws Exception 
	 */
	public void init() throws Exception {
		System.out.println("-------------------------------");
		System.out.println("--- ��ӭʹ��XXX���Ϲ���ϵͳ-----");
		System.out.println("---                       -----");
		System.out.println("---1. ��½ϵͳ                         -----");
		System.out.println("---2. ע���û�                         -----");
		System.out.println("---3. �˳�ϵͳ                         -----");
		System.out.println("-------------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.println("���������Ĳ�����");
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
	 * ��ϵͳ�������
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
