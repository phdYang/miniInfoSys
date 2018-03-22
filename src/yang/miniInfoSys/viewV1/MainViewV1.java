package yang.miniInfoSys.viewV1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import yang.miniInfoSys.controller.UserService;
import yang.miniInfoSys.model.User;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainViewV1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel label_2;
	public static String username;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// MainViewV1 frame = new MainViewV1();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public MainViewV1() {
		setTitle("\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 34, 413, 261);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, },
				new String[] { "\u5E8F\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u7535\u8BDD" }));
		scrollPane.setViewportView(table);

		JTree tree = new JTree();
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				String tmp = node.toString();
				if ("查询用户".equals(tmp)) {
					try {
						queryUser();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if ("查询信息".equals(tmp)) {
					queryInfo();
				}
				if ("查询日志".equals(tmp)) {
					queryLogs();
				}
			}
		});
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("\u529F\u80FD\u6A21\u5757") {
			{
				DefaultMutableTreeNode node_1;
				node_1 = new DefaultMutableTreeNode("\u7528\u6237\u7BA1\u7406");
				node_1.add(new DefaultMutableTreeNode("\u67E5\u8BE2\u7528\u6237"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("\u4FE1\u606F\u7BA1\u7406");
				node_1.add(new DefaultMutableTreeNode("\u67E5\u8BE2\u4FE1\u606F"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("\u65E5\u5FD7\u7BA1\u7406");
				node_1.add(new DefaultMutableTreeNode("\u67E5\u8BE2\u65E5\u5FD7"));
				add(node_1);
			}
		}));
		tree.setBounds(10, 34, 109, 261);
		contentPane.add(tree);

		JButton button = new JButton("<--");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backtoForward();
			}
		});
		button.setBounds(482, 0, 51, 23);
		contentPane.add(button);

		JLabel label = new JLabel("");
		label.setText(this.username);
		label.setBounds(10, 4, 54, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\uFF0C\u6B22\u8FCE\u60A8\u4F7F\u7528\u672C\u7CFB\u7EDF");
		label_1.setBounds(84, 4, 122, 15);
		contentPane.add(label_1);

		label_2 = new JLabel("");
		label_2.setBounds(245, 4, 187, 15);
		contentPane.add(label_2);
		showTime();
	}

	/**
	 * 查询用户信息功能
	 * 
	 * @throws Exception
	 */
	public void queryUser() throws Exception {
		UserService uService = new UserService();
		List<User> uList = uService.showUser();
		Object[][] obj = new Object[uList.size()][4];
		for (int i = 0; i < uList.size(); i++) {
			obj[i][0] = i;
			obj[i][1] = uList.get(i).getUsername();
			obj[i][2] = uList.get(i).getSex();
			obj[i][3] = uList.get(i).getTell();
		}
		String[] title = { "\u5E8F\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u7535\u8BDD" };
		table.setModel(new DefaultTableModel(obj, title));
	}

	/**
	 * 查询信息功能
	 */
	public void queryInfo() {
		JOptionPane.showMessageDialog(this, "功能尚在测试中...");
	}

	/**
	 * 查询日志功能
	 */
	public void queryLogs() {
		JOptionPane.showMessageDialog(this, "功能尚在测试中...");
	}

	/**
	 * 返回上一页
	 */
	public void backtoForward() {
		LoginViewV1 frame = new LoginViewV1();
		frame.setVisible(true);
		this.setVisible(false);
	}

	/**
	 * 显示时间
	 */
	public void showTime() {
		Thread thread1=new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {
					SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					label_2.setText(dateFormatter.format(Calendar.getInstance().getTime()));
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						label_2.setText("Error!!!");
					}
				}
			}
		};
		thread1.start(); 
	}

}
