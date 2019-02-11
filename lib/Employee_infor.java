package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class Employee_infor {

}

class employee_info extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();// ����������
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	Font f = new Font("����", Font.BOLD, 25);
	Font f2 = new Font("�ı���", Font.BOLD, 20);
	JLabel employ = new JLabel("Ա����Ϣ");
	JLabel number = new JLabel("Ա������");
	JTextField PNumber = new JTextField();
	JLabel P_name = new JLabel("Ա������");
	JTextField PName = new JTextField();
	JLabel P_SEX = new JLabel("�Ա�");
	JTextField PSEX = new JTextField();
	JLabel Grade = new JLabel("ְλ����");
	JTextField PGrade = new JTextField();
	JLabel Pdate = new JLabel("��Ӷ����");
	JTextField PDATE = new JTextField();
	JLabel Wage = new JLabel("�¹���");
	JTextField PWage = new JTextField();
	JLabel TELL = new JLabel("��ϵ�绰");
	JTextField PTELL = new JTextField();
	JButton add = new JButton("����");
	JButton delete = new JButton("ɾ��");
	JButton inqire = new JButton("��ѯ");
	JLabel result = new JLabel("��ѯ���(�����Ż�������)��");
	TextArea result1 = new TextArea(10, 7);
	JScrollPane jscrollPane = new JScrollPane(result1);

	public employee_info() {
		c.add(p1, BorderLayout.CENTER);
		c.add(p2, BorderLayout.NORTH);
		c.add(p3, BorderLayout.SOUTH);
		p2.setBackground(new Color(100, 255, 255));
		p1.setBackground(new Color(240, 255, 255));
		p1.setLayout(new GridLayout(8, 4, 5, 5));
		p2.add(employ);
		employ.setFont(f);
		p1.add(number);
		p1.add(PNumber);
		p1.add(P_name);
		p1.add(PName);
		p1.add(P_SEX);
		p1.add(PSEX);
		p1.add(Grade);
		p1.add(PGrade);
		p1.add(Pdate);
		p1.add(PDATE);
		p1.add(Wage);
		p1.add(PWage);
		p1.add(TELL);
		p1.add(PTELL);
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
			EmployeeTable employee = new EmployeeTable(PNumber.getText(), PName.getText(), PSEX.getText(),
					Integer.parseInt(PGrade.getText()), PDATE.getText(), PWage.getText(), PTELL.getText());
			ArrayList<String> strArray = new ArrayList<>();
			strArray = op.addEmployee();
			int n = 0;
			int replicate = 0;
			if (replicate == 0) {
				op.saveEmployee(employee);
				JOptionPane.showMessageDialog(null, "��ӳɹ�...", "�����ɹ�", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "���ʧ��...", "����ʧ��", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if (e.getSource() == delete) {
			Object[] options = { "OK", "CANCEL" };
			JOptionPane.showOptionDialog(null, "�Ƿ�ɾ����", "Warning", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			EmployeeTable employ = new EmployeeTable(PNumber.getText(), PName.getText());
			if (op.DeleteEmployee(employ) == 1) {
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�...", "ɾ������", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "�������ɾ��ʧ��...", "ɾ������", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource()==inqire) {
			// Ա����Ϣ��ѯ
			Object[][] ob = new Object[20][7];
			EmployeeTable employee = new EmployeeTable(PNumber.getText(), PName.getText());
			int n = 0;
			try {
				String sql = "SELECT * FROM employee WHERE em_id=? OR em_name=?";
				PreparedStatement ps = op.ct.prepareStatement(sql);
				// ���ı����ȡ��������ߺ�
				ps.setString(1, PNumber.getText());
				ps.setString(2, PName.getText());
				op.rs = ps.executeQuery();// ���ִ��
				while (op.rs.next()) {
					ob[n][0] = op.rs.getString("em_id");
					ob[n][1] = op.rs.getString("em_name");
					ob[n][2] = op.rs.getString("sex");
					ob[n][3] = op.rs.getInt("job");
					ob[n][4] = op.rs.getString("hire_date");
					ob[n][5] = op.rs.getString("month_pay");
					ob[n][6] = op.rs.getString("phone");
					n++;
					System.out.println(op.rs.getString("em_id") + op.rs.getString("em_name"));
					result1.append(op.rs.getString("em_id"));
					result1.append(op.rs.getString("em_name"));
					result1.append(op.rs.getString("sex"));
					result1.append(op.rs.getString("job"));
					result1.append(op.rs.getString("hire_date"));
					result1.append(op.rs.getString("month_pay"));
					result1.append(op.rs.getString("phone"));
				}
			} catch (SQLException ee) {
				System.out.println(ee);
				System.out.println("û�ɹ���");
			}

		}
	}

}
