package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class nullTable {

}
class SpecialPrint extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();// ¹¹ÔìÐÂÈÝÆ÷
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	Object[] s = { "sp_id", "sp_name" };
	Object[][] ob = new Object[20][2];
	JTable table = new JTable(ob, s);
	JScrollPane sroll = new JScrollPane(table);
	public SpecialPrint() {
		
		SpecialTable special = new SpecialTable();
		//ob = op.searchSpecial(special);
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
		// c.add(p2, BorderLayout.EAST);
		c.add(p3, BorderLayout.NORTH);
		p1.add(sroll);
		p3.setLayout(new GridLayout(1, 4, 10, 10));
		c.setBackground(new Color(200, 255, 255));
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}