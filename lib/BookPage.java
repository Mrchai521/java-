package test;

/*
 * 书籍信息的主窗口
 * 
 * */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class BookPage {

}

class BookRetrieval extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	// JFrame j=new JFrame();
	Container c = getContentPane();// 构造新容器
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JButton back = new JButton("返回主菜单");
	JButton add = new JButton("数据库备份");
	JButton delete = new JButton("数据库恢复");
	JButton refresh = new JButton("刷新");
	Object[] s = { "bo_id", "sp_id", "em_id", "bo_name", "price", "store", "date", "rollalty", "remarks" };
	Object[][] ob = new Object[20][9];
	JTable table = new JTable(ob, s);
	JScrollPane sroll = new JScrollPane(table);
	Font font1 = new Font("00", Font.BOLD, 10);

	public void initTable() {
	}

	public BookRetrieval() {
		// 通过返回值获取书籍数据
		BookInfo book = new BookInfo();
		ob = op.allBook(book);
		for (int i = 0; i < 5; i++) {
			DefaultTableModel books = new DefaultTableModel(ob, s);
			for (int n = 0; n < 20; n++) {
				for (int m = 0; m < 9; m++) {
					ob[n][m] = this.ob[n][m];
				}
				table.setModel(books);
				table.invalidate();
				
			}
		}
		c.add(p1, BorderLayout.CENTER);
		c.add(p2, BorderLayout.EAST);
		c.add(p3, BorderLayout.NORTH);
		p3.setLayout(new GridLayout(1, 3, 10, 10));
		p3.add(back);
		p3.add(add);
		p3.add(delete);
		p3.add(refresh);
		p1.add(sroll);
		c.setBackground(new Color(200, 255, 255));
		refresh.addActionListener(this);
		back.addActionListener(this);
		add.addActionListener(this);
		delete.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == back) {
			this.dispose();
			MyFrame f = new MyFrame();
			f.setTitle("出版社管理系统");
			f.setLocation(300, 200);
			f.setSize(780, 500);
			f.setVisible(true);

		}
		if (e.getSource() == refresh) {
			this.dispose();
			BookRetrieval f = new BookRetrieval();
			f.setTitle("信息操作--【书籍信息】");
			f.setSize(1024, 720);// 设置窗体的大小
			f.setLocation(250, 80);// 设置窗体的位置
			f.setVisible(true);
		}

	}
}