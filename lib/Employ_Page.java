package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Employ_Page {

}

class Employee extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p=new JPanel();
	JPanel p1=new JPanel();
	JButton back = new JButton("�������˵�");
	JButton add = new JButton("���ݿⱸ��");
	JButton delete = new JButton("���ݿ�ָ�");
	JButton refresh = new JButton("ˢ��");
	Object[] s = { "em_id", "em_name", "sex", "job", "hire_date", "month_pay", "phone" };
	Object[][] ob = new Object[20][7];
	JTable table = new JTable(ob, s);
	JScrollPane sroll = new JScrollPane(table);
	Font font1 = new Font("Ա��", Font.BOLD, 10);
	public Employee() {
		//�����е�����Ϣ
		EmployeeTable employee=new EmployeeTable();
		ob = op.allEmployee(employee);
		for (int i = 0; i < 5; i++) {
			DefaultTableModel employees= new DefaultTableModel(ob, s);
			for (int n = 0; n < 20; n++) {
				for (int m = 0; m < 7; m++) {
					ob[n][m] = this.ob[n][m];
				}
				table.repaint();
				table.setModel(employees);
				table.invalidate();
				
			}
		}
		c.add(p,BorderLayout.CENTER);
		c.add(p1, BorderLayout.NORTH);
		p1.add(back);
		p1.add(add);
		p1.add(delete);
		p1.add(refresh);
		p.add(sroll);
		p1.setLayout(new GridLayout(1,4,10,10));
		back.addActionListener(this);
		add.addActionListener(this);
		delete.addActionListener(this);
		refresh.addActionListener(this);
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
			Employee em = new Employee();
			em.setTitle("��Ϣ����--��Ա����Ϣ��");
			em.setSize(1024, 720);// ���ô���Ĵ�С
			em.setLocation(250, 80);// ���ô����λ��
			em.setVisible(true);
		}
	}

}