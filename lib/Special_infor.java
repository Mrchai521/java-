package test;

/*
 * 专题信息的子窗口
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
	Container c = getContentPane();// 构造新容器
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	Font f = new Font("标题", Font.BOLD, 25);
	Font f2 = new Font("文本框", Font.BOLD, 20);
	JLabel Special = new JLabel("专题信息");
	JLabel S_number = new JLabel("专题编号");
	JTextField SNumber = new JTextField("A1");
	JLabel S_name = new JLabel("专题名称");
	JTextField SName = new JTextField();
	JButton add = new JButton("增加");
	JButton delete = new JButton("删除");
	JButton inqire = new JButton("查询");
	JLabel result = new JLabel("查询结果：");
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

		// 增加数据
		if (e.getSource() == add) {
			SpecialTable special = new SpecialTable(SNumber.getText(), SName.getText());
			ArrayList<String> strArray = new ArrayList<>();
			// strArray = op.addSpecial();
			int n = 0;
			int replicate = 0;
			if (replicate == 0) {
				op.saveSpecial(special);
				JOptionPane.showMessageDialog(null, "添加成功...", "操作成功", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "添加失败...", "操作失败", JOptionPane.ERROR_MESSAGE);
			}
		}
		// 删除信息
		if (e.getSource() == delete) {
			// 是否删除对话框
			Object[] options = { "OK", "CANCEL" };
			JOptionPane.showOptionDialog(null, "是否删除？", "Warning", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			// if(options.toString()=="OK") {
			SpecialTable special = new SpecialTable(SNumber.getText(), SName.getText());
			if (op.deleteSpecial(special) == 1) {
				JOptionPane.showMessageDialog(null, "删除成功...", "删除操作", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "输入错误，删除失败...", "删除操作", JOptionPane.ERROR_MESSAGE);

			}
		}
		if (e.getSource() == inqire) {
			SpecialTable special = new SpecialTable(SNumber.getText(),SName.getText());
			if ((SNumber.getText().equals(null))) {
				JOptionPane.showMessageDialog(null, "请输入专题号，或者名字", "查询操作", JOptionPane.INFORMATION_MESSAGE);
			} else {
				Object[][] ob = new Object[20][2];
				// 获取文本框的数据
				int n = 0;
				// 查询专题数据
				try {
					String sql = "SELECT * FROM subject WHERE sp_id=? OR sp_name=?";
					PreparedStatement ps = op.ct.prepareStatement(sql);
					// 从文本框获取输入的作者号
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
