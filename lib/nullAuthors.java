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
	//Choice ch = new Choice();//�����б�
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JButton back = new JButton("�������˵�");
	JButton refresh = new JButton("ˢ��");
	Object[] s = { "au_id","au_name", "phone", "address","contact"};
	Object[][] ob = new Object[20][5];
	JTable table = new JTable(ob, s);
	JScrollPane sroll = new JScrollPane(table);
	public AuthorsPrint() {
		//��ʾ�������
//		authorsTable author = new authorsTable();
//		ob = op.searchAuthors(author);
		for (int i = 0; i < 5; i++) {
			DefaultTableModel sp = new DefaultTableModel(ob, s);
			for (int n = 0; n < 10; n++) {//������
				for (int m = 0; m < 5; m++) {//������
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
			f.setTitle("���������ϵͳ");
			f.setLocation(300, 200);
			f.setSize(780, 500);
			f.setVisible(true);

		}
		if (e.getSource() == refresh) {
			this.dispose();
			AuthorsPrint f = new AuthorsPrint();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("��Ϣ����--��������Ϣ��");
			f.setSize(1024, 720);// ���ô���Ĵ�С
			f.setLocation(250, 80);// ���ô����λ��
			f.setVisible(true);
			
		}
	}
	
}
