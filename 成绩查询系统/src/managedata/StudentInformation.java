package managedata;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import achievement_query_system.DataBaseManage;
import student.StudentData;

public class StudentInformation {
//	JFrame frame;
	JPanel jp;
	JLabel label_num;
	String sln;
	String[] title= {
			"学号","姓名","性别","年龄","所在系","登录名","密码"
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
	HashMap<String, StudentData> data;
	int datalenght;
	public StudentInformation() {
		dataBaseManage=new DataBaseManage();
		data=dataBaseManage.getStudentDatas();
//		frame=new JFrame("学生信息");
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
		Iterator<Entry<String, StudentData>>iterator=data.entrySet().iterator();
		while(iterator.hasNext()) {
			StudentData sd=iterator.next().getValue();
			String[] rowData= {sd.sno,sd.sname,sd.sex,Integer.toString(sd.age),sd.sdept,sd.logn,sd.password};
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
				JFrame f=new JFrame("输入学生信息");
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.setLocation(200, 200);
				JPanel p=new JPanel(new GridLayout(8, 2));
				f.setContentPane(p);
				JLabel[] al=new JLabel[7];
				JTextField[] at=new JTextField[7];
				JPanel[] ap=new JPanel[8];
				for(int i=0;i<7;i++) {
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
								JOptionPane.showMessageDialog(f,"存在该学生","错误消息",JOptionPane.WARNING_MESSAGE );
							}else {
								StudentData sd=new StudentData(3,at[0].getText(),at[1].getText(),at[2].getText(),Integer.parseInt(at[3].getText()),at[4].getText(),at[5].getText(),at[6].getText());
								data.put(sd.sno, sd);
								sln="记录总数    "+(++datalenght);
								label_num.setText(sln);;
								String[] rowData= {sd.sno,sd.sname,sd.sex,Integer.toString(sd.age),sd.sdept,sd.logn,sd.password};
								dtm.addRow(rowData);
								JOptionPane.showMessageDialog(f, "输入成功","成功消息",JOptionPane.INFORMATION_MESSAGE);
							}
						}else {
							StudentData sd=new StudentData(1,at[0].getText(),at[1].getText(),at[2].getText(),Integer.parseInt(at[3].getText()),at[4].getText(),at[5].getText(),at[6].getText());
							data.put(sd.sno, sd);
							sln="记录总数    "+(++datalenght);
							label_num.setText(sln);
							String[] rowData= {sd.sno,sd.sname,sd.sex,Integer.toString(sd.age),sd.sdept,sd.logn,sd.password};
							dtm.addRow(rowData);
							JOptionPane.showMessageDialog(f, "输入成功","成功消息",JOptionPane.INFORMATION_MESSAGE);
						}
						for(int i=0;i<7;i++) {
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
				Iterator<Entry<String,StudentData>> iterator=data.entrySet().iterator();
				while(iterator.hasNext()) {
					StudentData sd=iterator.next().getValue();
					if(sd.flag==1) {
						System.out.println(1);
						dataBaseManage.addStudentData(sd);
					}else if(sd.flag==2) {
						System.out.println(2);
						dataBaseManage.deleteStudentData(sd);
					}else if(sd.flag==3) {
						System.out.println(3);
						dataBaseManage.changeStudentData(sd);
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
					StudentData sd=data.get(dsno);
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
	public JPanel getPanel() {
		return jp;
	}
	public static void main(String[]args) {
		new StudentInformation();
	}
	class StudentDataManage{
		public StudentDataManage() {
		}
	}
}
