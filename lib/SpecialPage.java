package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javafx.scene.control.TableColumn;

/*
 * ר����Ϣ��������
 * */
public class SpecialPage {

}

class SpecialMain extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();// ����������
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JButton back = new JButton("�������˵�");
	JButton add = new JButton("���ݿⱸ��");
	JButton delete = new JButton("���ݿ�ָ�");
	JButton refresh = new JButton("ˢ��");
	JButton Statistics=new  JButton("ͳ��");
	Object[] s = { "sp_id", "sp_name" };
	Object[][] ob = new Object[20][2];
	JTable table = new JTable(ob, s);
	JScrollPane sroll = new JScrollPane(table);
	Font font1 = new Font("00", Font.BOLD, 10);

	public SpecialMain() {
		SpecialTable special = new SpecialTable();
		ob = op.allSpecial(special);
		for (int i = 0; i < 5; i++) {
			DefaultTableModel sp = new DefaultTableModel(ob, s);
			for (int n = 0; n < 20; n++) {
				for (int m = 0; m < 2; m++) {
					ob[n][m] = this.ob[n][m];
				}
			}
			table.setModel(sp);
			table.invalidate();
		}

		c.add(p1, BorderLayout.CENTER);
		c.add(p2, BorderLayout.SOUTH);
		c.add(p3, BorderLayout.NORTH);
		p3.setLayout(new GridLayout(1, 4, 10, 10));
		p3.add(back);
		p3.add(add);
		p3.add(delete);
		p3.add(refresh);
		p1.add(sroll);
		p2.add(Statistics);
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
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("���������ϵͳ");
			f.setLocation(300, 200);
			f.setSize(780, 500);
			f.setVisible(true);

		}
		// ˢ��ҳ��
		if (e.getSource() == refresh) {
			this.dispose();
			SpecialMain f = new SpecialMain();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("��Ϣ����--��ר����Ϣ��");
			f.setSize(1024, 720);// ���ô���Ĵ�С
			f.setLocation(250, 80);// ���ô����λ��
			f.setVisible(true);
		}

	}
}
