package test;

/*
 * ������
 * 
 * */
import java.awt.*;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main_Face {

}

class MyFrame extends JFrame implements ActionListener {
	
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JLabel welcome = new JLabel("��ӭʹ�ó��������ϵͳ  ^_^");
	JLabel Copyright = new JLabel("CHU BAN SHE XIN XI GUAN LI XI TONG");
	// ����ť��ͼ��
	JButton Special = new JButton("ר����Ϣ", new ImageIcon("./src/image/1.png"));
	JButton Employee = new JButton("Ա����Ϣ", new ImageIcon("./src/image/2.png"));
	JButton Author = new JButton("������Ϣ", new ImageIcon("./src/image/3.png"));
	JButton Books = new JButton("�鼮��Ϣ", new ImageIcon("./src/image/4.png"));
//	JButton month=new JButton("��ѯͳ�����ۣ����·ݣ�");
//	JButton year=new JButton("��ѯͳ�����ۣ�����ݣ�");
//	JButton month1=new JButton("��ʱ��β�ѯ�ͻ������¼");
//	JButton year1=new JButton("��ʱ��β�ѯ�鼮���ۼ�¼");
	Font font1 = new Font("��ť����", Font.BOLD, 20);
	Font font2 = new Font("��ӭ����", Font.BOLD, 30);
	Font font_Copyright = new Font("Copyright", Font.PLAIN, 20);

	public MyFrame() {
		
//		 JMenuBar menuBar = new JMenuBar();
//		 menuBar.setLayout(new FlowLayout(40, 4, 0));
//		 menuBar.add(Special);
//		 Special.setPreferredSize(new Dimension(20, 10));// ���ð�ť��С
		c.add(p1, BorderLayout.CENTER); // ��岼��Ϊ�߽粼��
		c.add(p2, BorderLayout.SOUTH);
		c.add(p3, BorderLayout.WEST);
		c.add(p4, BorderLayout.NORTH);
	
		// ���ñ���ɫ
		p2.setBackground(new Color(0, 191, 255));
		p4.setBackground(new Color(0, 191, 255));
		p4.add(welcome);
		p2.add(Copyright);
		p1.setLayout(new GridLayout(1, 4, 20, 20));
		p1.add(Special);
		
		p3.setLayout(new GridLayout(2, 2));
//		p3.add(month);
//		p3.add(month1);
//		p3.add(year);
//		p3.add(year1);
		
		//Special.setBounds(255,255,30,30);
		// ���ַ���ͼ���·�
		Special.setContentAreaFilled(false);
		Special.setHorizontalTextPosition(SwingConstants.CENTER);
		Special.setVerticalTextPosition(SwingConstants.BOTTOM);
		Special.setBorderPainted(false);// ���ر߿�
		p1.add(Employee);
		Employee.setContentAreaFilled(false);//��ť���ر߿�
		Employee.setHorizontalTextPosition(SwingConstants.CENTER);
		Employee.setVerticalTextPosition(SwingConstants.BOTTOM);
		Employee.setBorderPainted(false);// ���ر߿�
		p1.add(Author);
		Author.setContentAreaFilled(false);//��ť���ر߿�
		Author.setHorizontalTextPosition(SwingConstants.CENTER);
		Author.setVerticalTextPosition(SwingConstants.BOTTOM);
		Author.setBorderPainted(false);// ���ر߿�
		p1.add(Books);
		Books.setContentAreaFilled(false);//��ť���ر߿�
		Books.setHorizontalTextPosition(SwingConstants.CENTER);
		Books.setVerticalTextPosition(SwingConstants.BOTTOM);
		Books.setBorderPainted(false);// ���ر߿�
		Copyright.setFont(font_Copyright);
		welcome.setFont(font2);
		Special.setFont(font1);
		Employee.setFont(font1);
		Author.setFont(font1);
		Books.setFont(font1);
		Special.addActionListener(this);
		Employee.addActionListener(this);
		Author.addActionListener(this);
		Books.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// �鼮��Ϣ����
		if (e.getSource() == Books) {
			this.dispose();
			BookRetrieval f = new BookRetrieval();
			f.setTitle("��Ϣ����--���鼮��Ϣ��");
			f.setSize(1024, 720);// ���ô���Ĵ�С
			f.setLocation(250, 80);// ���ô����λ��
			f.setVisible(true);
			Book b = new Book();
			b.setTitle("�鼮��Ϣ");
			b.setLocation(500, 350);
			b.setSize(600, 400);
			b.setVisible(true);

		}
		// ר����Ϣ����
		if (e.getSource() == Special) {
			this.dispose();
			SpecialMain f = new SpecialMain();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("��Ϣ����--��ר����Ϣ��");
			f.setSize(1024, 720);// ���ô���Ĵ�С
			f.setLocation(250, 80);// ���ô����λ��
			f.setVisible(true);
			this.setEnabled(false);
			this.setModalExclusionType(ModalExclusionType.NO_EXCLUDE);
			S_Information b = new S_Information();
			b.setTitle("ר����Ϣ");
			b.setLocation(590, 500);
			b.setSize(350, 200);
			b.setVisible(true);

		}
		// Ա����Ϣ����
		if (e.getSource() == Employee) {
			this.dispose();
			Employee em = new Employee();
			em.setTitle("��Ϣ����--��Ա����Ϣ��");
			em.setSize(1024, 720);// ���ô���Ĵ�С
			em.setLocation(250, 80);// ���ô����λ��
			em.setVisible(true);
			employee_info m = new employee_info();
			m.setTitle("Ա����Ϣ");
			m.setLocation(500, 400);
			m.setSize(650, 400);
			m.setVisible(true);

		}
		// ������Ϣ����
		if (e.getSource() == Author) {
			this.dispose();
			Authors f = new Authors();
			f.setTitle("��Ϣ����--��������Ϣ��");
			f.setSize(1024, 720);// ���ô���Ĵ�С
			f.setLocation(250, 80);// ���ô����λ��
			f.setVisible(true);
			author A = new author();
			A.setTitle("������Ϣ");
			A.setLocation(500, 400);
			A.setSize(550, 300);
			A.setVisible(true);
		}

	}
}