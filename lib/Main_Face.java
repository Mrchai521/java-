package test;

/*
 * 主界面
 * 
 * */
import java.awt.*;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main_Face {

}

class MyFrame extends JFrame implements ActionListener {
	
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JLabel welcome = new JLabel("欢迎使用出版社管理系统  ^_^");
	JLabel Copyright = new JLabel("CHU BAN SHE XIN XI GUAN LI XI TONG");
	// 给按钮加图标
	JButton Special = new JButton("专题信息", new ImageIcon("./src/image/1.png"));
	JButton Employee = new JButton("员工信息", new ImageIcon("./src/image/2.png"));
	JButton Author = new JButton("作者信息", new ImageIcon("./src/image/3.png"));
	JButton Books = new JButton("书籍信息", new ImageIcon("./src/image/4.png"));
//	JButton month=new JButton("查询统计销售（按月份）");
//	JButton year=new JButton("查询统计销售（按年份）");
//	JButton month1=new JButton("按时间段查询客户购买记录");
//	JButton year1=new JButton("按时间段查询书籍销售记录");
	Font font1 = new Font("按钮字体", Font.BOLD, 20);
	Font font2 = new Font("欢迎字体", Font.BOLD, 30);
	Font font_Copyright = new Font("Copyright", Font.PLAIN, 20);

	public MyFrame() {
		
//		 JMenuBar menuBar = new JMenuBar();
//		 menuBar.setLayout(new FlowLayout(40, 4, 0));
//		 menuBar.add(Special);
//		 Special.setPreferredSize(new Dimension(20, 10));// 设置按钮大小
		c.add(p1, BorderLayout.CENTER); // 面板布局为边界布局
		c.add(p2, BorderLayout.SOUTH);
		c.add(p3, BorderLayout.WEST);
		c.add(p4, BorderLayout.NORTH);
	
		// 设置背景色
		p2.setBackground(new Color(0, 191, 255));
		p4.setBackground(new Color(0, 191, 255));
		p4.add(welcome);
		p2.add(Copyright);
		p1.setLayout(new GridLayout(1, 4, 20, 20));
		p1.add(Special);
		
		p3.setLayout(new GridLayout(2, 2));
//		p3.add(month);
//		p3.add(month1);
//		p3.add(year);
//		p3.add(year1);
		
		//Special.setBounds(255,255,30,30);
		// 将字放在图标下方
		Special.setContentAreaFilled(false);
		Special.setHorizontalTextPosition(SwingConstants.CENTER);
		Special.setVerticalTextPosition(SwingConstants.BOTTOM);
		Special.setBorderPainted(false);// 隐藏边框
		p1.add(Employee);
		Employee.setContentAreaFilled(false);//按钮隐藏边框
		Employee.setHorizontalTextPosition(SwingConstants.CENTER);
		Employee.setVerticalTextPosition(SwingConstants.BOTTOM);
		Employee.setBorderPainted(false);// 隐藏边框
		p1.add(Author);
		Author.setContentAreaFilled(false);//按钮隐藏边框
		Author.setHorizontalTextPosition(SwingConstants.CENTER);
		Author.setVerticalTextPosition(SwingConstants.BOTTOM);
		Author.setBorderPainted(false);// 隐藏边框
		p1.add(Books);
		Books.setContentAreaFilled(false);//按钮隐藏边框
		Books.setHorizontalTextPosition(SwingConstants.CENTER);
		Books.setVerticalTextPosition(SwingConstants.BOTTOM);
		Books.setBorderPainted(false);// 隐藏边框
		Copyright.setFont(font_Copyright);
		welcome.setFont(font2);
		Special.setFont(font1);
		Employee.setFont(font1);
		Author.setFont(font1);
		Books.setFont(font1);
		Special.addActionListener(this);
		Employee.addActionListener(this);
		Author.addActionListener(this);
		Books.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 书籍信息界面
		if (e.getSource() == Books) {
			this.dispose();
			BookRetrieval f = new BookRetrieval();
			f.setTitle("信息操作--【书籍信息】");
			f.setSize(1024, 720);// 设置窗体的大小
			f.setLocation(250, 80);// 设置窗体的位置
			f.setVisible(true);
			Book b = new Book();
			b.setTitle("书籍信息");
			b.setLocation(500, 350);
			b.setSize(600, 400);
			b.setVisible(true);

		}
		// 专题信息界面
		if (e.getSource() == Special) {
			this.dispose();
			SpecialMain f = new SpecialMain();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("信息操作--【专题信息】");
			f.setSize(1024, 720);// 设置窗体的大小
			f.setLocation(250, 80);// 设置窗体的位置
			f.setVisible(true);
			this.setEnabled(false);
			this.setModalExclusionType(ModalExclusionType.NO_EXCLUDE);
			S_Information b = new S_Information();
			b.setTitle("专题信息");
			b.setLocation(590, 500);
			b.setSize(350, 200);
			b.setVisible(true);

		}
		// 员工信息界面
		if (e.getSource() == Employee) {
			this.dispose();
			Employee em = new Employee();
			em.setTitle("信息操作--【员工信息】");
			em.setSize(1024, 720);// 设置窗体的大小
			em.setLocation(250, 80);// 设置窗体的位置
			em.setVisible(true);
			employee_info m = new employee_info();
			m.setTitle("员工信息");
			m.setLocation(500, 400);
			m.setSize(650, 400);
			m.setVisible(true);

		}
		// 作者信息界面
		if (e.getSource() == Author) {
			this.dispose();
			Authors f = new Authors();
			f.setTitle("信息操作--【作者信息】");
			f.setSize(1024, 720);// 设置窗体的大小
			f.setLocation(250, 80);// 设置窗体的位置
			f.setVisible(true);
			author A = new author();
			A.setTitle("作者信息");
			A.setLocation(500, 400);
			A.setSize(550, 300);
			A.setVisible(true);
		}

	}
}