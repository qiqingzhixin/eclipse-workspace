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
	String[] ln= {"ѧ����ϸ��Ϣ:","��ѡ�γ�:","������γ̺�:","���޿γ̳ɼ�:","��ѡ�γ�:"};
	String[]lb= {"ѡ��","�˿�","�ر�"};
	String[][]title={ 	
			{"ѧ��","����","����","�Ա�","����ϵ"},
			{"�γ̺�","�γ���"},
			{"�γ̺�","�γ���","�ɼ�"},
			{"�γ̺�","�γ���","ѧ��","����ϵ","�ο���ʦ"}
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
		jf=new JFrame("ѧ��ѡ��");
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
		//ѡ��
		jb[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selection=table[1].getSelectedRow();
				if(selection!=-1) {
					String cno=(String)dtm[1].getValueAt(selection, 0);
					//�Ѿ�����ѡ�εĿκ�cno,ѧ����ѧ��sno,Ҫ��sc���һ�����ݣ�ɾ����ѡ�γ��еĸ��ſγ̣������ѡ�γ��еĸ��ſγ�
					dbm.addCourse(sno, cno);
					dtm[1].removeRow(selection);
					//��ȡ�ÿγ̵���Ϣ
					String[] item=dbm.getItemInformation(cno);
					dtm[3].addRow(item);
				}
				
			}
		});
		//�˿�
		jb[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selection=table[3].getSelectedRow();
				System.out.println(selection);
				if(selection!=-1) {
					String cno=(String)dtm[3].getValueAt(selection, 0);
					System.out.println(cno);
					//���пγ̺�cno,ѧ����sno Ҫ��scɾ��һ�����ݣ�ɾ����ѡ�γ��еĸ��ſΣ���ӿ�ѡ�γ��еĸ��ſ�
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
		//�˳�
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
		
		//�ɼ���
		JPanel jps=new JPanel();
		JLabel[] resno=new JLabel[5];
		for(int i=0;i<5;i++) {
			resno[i]=new JLabel();
		}
		resno[0].setFont(new Font(one[0][0][0], 1, 20));
		resno[1].setFont(new Font(one[0][0][1], 1, 20));
		resno[2].setFont(new Font("ѧ���ɼ���", 1, 20));
		resno[3].setFont(new Font("ƽ���ɼ�", 1, 30));
		resno[4].setFont(new Font(dbm.getAvg(sno), 1, 30));
		resno[0].setText(one[0][0][0]);
		resno[1].setText(one[0][0][1]);
		resno[2].setText("ѧ���ɼ���");
		resno[3].setText("ƽ���ɼ�");
		resno[4].setText(dbm.getAvg(sno));
		Box box5=Box.createHorizontalBox();
		box5.add(resno[0]);
		box5.add(Box.createHorizontalStrut(30));
		box5.add(resno[1]);
		box5.add(Box.createHorizontalStrut(30));
		box5.add(resno[2]);
		String[] retitle= {"�γ̺�","�γ���","�ɼ�","ѧ��","��ʦ"};
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
		jtp.add("ѧ��ѡ��",jp);
		jtp.add("�ɼ���", jps);
		jf.setContentPane(jtp);
		jf.pack();
		jf.setVisible(true);
		
	}
	public static void main(String[]args) {
		new SelectionCourse("14122");
	}
}
