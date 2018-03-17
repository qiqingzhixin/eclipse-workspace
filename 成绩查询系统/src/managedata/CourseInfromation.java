package managedata;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import achievement_query_system.DataBaseManage;
import course.CourseData;

public class CourseInfromation {
//	JFrame frame;
	JPanel jp;
	JLabel label_num;
	String sln;
	String[] title= {
			"课程号","课程名","学分","所在系","任课老师"
	};
	int[] l= {20,20,2,2,10,20,20};
	JPanel button_panel;
	JButton button_add;
	JButton button_save;
	JButton button_delete;
	JButton button_out;
	Object[][]one= {};
	String[] string_button= {"新增","保存","删除","退出"};
	JButton[] button;
	MyTable table;
	DefaultTableModel dtm;
	//数据
	DataBaseManage dataBaseManage;
	HashMap<String, CourseData> data;
	int datalenght;
	public CourseInfromation() {
		dataBaseManage=new DataBaseManage();
		data=dataBaseManage.getCourseDatas();
//		frame=new JFrame("课程信息");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp=new JPanel(new BorderLayout());
//		frame.setContentPane(jp);
		datalenght=data.size();
		sln="记录总数    "+datalenght;
		label_num=new JLabel(sln);
		label_num.setFont(new Font(sln,20,20));
		jp.add(label_num,BorderLayout.NORTH);
		dtm=new DefaultTableModel(one, title);
		table=new MyTable(dtm);
		//jp.add(table,BorderLayout.CENTER);
		Iterator<Entry<String, CourseData>>iterator=data.entrySet().iterator();
		while(iterator.hasNext()) {
			CourseData cd=iterator.next().getValue();
			String[] rowData= {cd.cno,cd.cname,Integer.toString(cd.credit),cd.cdept,cd.tname};
			dtm.addRow(rowData);
		}
		jp.add(new JScrollPane(table),BorderLayout.CENTER);
		button_panel=new JPanel(new GridLayout(4, 1,0,40));
		button=new JButton[4];
		for(int i=0;i<4;i++) {
			button[i]=new JButton(string_button[i]);
			button[i].setPreferredSize(new Dimension(60, 30));
			button_panel.add(button[i]);
		}
		jp.add(button_panel,BorderLayout.EAST);
//		frame.setBounds(200, 200, 600,400);
//		frame.setVisible(true);
		button[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrame f=new JFrame("输入课程信息");
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.setLocation(200, 200);
				JPanel p=new JPanel(new GridLayout(6, 2));
				f.setContentPane(p);
				JLabel[] al=new JLabel[5];
				JTextField[] at=new JTextField[5];
				for(int i=0;i<5;i++) {
					al[i]=new JLabel(title[i]+":");
					p.add(al[i]);
					at[i]=new JTextField(l[i]);
					p.add(at[i]);
				}
				JButton aok=new JButton("确定");
				JButton acal=new JButton("取消");
				aok.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String axh=at[0].getText();
						if(data.get(axh)!=null) {
							if(data.get(axh).flag!=2) {
								JOptionPane.showMessageDialog(f,"存在该课程","错误消息",JOptionPane.WARNING_MESSAGE );
							}else {
								CourseData sd=new CourseData(3,at[0].getText(),at[1].getText(),Integer.parseInt(at[2].getText()),at[3].getText(),at[4].getText());
								data.put(sd.cno, sd);
								sln="记录总数    "+(++datalenght);
								label_num.setText(sln);;
								String[] rowData= {sd.cno,sd.cname,Integer.toString(sd.credit),sd.cdept,sd.tname};
								dtm.addRow(rowData);
								JOptionPane.showMessageDialog(f, "输入成功","成功消息",JOptionPane.INFORMATION_MESSAGE);
							}
						}else {
							CourseData sd=new CourseData(1,at[0].getText(),at[1].getText(),Integer.parseInt(at[2].getText()),at[3].getText(),at[4].getText());
							data.put(sd.cno, sd);
							sln="记录总数    "+(++datalenght);
							label_num.setText(sln);
							String[] rowData= {sd.cno,sd.cname,Integer.toString(sd.credit),sd.cdept,sd.tname};
							dtm.addRow(rowData);
							JOptionPane.showMessageDialog(f, "输入成功","成功消息",JOptionPane.INFORMATION_MESSAGE);
						}
						for(int i=0;i<5;i++) {
							at[i].setText("");
						}
					}
				});
				acal.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						f.setVisible(false);
					}
				});
				p.add(aok);
				p.add(acal);
				f.pack();
				f.setVisible(true);
			}
		});
		button[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Iterator<Entry<String,CourseData>> iterator=data.entrySet().iterator();
				while(iterator.hasNext()) {
					CourseData sd=iterator.next().getValue();
					if(sd.flag==1) {
						System.out.println(1);
						dataBaseManage.addCourseData(sd);
					}else if(sd.flag==2) {
						System.out.println(2);
						dataBaseManage.deleteCourseData(sd);
					}else if(sd.flag==3) {
						System.out.println(3);
						dataBaseManage.changeCourseData(sd);
					}
					System.out.println(sd);
				}
			}
		});
		button[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selecteRow=table.getSelectedRow();
				if(selecteRow!=-1) {
					String dsno=(String)dtm.getValueAt(selecteRow, 0);
					CourseData sd=data.get(dsno);
					sd.flag=2;
					data.put(dsno, sd);
					sln="记录总数    "+(--datalenght);
					label_num.setText(sln);
					dtm.removeRow(selecteRow);
				}
			}
		});
		button[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	public JPanel getJPanel() {
		return jp;
	}
	public static void main(String[]args) {
		new CourseInfromation();
	}
	class CourseDataManage{
		public CourseDataManage() {
			
		}
	}
}