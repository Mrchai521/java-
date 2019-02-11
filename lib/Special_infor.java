package test;

/*
 * ר����Ϣ���Ӵ���
 * */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Special_infor {

}

class S_Information extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();// ����������
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	Font f = new Font("����", Font.BOLD, 25);
	Font f2 = new Font("�ı���", Font.BOLD, 20);
	JLabel Special = new JLabel("ר����Ϣ");
	JLabel S_number = new JLabel("ר����");
	JTextField SNumber = new JTextField("A1");
	JLabel S_name = new JLabel("ר������");
	JTextField SName = new JTextField();
	JButton add = new JButton("����");
	JButton delete = new JButton("ɾ��");
	JButton inqire = new JButton("��ѯ");
	JLabel result = new JLabel("��ѯ�����");
	TextArea result1 = new TextArea(5, 2);
	JScrollPane jscrollPane = new JScrollPane(result1);

	public S_Information() {

		c.add(p1, BorderLayout.CENTER);
		c.add(p2, BorderLayout.NORTH);
		c.add(p3, BorderLayout.SOUTH);
		p2.setBackground(new Color(100, 255, 255));
		p2.add(Special);
		Special.setFont(f);
		S_number.setFont(f2);
		S_name.setFont(f2);
		result.setFont(f2);
		p1.setLayout(new GridLayout(3, 2, 5, 5));
		p1.add(S_number);
		p1.add(SNumber);
		p1.add(S_name);
		p1.add(SName);
		p1.add(result);
		p1.add(jscrollPane);
		p3.add(add);
		p3.add(delete);
		p3.add(inqire);

		inqire.addActionListener(this);
		add.addActionListener(this);
		delete.addActionListener(this);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// ��������
		if (e.getSource() == add) {
			SpecialTable special = new SpecialTable(SNumber.getText(), SName.getText());
			ArrayList<String> strArray = new ArrayList<>();
			// strArray = op.addSpecial();
			int n = 0;
			int replicate = 0;
			if (replicate == 0) {
				op.saveSpecial(special);
				JOptionPane.showMessageDialog(null, "��ӳɹ�...", "�����ɹ�", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "���ʧ��...", "����ʧ��", JOptionPane.ERROR_MESSAGE);
			}
		}
		// ɾ����Ϣ
		if (e.getSource() == delete) {
			// �Ƿ�ɾ���Ի���
			Object[] options = { "OK", "CANCEL" };
			JOptionPane.showOptionDialog(null, "�Ƿ�ɾ����", "Warning", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			// if(options.toString()=="OK") {
			SpecialTable special = new SpecialTable(SNumber.getText(), SName.getText());
			if (op.deleteSpecial(special) == 1) {
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�...", "ɾ������", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "�������ɾ��ʧ��...", "ɾ������", JOptionPane.ERROR_MESSAGE);

			}
		}
		if (e.getSource() == inqire) {
			SpecialTable special = new SpecialTable(SNumber.getText(),SName.getText());
			if ((SNumber.getText().equals(null))) {
				JOptionPane.showMessageDialog(null, "������ר��ţ���������", "��ѯ����", JOptionPane.INFORMATION_MESSAGE);
			} else {
				Object[][] ob = new Object[20][2];
				// ��ȡ�ı��������
				int n = 0;
				// ��ѯר������
				try {
					String sql = "SELECT * FROM subject WHERE sp_id=? OR sp_name=?";
					PreparedStatement ps = op.ct.prepareStatement(sql);
					// ���ı����ȡ��������ߺ�
					ps.setString(1, SNumber.getText());
					ps.setString(2, SName.getText());
					op.rs = ps.executeQuery();
					while (op.rs.next()) {
						ob[n][0] = op.rs.getString("sp_id");
						ob[n][1] = op.rs.getString("sp_name");
						n++;
						result1.append(op.rs.getString("sp_id"));
						result1.append(op.rs.getString("sp_name"));
					}
				} catch (Exception ee) {
					System.out.println(e);
				}

			}

		}
	}

}
