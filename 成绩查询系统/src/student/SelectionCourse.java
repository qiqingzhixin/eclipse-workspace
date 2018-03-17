package student;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import achievement_query_system.DataBaseManage;
import managedata.MyTable;

public class SelectionCourse {
	String[] ln= {"学生详细信息:","可选课程:","请输入课程号:","已修课程成绩:","已选课程:"};
	String[]lb= {"选课","退课","关闭"};
	String[][]title={ 	
			{"学号","姓名","年龄","性别","所在系"},
			{"课程号","课程名"},
			{"课程号","课程名","成绩"},
			{"课程号","课程名","学分","开课系","任课老师"}
	};
	JFrame jf;
	JLabel []jl;
	MyTable [] table;
	JButton []jb;
	JTextField jtf;
	DefaultTableModel[] dtm;
	String[][][] one= {};
	JScrollPane[] js;
	int width=350,height=100;
	String sno;
	DataBaseManage dbm;
	public SelectionCourse(String sno) {
		this.sno=sno;
		jf=new JFrame("学生选课");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp=new JPanel();
		jf.setLocation(200, 200);
		jtf=new JTextField(10);
		jl=new JLabel[ln.length];
		js=new JScrollPane[4];
		for(int i=0;i<ln.length;i++) {
			jl[i]=new JLabel(ln[i]);
		}
		jb=new JButton[lb.length];
		for(int i=0;i<lb.length;i++) {
			jb[i]=new JButton(lb[i]);
		}
		table=new MyTable[4];
		dtm=new DefaultTableModel[4];
		dbm=new DataBaseManage();
		one=new String[4][][];
		one[0]=dbm.getSI(sno);
		one[1]=dbm.getAvailableCourse(sno);
		one[2]=dbm.getLeanedCourse(sno);
		one[3]=dbm.getSelectedCourse(sno);
		for(int i=0;i<4;i++) {
			dtm[i]=new DefaultTableModel(one[i],title[i]);
			table[i]=new MyTable(dtm[i]);
			//table[i].setPreferredSize(new Dimension(width, height));
			js[i]=new JScrollPane(table[i]);
			js[i].setPreferredSize(new Dimension(width,height));
		}
		//选课
		jb[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selection=table[1].getSelectedRow();
				if(selection!=-1) {
					String cno=(String)dtm[1].getValueAt(selection, 0);
					//已经有了选课的课号cno,学生的学号sno,要对sc添加一个数据，删除可选课程中的该门课程，添加已选课程中的该门课程
					dbm.addCourse(sno, cno);
					dtm[1].removeRow(selection);
					//获取该课程的信息
					String[] item=dbm.getItemInformation(cno);
					dtm[3].addRow(item);
				}
				
			}
		});
		//退课
		jb[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selection=table[3].getSelectedRow();
				System.out.println(selection);
				if(selection!=-1) {
					String cno=(String)dtm[3].getValueAt(selection, 0);
					System.out.println(cno);
					//已有课程号cno,学生号sno 要对sc删除一个数据，删除已选课程中的该门课，添加可选课程中的该门课
					dbm.deleteCourse(sno, cno);
					String[] item=new String[2];
					item[0]=(String)dtm[3].getValueAt(selection,0);
					item[1]=(String)dtm[3].getValueAt(selection,1);
					System.out.printf(item[0], item[1]);
					dtm[1].addRow(item);
					dtm[3].removeRow(selection);
				}
			}
		});
		//退出
		jb[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		Box b1=Box.createVerticalBox();
		Box b2=Box.createVerticalBox();
		Box b3=Box.createVerticalBox();
		Box b4=Box.createHorizontalBox();
		b4.add(b1);
		b4.add(b2);
		b4.add(b3);
		
		b1.add(jl[0]);
		b1.add(js[0]);
		b1.add(jl[3]);
		b1.add(js[2]);
		
		b2.add(jl[1]);
		b2.add(js[1]);
		b2.add(jl[4]);
		b2.add(js[3]);
		
		b3.add(jl[2]);
		b3.add(jtf);
		b3.add(Box.createVerticalStrut(100));
		b3.add(jb[0]);
		b3.add(Box.createVerticalStrut(50));
		b3.add(jb[1]);
		b3.add(Box.createVerticalStrut(50));
		b3.add(jb[2]);
		b3.add(Box.createVerticalStrut(200));
		jp.add(b4,BorderLayout.CENTER);
		
		//成绩单
		JPanel jps=new JPanel();
		JLabel[] resno=new JLabel[5];
		for(int i=0;i<5;i++) {
			resno[i]=new JLabel();
		}
		resno[0].setFont(new Font(one[0][0][0], 1, 20));
		resno[1].setFont(new Font(one[0][0][1], 1, 20));
		resno[2].setFont(new Font("学生成绩单", 1, 20));
		resno[3].setFont(new Font("平均成绩", 1, 30));
		resno[4].setFont(new Font(dbm.getAvg(sno), 1, 30));
		resno[0].setText(one[0][0][0]);
		resno[1].setText(one[0][0][1]);
		resno[2].setText("学生成绩单");
		resno[3].setText("平均成绩");
		resno[4].setText(dbm.getAvg(sno));
		Box box5=Box.createHorizontalBox();
		box5.add(resno[0]);
		box5.add(Box.createHorizontalStrut(30));
		box5.add(resno[1]);
		box5.add(Box.createHorizontalStrut(30));
		box5.add(resno[2]);
		String[] retitle= {"课程号","课程名","成绩","学分","教师"};
		MyTable retable=new MyTable(dbm.getItemCourse(sno),retitle);
		Box box6=Box.createVerticalBox();
		box6.add(box5);
		box6.add(new JScrollPane(retable));
		Box box7=Box.createHorizontalBox();
		box7.add(resno[3]);
		box7.add(Box.createHorizontalStrut(40));
		box7.add(resno[4]);
		box6.add(box7);
		jps.add(box6,BorderLayout.CENTER);
		//JTabbedPane
		JTabbedPane jtp=new JTabbedPane(JTabbedPane.LEFT);
		jtp.add("学生选课",jp);
		jtp.add("成绩单", jps);
		jf.setContentPane(jtp);
		jf.pack();
		jf.setVisible(true);
		
	}
	public static void main(String[]args) {
		new SelectionCourse("14122");
	}
}
