package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Authors_info {

}

class author extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();// ����������
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	Font f = new Font("����", Font.BOLD, 25);
	Font f2 = new Font("�ı���", Font.BOLD, 20);
	JLabel author = new JLabel("������Ϣ");
	JLabel au_id = new JLabel("���߱��");
	JTextField Au_id = new JTextField();
	JLabel au_name = new JLabel("��������");
	JTextField Au_name = new JTextField();
	JLabel phone = new JLabel("��ϵ�绰");
	JTextField Aphone = new JTextField();
	JLabel adress = new JLabel("��ַ");
	JTextField Au_adress = new JTextField();
	JLabel b = new JLabel("�Ƿ�ǩԼ��ͬ");
	JTextField au_b = new JTextField();
	JButton add = new JButton("����");
	JButton delete = new JButton("ɾ��");
	JButton inqire = new JButton("��ѯ");
	JLabel result = new JLabel("��ѯ�����");
	TextArea result1 = new TextArea(10, 5);
	JScrollPane jscrollPane = new JScrollPane(result1);

	public author() {
		c.add(p1, BorderLayout.CENTER);
		c.add(p2, BorderLayout.NORTH);
		c.add(p3, BorderLayout.SOUTH);
		p2.setBackground(new Color(100, 255, 255));
		p1.setBackground(new Color(240, 255, 255));
		p1.setLayout(new GridLayout(7, 4, 5, 5));
		p2.add(author);
		author.setFont(f);
		p1.add(au_id);
		p1.add(Au_id);
		p1.add(au_name);
		p1.add(Au_name);
		p1.add(phone);
		p1.add(Aphone);
		p1.add(adress);
		p1.add(Au_adress);
		p1.add(b);
		p1.add(au_b);
		p1.add(result);
		p1.add(jscrollPane);
		p3.add(add);
		p3.add(delete);
		p3.add(inqire);
		add.addActionListener(this);
		delete.addActionListener(this);
		inqire.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == add) {
			authorsTable author = new authorsTable(Au_id.getText(), Au_name.getText(), Aphone.getText(),
					Au_adress.getText(), au_b.getText());
			ArrayList<String> strArray = new ArrayList<>();
			strArray = op.addAuthors();
			int n = 0;
			int replicate = 0;
			if (replicate == 0) {
				op.saveAuthors(author);
				JOptionPane.showMessageDialog(null, "��ӳɹ�...", "�����ɹ�", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "���ʧ��...", "����ʧ��", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if (e.getSource() == delete) {
			Object[] options = { "OK", "CANCEL" };
			JOptionPane.showOptionDialog(null, "�Ƿ�ɾ����", "Warning", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			// if(options.toString()=="OK") {
			authorsTable author = new authorsTable(Au_id.getText(), Au_name.getText(), Aphone.getText(),
					Au_adress.getText(), au_b.getText());
			if (op.deleteAuthors(author) == 1) {
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�...", "ɾ������", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "�������ɾ��ʧ��...", "ɾ������", JOptionPane.ERROR_MESSAGE);

			}

		}
		if (e.getSource() == inqire) {
			Object[][] ob = new Object[20][5];
			authorsTable author = new authorsTable(Au_id.getText(), Au_name.getText());
			// ִ�в�ѯ������Ϣ��1�����ı����ȡ�������Ϣ 2�������Ϣ ��
			int n = 0;
			try {
				String sql = "SELECT * FROM authors WHERE au_id=? OR au_name=?";
				PreparedStatement ps = op.ct.prepareStatement(sql);
				// ���ı����ȡ��������ߺ�
				ps.setString(1, Au_id.getText());
				ps.setString(2, Au_name.getText());
				op.rs = ps.executeQuery();
				while (op.rs.next()) {
					ob[n][0] = op.rs.getString("au_id");
					ob[n][1] = op.rs.getString("au_name");
					ob[n][2] = op.rs.getString("phone");
					ob[n][3] = op.rs.getString("address");
					ob[n][4] = op.rs.getString("contact");
					n++;
					result1.append(op.rs.getString("au_id"));
					result1.append(op.rs.getString("au_name"));
					result1.append(op.rs.getString("phone"));
					result1.append(op.rs.getString("address"));
					result1.append(op.rs.getString("contact"));
				}
			} catch (SQLException ee) {
				// e.getMessage();
				System.out.println(ee);
			}
			// ArrayList<String> strArray = new ArrayList<>();
			// strArray = op.addAuthors();
			// String s1 = Au_id.getText();
			// String s2 = Au_name.getText();
			// String s3 = Aphone.getText();
			// String s4 = Au_adress.getText();
			// String s5 = au_b.getText();
			// int n = 0, replicate = 0;
			// while (n < Integer.parseInt(strArray.get(0))) {
			// n++;
			// if (s1.equals(strArray.get(n))) {
			// replicate++;
			// }
			// }
			// ArrayList<String> strArray1 = new ArrayList<>();
			// strArray1 = op.addAuthors();
			// int n1 = 0, replicate1 = 0;
			// while (n1 < Integer.parseInt(strArray.get(0))) {
			// n1++;
			// if (s2.equals(strArray.get(n1))) {
			// replicate1++;
			// }
			// }
			
			// if (replicate == 0 && replicate1 == 0) {
			// // ��ȡ�ı��������
			// authorsTable author = new authorsTable(Au_id.getText());
			// // ִ�в�ѯ
			// op.searchAuthors(author);
			//
			// } else if (replicate != 0 || replicate1 != 0) {
			// if (replicate == 0 && replicate1 == 0) {
			// JOptionPane.showMessageDialog(null, "������ר��ţ���������", "��ѯ����",
			// JOptionPane.INFORMATION_MESSAGE);
			//
			// }
			// }

		}
	}
}
