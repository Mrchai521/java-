package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class SQLOperation {
	static Connection ct = null;
	static ResultSet rs = null;

	public static void main(String[] args) {

	}

	public SQLOperation() {

		try {
			// 1.注册数据库驱动程序
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 2.打开数据库连接
			ct = DriverManager.getConnection(
					"jdbc:sqlserver://localhost\\SQLEXPRESS:1433;" + "DatabaseName=Course_Design", "user1", "123");
			// 连接数据库对象
			System.out.println("连接数据库成功");
			// 创建SQL命令对象
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("未找到驱动");
		}
		System.out.println("数据库驱动成功");
	}

	public int logCheck(String name, String password) {
		int i = 0;
		try {
			ArrayList<String> strArray = new ArrayList<String>();
			PreparedStatement ps = ct.prepareStatement("SELECT * FROM admin1");
			rs = ps.executeQuery();
			while (rs.next()) {
				String s = rs.getString("user_id");
				strArray.add(s);
				s = rs.getString("password_id");
				strArray.add(s);
			}
			if (strArray.get(0).equals(name) && strArray.get(1).equals(password)) {
				i = 1;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(i);
		return i;
	}

	// 1、查询全部的书籍信息 2、将书籍数据数据填入表格中 3、插入书籍信息
	public ArrayList addBook() {
		ArrayList<String> strArray = new ArrayList<>();
		ArrayList<String> strArray1 = new ArrayList<>();
		try {
			PreparedStatement ps = ct.prepareStatement("SELECT * FROM books ");
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				String s = rs.getString("bo_id");
				strArray.add(s);
				count++;
			}
			strArray.add(Integer.toString(count));
			for (; count >= 0; count--) {
				strArray1.add(strArray.get(count));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return strArray1;
	}

	public void saveBook(BookInfo book) {
		try {
			String sql = "INSERT INTO books VALUES(?,?,?,?,?,?,?,?,?);";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, book.getBo_id());
			ps.setString(2, book.getSp_id());
			ps.setString(3, book.getEm_id());
			ps.setString(4, book.getBo_name());
			ps.setInt(5, book.getPrice());
			ps.setInt(6, book.getStore());
			ps.setString(7, book.getDate());
			ps.setInt(8, book.getRollalty());
			ps.setString(9, book.getRemarks());
			ps.executeUpdate();// 更新列表
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Object[][] allBook(BookInfo book) {
		Object[][] ob = new Object[60][9];
		int n = 0;
		try {
			PreparedStatement ps = ct.prepareStatement("SELECT * FROM books ");// 数据查询
			rs = ps.executeQuery();// 语句执行
			while (rs.next()) {
				ob[n][0] = rs.getString("bo_id");
				ob[n][1] = rs.getString("sp_id");
				ob[n][2] = rs.getString("em_id");
				ob[n][3] = rs.getString("bo_name");
				ob[n][4] = rs.getString("price");
				ob[n][5] = rs.getString("store");
				ob[n][6] = rs.getString("date");
				ob[n][7] = rs.getString("rollalty");
				ob[n][8] = rs.getString("remarks");
				n++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ob;

	}

	// 1、查询全部的作者信息 2、将作者信息填入表格中 3、插入作者信息
	public void saveAuthors(authorsTable authors) {
		try {
			String sql = "INSERT INTO authors VALUES(?,?,?,?,?);";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, authors.getAu_id());
			ps.setString(2, authors.getAu_name());
			ps.setString(3, authors.getPhone());
			ps.setString(4, authors.getAdress());
			ps.setString(5, authors.getContact());
			ps.executeUpdate();// 更新列表
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 1、查询全部的专题信息 2、将专题数据数据填入表格中 3、插入专题信息
	public ArrayList addAuthors() {
		ArrayList<String> strArray = new ArrayList<>();
		ArrayList<String> strArray1 = new ArrayList<>();
		try {
			PreparedStatement ps = ct.prepareStatement("SELECT * FROM authors ");
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				String s = rs.getString("au_id");
				strArray.add(s);
				count++;
			}
			strArray.add(Integer.toString(count));
			for (; count >= 0; count--) {
				strArray1.add(strArray.get(count));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return strArray1;
	}

	public Object[][] allAuthor(authorsTable authors) {
		Object[][] ob = new Object[20][5];
		int n = 0;
		try {
			PreparedStatement ps = ct.prepareStatement("SELECT * FROM authors ");// 数据查询
			rs = ps.executeQuery();// 语句执行
			while (rs.next()) {
				ob[n][0] = rs.getString("au_id");
				ob[n][1] = rs.getString("au_name");
				ob[n][2] = rs.getString("phone");
				ob[n][3] = rs.getString("address");
				ob[n][4] = rs.getString("contact");
				n++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ob;
	}

	// 1、查询全部的作者信息 2、将作者信息填入表格中 3、添加专题信息
	public Object[][] allSpecial(SpecialTable special) {
		Object[][] ob = new Object[20][2];
		int n = 0;
		try {
			PreparedStatement ps = ct.prepareStatement("SELECT * FROM subject ");
			rs = ps.executeQuery();
			while (rs.next()) {
				ob[n][0] = rs.getString("sp_id");
				ob[n][1] = rs.getString("sp_name");
				n++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ob;
	}

	public ArrayList addSpecial1() {
		ArrayList<String> strArray = new ArrayList<>();
		ArrayList<String> strArray1 = new ArrayList<>();
		try {
			PreparedStatement ps = ct.prepareStatement("SELECT * FROM subject ");// 1、查询语句 2、执行
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				String s = rs.getString("sp_name ");
				strArray.add(s);
				count++;
			}
			strArray.add(Integer.toString(count));
			for (; count >= 0; count--) {
				strArray1.add(strArray.get(count));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return strArray1;
	}

	public ArrayList addSpecial() {
		ArrayList<String> strArray = new ArrayList<>();
		ArrayList<String> strArray1 = new ArrayList<>();
		try {
			PreparedStatement ps = ct.prepareStatement("SELECT * FROM subject ");// 1、查询语句 2、执行
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				String s = rs.getString("sp_id");
				strArray.add(s);
				count++;
			}
			strArray.add(Integer.toString(count));
			for (; count >= 0; count--) {
				strArray1.add(strArray.get(count));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return strArray1;
	}

	public void saveSpecial(SpecialTable special) {
		try {
			String sql = "INSERT INTO subject VALUES(?,?)";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, special.getSp_id());
			ps.setString(2, special.getSp_name());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 1、查询全部的书籍信息 2、将书籍数据数据填入表格中 3、插入书籍信息
	// 1、全部员工数据填入表格中
	public Object[][] allEmployee(EmployeeTable employee) {
		Object[][] ob = new Object[20][7];
		int n = 0;
		try {
			String sql = "select * from employee";
			PreparedStatement ps = ct.prepareStatement(sql);// 查询员工信息
			rs = ps.executeQuery();// 语句执行
			while (rs.next()) {
				ob[n][0] = rs.getString("em_id");
				ob[n][1] = rs.getString("em_name");
				ob[n][2] = rs.getString("sex");
				ob[n][3] = rs.getInt("job");
				ob[n][4] = rs.getString("hire_date");
				ob[n][5] = rs.getString("month_pay");
				ob[n][6] = rs.getString("phone");
				n++;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return ob;
	}

	// 添加员工数据
	public ArrayList addEmployee() {
		ArrayList<String> strArray = new ArrayList<>();
		ArrayList<String> strArray1 = new ArrayList<>();
		try {
			PreparedStatement ps = ct.prepareStatement("SELECT * FROM employee");
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				String s = rs.getString("em_id");
				strArray.add(s);
				count++;
			}
			strArray.add(Integer.toString(count));
			for (; count >= 0; count--) {
				strArray1.add(strArray.get(count));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return strArray1;
	}

	// 3、保存员工信息
	public void saveEmployee(EmployeeTable employee) {
		try {
			String sql = "INSERT INTO employee VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, employee.getEm_id());
			ps.setString(2, employee.getEm_name());
			ps.setString(3, employee.getSex());
			ps.setInt(4, employee.job);
			ps.setString(5, employee.getHire_date());
			ps.setString(6, employee.getMonth_pay());
			ps.setString(7, employee.getPhone());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 删除员工信息
	public int DeleteEmployee(EmployeeTable employ) {
		try {
			String sql = "DELETE FROM employee WHERE em_id=? OR em_name=?";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, employ.getEm_id());
			ps.setString(2, employ.getEm_name());
			int count = ps.executeUpdate();
			System.out.println(count);
			if (count == 1) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	// 删除专题数据
	public int deleteSpecial(SpecialTable special) {
		try {
			String sql = "DELETE FROM subject WHERE sp_id=? OR sp_name=?";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, special.getSp_id());
			ps.setString(2, special.getSp_name());
			int count = ps.executeUpdate();
			if (count == 1) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return 0;
		}

	}

	// 删除作者信息
	public int deleteAuthors(authorsTable author) {
		try {
			String sql = "DELETE FROM authors WHERE au_id=?";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, author.getAu_id());
			int count = ps.executeUpdate();
			if (count == 1) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}

	}

	// 删除书籍信息
	public int deleteBooks(BookInfo book) {
		try {
			String sql = "DELETE FROM books WHERE bo_id=? OR bo_name=?";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, book.getBo_id());
			ps.setString(2, book.getBo_name());
			int count = ps.executeUpdate();
			if (count == 1) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	
	
	
	
	
}
