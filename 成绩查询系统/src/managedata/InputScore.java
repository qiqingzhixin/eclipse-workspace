package managedata;

import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import achievement_query_system.DataBaseManage;

public class InputScore {
//	JFrame jf;
	JPanel jp;
	String[] ln= {"课程:","任课老师:","请输入课程名:","已选修课程的学生:"};
	JLabel[] label;
	JLabel[] vlabel;
	String[] bn= {"查询","输入成绩","成绩分布","退出"};
	JButton[] jb;
	JTable table;
	String[] tabletitle= {"学号","成绩"};
	JComboBox<String> comboBox;
	//数据
	DataBaseManage dbm;
	int[][] labellocation= {
			{20,20,30,20},
			{400,20,60,20},
			{20,60,100,20},
			{250,60,150,20}
	};
	int [][] vlabellocation= {
			{60,20,60,20},
			{480,20,60,20}
	};
	int[][] buttonlocation= {
			{530,90,100,30},
			{530,170,100,30},
			{530,250,100,30},
			{530,330,100,30}
	};
	int []comboBoxlocation= {20,90,150,20};
	int [] jslocation= {250,90,250,250};
	public InputScore() {
		//数据
		dbm=new DataBaseManage();
//		jf=new JFrame("成绩管理");
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp=new JPanel(null);
//		jf.setContentPane(jp);
		//四个JButton
		jb=new JButton[4];
		for(int i=0;i<jb.length;i++) {
			jb[i]=new JButton(bn[i]);
			jp.add(jb[i]);
			jb[i].setBounds(buttonlocation[i][0], buttonlocation[i][1], buttonlocation[i][2], buttonlocation[i][3]);
		}
		//四个标题
		label=new JLabel[4];
		for(int i=0;i<label.length;i++) {
			label[i]=new JLabel(ln[i]);
			jp.add(label[i]);
			label[i].setBounds(labellocation[i][0], labellocation[i][1],labellocation[i][2],labellocation[i][3]);
		}
		//一个课程名字，一个老师名字
		vlabel=new JLabel[2];
		vlabel[0]=new JLabel("霍建华");
		jp.add(vlabel[0]);
		vlabel[0].setBounds(vlabellocation[0][0], vlabellocation[0][1], vlabellocation[0][2], vlabellocation[0][3]);
		vlabel[1]=new JLabel("没道理");
		jp.add(vlabel[1]);
		vlabel[1].setBounds(vlabellocation[1][0], vlabellocation[1][1], vlabellocation[1][2], vlabellocation[1][3]);
		//下拉列表的创建
		String[] testcomboBox= dbm.getCourseNames();
		comboBox=new JComboBox<>(testcomboBox);
		jp.add(comboBox);
		comboBox.setBounds(comboBoxlocation[0], comboBoxlocation[1],comboBoxlocation[2], comboBoxlocation[3]);
		//创建一个table表格
		String[][] testtable= {{}};
		DefaultTableModel dtm=new DefaultTableModel(testtable, tabletitle) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if(column==1) {
					return true;
				}else {
					return false;
				}
			}
		};
		table=new JTable(dtm);
		
		JScrollPane js=new JScrollPane(table);
		jp.add(js);
		js.setBounds(jslocation[0], jslocation[1],jslocation[2], jslocation[3]);
		//进行布局
//		//js.setBounds(300,300, 80, 80);
//		label[0].setBounds(20, 20, 30, 20);
//		vlabel[0].setBounds(60,20,80,20);
		jb[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cname=(String)comboBox.getSelectedItem();
				System.out.println(cname);
				vlabel[0].setText(cname);
				vlabel[1].setText(dbm.getTeacher(cname));
				String[][]one=dbm.getSno(cname);
				while(dtm.getRowCount()!=0) {
					dtm.removeRow(0);
				}
				for(int i=0;i<one.length;i++) {
					dtm.addRow(one[i]);
				}
			}
		});
		jb[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n=table.getSelectedRow();
				String cname=(String)comboBox.getSelectedItem();
				System.out.println(table.getValueAt(n, 1));
				dbm.addScore((String)table.getValueAt(n, 0),dbm.getCno(cname),Integer.parseInt((String)table.getValueAt(n, 1)));
			}
		});
		jb[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jb[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
//		jf.setSize(new Dimension(800, 500));
//		jf.setLocation(200, 200);
//		jf.setVisible(true);
	}
	public JPanel getJPanel() {
		return jp;
	}
	public static void main(String[]args) {
		new InputScore();
	}
}
