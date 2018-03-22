package yang.miniInfoSys.viewV1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import yang.miniInfoSys.controller.UserService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginViewV1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 * Meantime,是本程序所有窗口的唯一入口
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginViewV1 frame = new LoginViewV1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public LoginViewV1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblXx = new JLabel("XX\u667A\u969C\u7BA1\u7406\u7CFB\u7EDFV1.0");
		lblXx.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblXx.setBounds(60, 20, 154, 38);
		contentPane.add(lblXx);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("幼圆", Font.BOLD, 15));
		label.setBounds(70, 102, 85, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("幼圆", Font.BOLD, 15));
		label_1.setBounds(67, 162, 65, 24);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(156, 101, 166, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(156, 163, 166, 21);
		contentPane.add(passwordField);
		
		JButton button = new JButton("\u767B\u9646");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(64, 242, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u6CE8\u518C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		button_1.setBounds(247, 243, 93, 23);
		contentPane.add(button_1);
		
		JLabel lblCopy = new JLabel("CopyRight\u00A9Yang  2018");
		lblCopy.setFont(new Font("宋体", Font.PLAIN, 12));
		lblCopy.setBounds(339, 298, 129, 15);
		contentPane.add(lblCopy);
	}
	
	/**
	 * 实现登陆按钮功能
	 * @throws Exception 
	 */
	public void login() throws Exception {
		String username = textField.getText();
		String passwd = passwordField.getText();
		UserService uService = new UserService();
		if(uService.login(username, passwd)) {
			MainViewV1.username = username;
			MainViewV1 frame = new MainViewV1();
			frame.setVisible(true);
			this.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(this, "用户名或密码错误");
		}
	}
	/**
	 * 实现注册按钮功能
	 */
	public void register() {
		RegisterUserViewV1 frame = new RegisterUserViewV1();
		frame.setVisible(true);
		this.setVisible(false);
	}
}
