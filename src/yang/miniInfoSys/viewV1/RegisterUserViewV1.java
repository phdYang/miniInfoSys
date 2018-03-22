package yang.miniInfoSys.viewV1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import yang.miniInfoSys.controller.UserService;
import yang.miniInfoSys.model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;

public class RegisterUserViewV1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JLabel label_4;
	private JLabel lblNewLabel_1;
	private JLabel label_5;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel label_6;
	private JButton btnB;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegisterUserViewV1 frame = new RegisterUserViewV1();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public RegisterUserViewV1() {
		setTitle("\u7528\u6237\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblxx = new JLabel("\u6B22\u8FCE\u60A8\u6CE8\u518CXX\u667A\u969C\u7CFB\u7EDF");
		lblxx.setFont(new Font("宋体", Font.BOLD, 14));
		lblxx.setBounds(21, 10, 192, 15);
		contentPane.add(lblxx);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u7528\u6237\u540D\uFF1A");
		label.setBounds(41, 53, 125, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				label_4.setText("");
			}
		});
		textField.setBounds(164, 50, 137, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u5BC6\u7801\uFF1A");
		label_1.setBounds(41, 97, 104, 15);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				label_6.setText("");
			}
		});
		passwordField.setBounds(164, 94, 137, 21);
		contentPane.add(passwordField);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u60A8\u7684\u5BC6\u7801\uFF1A");
		label_2.setBounds(42, 135, 100, 15);
		contentPane.add(label_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_1.setText("");
			}
		});
		passwordField_1.setBounds(164, 131, 137, 21);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u60A8\u7684\u6027\u522B\uFF1A");
		lblNewLabel.setBounds(43, 177, 115, 15);
		contentPane.add(lblNewLabel);
		
		radioButton = new JRadioButton("\u7537");
		radioButton.setSelected(true);
		buttonGroup.add(radioButton);
		radioButton.setBounds(164, 173, 42, 23);
		contentPane.add(radioButton);
		
		radioButton_1 = new JRadioButton("\u5973");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(232, 173, 42, 23);
		contentPane.add(radioButton_1);
		
		JLabel label_3 = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u7535\u8BDD\uFF1A");
		label_3.setBounds(42, 216, 115, 15);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				label_5.setText("");
			}
		});
		textField_1.setBounds(164, 217, 133, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					registerUser();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(44, 286, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAll();
			}
		});
		button_1.setBounds(219, 286, 93, 23);
		contentPane.add(button_1);
		
		label_4 = new JLabel("");
		label_4.setBounds(320, 53, 126, 15);
		contentPane.add(label_4);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(321, 135, 125, 15);
		contentPane.add(lblNewLabel_1);
		
		label_5 = new JLabel("");
		label_5.setBounds(333, 216, 113, 22);
		contentPane.add(label_5);
		
		label_6 = new JLabel("");
		label_6.setBounds(333, 97, 113, 15);
		contentPane.add(label_6);
		
		btnB = new JButton();
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backtoLogin();
			}
		});
		btnB.setText("<---");
		btnB.setMaximumSize(new Dimension(256,256));
		btnB.setBounds(388, 10, 58, 23);
		contentPane.add(btnB);
	}
	
	/**
	 * 实现注册功能
	 * @throws Exception 
	 */
	public void registerUser() throws Exception {
		UserService uService = new UserService();
		String username = textField.getText();
		String passwd = passwordField.getText();
		String passwd1 = passwordField_1.getText();
		String sex = "";
		if(radioButton.isSelected()) {
			sex = "男";
		}else if(radioButton_1.isSelected()) {
			sex = "女";
		}else {
			sex = "";
		}
		String tell = textField_1.getText();
		
		if("".equals(username)) {
			label_4.setText("用户名不能为空!!");
		}else if(uService.findTheUserName(username)) {
			label_4.setText("用户名已存在！！");
		}else if("".equals(passwd)) {
			label_6.setText("密码不能为空！");
		}else if(!passwd.equals(passwd1)) {
			lblNewLabel_1.setText("密码不一致！");
		}else if(!tell.matches("[0-9]*")) {
			label_5.setText("电话格式错误！");
		}else {
			User user = new User(username,passwd,sex,tell);
			if(uService.saveUser(user)) {
				JOptionPane.showMessageDialog(this, "注册成功!");
				LoginViewV1 frame = new LoginViewV1();
				frame.setVisible(true);
				this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(this, "注册失败请重新尝试");
				clearAll();
			}
		}

		
	}
	/**
	 * 实现重置功能
	 */
	public void clearAll() {
		textField.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
		textField_1.setText("");
		buttonGroup.clearSelection();
		radioButton.setSelected(true);
	}
	
	/**
	 * 返回上一页
	 */
	public void backtoLogin() {
		LoginViewV1 frame = new LoginViewV1();
		frame.setVisible(true);
		this.setVisible(false);
	}
	
}
