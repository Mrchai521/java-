package test;

/*
 * 书籍信息的子窗口
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
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Book_course {

}

class Book extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();// 构造新容器
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JLabel book = new JLabel("书籍信息");
	JLabel number = new JLabel("书籍编号");
	JTextField BookNumber = new JTextField();
	JLabel S_number = new JLabel("专题编号");
	JTextField SNumber = new JTextField();
	JLabel E_number = new JLabel("员工编号");
	JTextField ENumber = new JTextField();
	JLabel name = new JLabel("书籍名称");
	JTextField BookName = new JTextField();
	JLabel price = new JLabel("定价");
	JTextField BookPrice = new JTextField();
	JLabel stock = new JLabel("库存量");
	JTextField BookStock = new JTextField();
	JLabel date = new JLabel("出版日期");
	JTextField BookDate = new JTextField();
	JLabel rollalty = new JLabel("出版税");
	JTextField BookRoll = new JTextField();
	JLabel remarks = new JLabel("备注");
	JTextField BookRemarks = new JTextField();
	Font f = new Font("标题", Font.BOLD, 25);
	JButton back = new JButton("返回主菜单");
	JButton add = new JButton("增加");
	JButton delete = new JButton("删除");
	JButton inqire = new JButton("查询");
	JLabel result = new JLabel("查询结果：");
	TextArea result1 = new TextArea(10, 9);
	JScrollPane jscrollPane = new JScrollPane(result1);

	public Book() {
		c.add(p1, BorderLayout.CENTER);
		c.add(p2, BorderLayout.NORTH);
		c.add(p3, BorderLayout.SOUTH);
		p2.setBackground(new Color(100, 255, 255));
		p1.setBackground(new Color(240, 255, 255));
		p1.setLayout(new GridLayout(10, 4, 5, 5));
		p2.add(book);
		book.setFont(f);
		p1.add(number);
		p1.add(BookNumber);
		p1.add(S_number);
		p1.add(SNumber);
		p1.add(E_number);
		p1.add(ENumber);
		p1.add(name);
		p1.add(BookName);
		p1.add(price);
		p1.add(BookPrice);
		p1.add(stock);
		p1.add(BookStock);
		p1.add(date);
		p1.add(BookDate);
		p1.add(rollalty);
		p1.add(BookRoll);
		p1.add(remarks);
		p1.add(BookRemarks);
		p1.add(result);
		p1.add(jscrollPane);
		p3.add(back);
		p3.add(add);
		p3.add(delete);
		p3.add(inqire);
		inqire.addActionListener(this);
		add.addActionListener(this);
		delete.addActionListener(this);
		back.addActionListener(this);
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
		// 添加书籍数据
		if (e.getSource() == add) {
			BookInfo book = new BookInfo(BookNumber.getText(), SNumber.getText(), ENumber.getText(), BookName.getText(),
					Integer.parseInt(BookPrice.getText()), Integer.parseInt(BookStock.getText()), BookDate.getText(),
					Integer.parseInt(BookRoll.getText()), BookRemarks.getText());
			ArrayList<String> strArray = new ArrayList<>();
			strArray = op.addBook();
			int n = 0;
			int replicate = 0;
			// while(n<Integer.parseInt(strArray.get(0))) {
			// n++;
			// if(number.getText().equals(strArray.get(n))) {
			// replicate++;
			// }
			// }
			if (replicate == 0) {
				op.saveBook(book);
				JOptionPane.showMessageDialog(null, "添加成功...", "操作成功", JOptionPane.INFORMATION_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null, "添加失败...", "操作失败", JOptionPane.INFORMATION_MESSAGE);
			}

		}
		if (e.getSource() == delete) {
			Object[] options = { "OK", "CANCEL" };
			JOptionPane.showOptionDialog(null, "是否删除？", "Warning", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			// if(options.toString()=="OK") {
			BookInfo book = new BookInfo(BookNumber.getText(), SNumber.getText());
			if (op.deleteBooks(book) == 1) {
				JOptionPane.showMessageDialog(null, "删除成功...", "删除操作", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "输入错误，删除失败...", "删除操作", JOptionPane.ERROR_MESSAGE);

			}

		}
		if (e.getSource() == inqire) {
			Object[][] ob = new Object[20][9];
			BookInfo book = new BookInfo(BookNumber.getText(),BookName.getText());
			// 执行查询作者信息（1、从文本框获取输入的信息 2、输出信息 ）
			int n = 0;
			try {
				String sql = "SELECT * FROM books WHERE bo_id=? OR bo_name=?";
				PreparedStatement ps = op.ct.prepareStatement(sql);
				// 从文本框获取输入的作者号
				ps.setString(1, BookNumber.getText());
				ps.setString(2, BookName.getText());
				op.rs = ps.executeQuery();
				while (op.rs.next()) {
					ob[n][0] = op.rs.getString("bo_id");
					ob[n][1] = op.rs.getString("sp_id");
					ob[n][2] = op.rs.getString("em_id");
					ob[n][3] = op.rs.getString("bo_name");
					ob[n][4] = op.rs.getString("price");
					ob[n][5] = op.rs.getString("store");
					ob[n][6] = op.rs.getString("date");
					ob[n][7] = op.rs.getString("rollalty");
					ob[n][8] = op.rs.getString("remarks");
					n++;
					result1.append(op.rs.getString("bo_id"));
					result1.append(op.rs.getString("sp_id"));
					result1.append(op.rs.getString("em_id"));
					result1.append(op.rs.getString("bo_name"));
					result1.append(op.rs.getString("price"));
					result1.append(op.rs.getString("store"));
					result1.append(op.rs.getString("date"));
					result1.append(op.rs.getString("rollalty"));
					result1.append(op.rs.getString("remarks"));

				}
			} catch (SQLException ee) {
				// e.getMessage();
				System.out.println(ee);
			}
		}
	}

}