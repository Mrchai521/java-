package test;

/*
 *登录窗口 
 * 
 * */
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn { // 登录界面
	public static void main(String[] args) {
		windows w = new windows();
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setTitle("出版社管理系统");
		w.setLocation(300, 200);

		w.setSize(300, 150);
		w.setVisible(true);
	}
}

class windows extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();// 内容面板
	JPanel p2 = new JPanel();
	// JPanel p3 = new JPanel();
	JLabel username = new JLabel("用户名：");
	JLabel password = new JLabel("密码：");
	// JLabel image=new JLabel();
	ImageIcon b = new ImageIcon("./src/image/1.png");
	JTextField nameField = new JTextField(20);// 设置文本框的内容大小
	JPasswordField passField = new JPasswordField(20);
	JButton confirm = new JButton(new ImageIcon("./src/image/loginButton.jpg"));
	JButton exit = new JButton(new ImageIcon("./src/image/exitButton.jpg"));

	public windows() { // 成员方法
		// c.add(p3,BorderLayout.NORTH);
		c.add(p1, BorderLayout.CENTER);
		c.add(p2, BorderLayout.SOUTH);
		p1.setLayout(new GridLayout(2, 2, 10, 10));
		// p3.add(image);

		p1.add(username);
		p1.add(nameField);
		p1.add(password);
		p1.add(passField);
		p2.add(confirm);
		p2.add(exit);
		p1.setBackground(new Color(0xD8DDC7));
		p2.setBackground(new Color(0xD8DDC7));
		confirm.addActionListener(this);
		// 键盘监听
		confirm.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (e.getSource() == confirm) {
						String name = nameField.getText();
						String pass = passField.getText();
						int i = op.logCheck(name, pass);
						if (i == 1) {
							JOptionPane.showMessageDialog(null, "登录成功!", "Success...", JOptionPane.INFORMATION_MESSAGE);
							// this.dispose();
							MyFrame f = new MyFrame();
							f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							f.setTitle("出版社管理系统");
							f.setLocation(300, 200);
							f.setSize(780, 500);
							f.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "用户名和密码无法登录，请重新输入...", "登录失败",
									JOptionPane.ERROR_MESSAGE);
						}

					}
				}
			}

		});
		exit.addMouseListener(new MouseAdapter() { // 鼠标监听器
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == confirm) {
			String name = nameField.getText();
			String pass = passField.getText();
			int i = op.logCheck(name, pass);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "登录成功!", "Success...", JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
				MyFrame f = new MyFrame();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setTitle("出版社管理系统");
				f.setLocation(300, 200);
				f.setSize(780, 500);
				f.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "用户名和密码无法登录，请重新输入...", "登录失败", JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}
}

// f.setIconImage(Toolkit.getDefaultToolkit().createImage("a.jpg"));
// b1.setIcon(new ImageIcon(test.class.getResource("a.jpg")));
// b1.addMouseListener(new MouseAdapter() { //鼠标监听器
// public void mouseClicked(MouseEvent e) {
// System.exit(0);
// }
// });
// f.addWindowListener(new WindowAdapter() { // 关闭窗口的匿名内部类
// public void windowClosing(WindowEvent e) {
// System.exit(0);
// }
// });
