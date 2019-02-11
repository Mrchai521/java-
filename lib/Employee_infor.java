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
	Container c = getContentPane();// 构造新容器
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	Font f = new Font("标题", Font.BOLD, 25);
	Font f2 = new Font("文本框", Font.BOLD, 20);
	JLabel employ = new JLabel("员工信息");
	JLabel number = new JLabel("员工工号");
	JTextField PNumber = new JTextField();
	JLabel P_name = new JLabel("员工姓名");
	JTextField PName = new JTextField();
	JLabel P_SEX = new JLabel("性别");
	JTextField PSEX = new JTextField();
	JLabel Grade = new JLabel("职位级别");
	JTextField PGrade = new JTextField();
	JLabel Pdate = new JLabel("雇佣日期");
	JTextField PDATE = new JTextField();
	JLabel Wage = new JLabel("月工资");
	JTextField PWage = new JTextField();
	JLabel TELL = new JLabel("联系电话");
	JTextField PTELL = new JTextField();
	JButton add = new JButton("增加");
	JButton delete = new JButton("删除");
	JButton inqire = new JButton("查询");
	JLabel result = new JLabel("查询结果(按工号或者姓名)：");
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
				JOptionPane.showMessageDialog(null, "添加成功...", "操作成功", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "添加失败...", "操作失败", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if (e.getSource() == delete) {
			Object[] options = { "OK", "CANCEL" };
			JOptionPane.showOptionDialog(null, "是否删除？", "Warning", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			EmployeeTable employ = new EmployeeTable(PNumber.getText(), PName.getText());
			if (op.DeleteEmployee(employ) == 1) {
				JOptionPane.showMessageDialog(null, "删除成功...", "删除操作", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "输入错误，删除失败...", "删除操作", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource()==inqire) {
			// 员工信息查询
			Object[][] ob = new Object[20][7];
			EmployeeTable employee = new EmployeeTable(PNumber.getText(), PName.getText());
			int n = 0;
			try {
				String sql = "SELECT * FROM employee WHERE em_id=? OR em_name=?";
				PreparedStatement ps = op.ct.prepareStatement(sql);
				// 从文本框获取输入的作者号
				ps.setString(1, PNumber.getText());
				ps.setString(2, PName.getText());
				op.rs = ps.executeQuery();// 语句执行
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
				System.out.println("没成功！");
			}

		}
	}

}
