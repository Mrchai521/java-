package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class nullAuthors {

}
class AuthorsPrint extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	//Choice ch = new Choice();//下拉列表
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JButton back = new JButton("返回主菜单");
	JButton refresh = new JButton("刷新");
	Object[] s = { "au_id","au_name", "phone", "address","contact"};
	Object[][] ob = new Object[20][5];
	JTable table = new JTable(ob, s);
	JScrollPane sroll = new JScrollPane(table);
	public AuthorsPrint() {
		//显示到表格上
//		authorsTable author = new authorsTable();
//		ob = op.searchAuthors(author);
		for (int i = 0; i < 5; i++) {
			DefaultTableModel sp = new DefaultTableModel(ob, s);
			for (int n = 0; n < 10; n++) {//控制行
				for (int m = 0; m < 5; m++) {//控制列
					 ob[n][m]=this.ob[n][m] ;
				}
			}
			table.repaint();
			table.setModel(sp);
			table.invalidate();
	//	}
		c.add(p, new BorderLayout(5, 5).CENTER);
		c.add(p1, BorderLayout.NORTH);
		p.add(sroll);
		p1.add(back);
		p1.add(refresh);
		back.addActionListener(this);
		refresh.addActionListener(this);
	}
		
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
			AuthorsPrint f = new AuthorsPrint();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("信息操作--【作者信息】");
			f.setSize(1024, 720);// 设置窗体的大小
			f.setLocation(250, 80);// 设置窗体的位置
			f.setVisible(true);
			
		}
	}
	
}
