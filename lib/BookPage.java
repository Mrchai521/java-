package test;

/*
 * �鼮��Ϣ��������
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
	Container c = getContentPane();// ����������
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JButton back = new JButton("�������˵�");
	JButton add = new JButton("���ݿⱸ��");
	JButton delete = new JButton("���ݿ�ָ�");
	JButton refresh = new JButton("ˢ��");
	Object[] s = { "bo_id", "sp_id", "em_id", "bo_name", "price", "store", "date", "rollalty", "remarks" };
	Object[][] ob = new Object[20][9];
	JTable table = new JTable(ob, s);
	JScrollPane sroll = new JScrollPane(table);
	Font font1 = new Font("00", Font.BOLD, 10);

	public void initTable() {
	}

	public BookRetrieval() {
		// ͨ������ֵ��ȡ�鼮����
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
			f.setTitle("���������ϵͳ");
			f.setLocation(300, 200);
			f.setSize(780, 500);
			f.setVisible(true);

		}
		if (e.getSource() == refresh) {
			this.dispose();
			BookRetrieval f = new BookRetrieval();
			f.setTitle("��Ϣ����--���鼮��Ϣ��");
			f.setSize(1024, 720);// ���ô���Ĵ�С
			f.setLocation(250, 80);// ���ô����λ��
			f.setVisible(true);
		}

	}
}