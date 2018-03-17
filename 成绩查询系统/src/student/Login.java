package student;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import achievement_query_system.DataBaseManage;

public class Login {
	public static void main(String[]args) {
		//����
		DataBaseManage dbm=new DataBaseManage();
		//����
		JFrame jf=new JFrame("ϵͳ��¼");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300,150);
		JPanel jp=new JPanel();
		jf.setContentPane(jp);
		jp.setLayout(new GridBagLayout());
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		int x=200;
		int y=200;
		jf.setLocation(x, y);
		//����ؼ�
		JButton ok=new JButton("��¼");
		JButton cancel=new JButton("�˳�");
		JLabel title=new JLabel("   ");
		JLabel name=new JLabel("�û���:");
		JLabel pass=new JLabel("����:");
		JTextField nameinput=new JTextField(15);
		JPasswordField passinput=new JPasswordField(15);
		//���ü�����
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String logn=nameinput.getText();
				String pass=passinput.getText();
				String flag=dbm.login(logn, pass);
				if(flag==null) {
					JOptionPane.showMessageDialog(jf,"�û�������","��½ʧ��",JOptionPane.WARNING_MESSAGE );
				}else if(flag.equals("")) {
					JOptionPane.showMessageDialog(jf, "�������","��½ʧ��",JOptionPane.WARNING_MESSAGE);
				}else {
					//JOptionPane.showMessageDialog(jf, "���"+flag,"��¼�ɹ�",JOptionPane.INFORMATION_MESSAGE);
					new SelectionCourse(flag);
					jf.setVisible(false);
					
				}
			}
		});
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		//GridBagConstraints ����Լ������
		GridBagConstraints con=new GridBagConstraints();
		con.fill=GridBagConstraints.HORIZONTAL;
		con.anchor=GridBagConstraints.EAST;
		con.weightx=3;
		con.weighty=4;
		//���ÿؼ�
		add(jp,title,con,1,0,4,1);
		add(jp,name,con,0,1,1,1);
		add(jp,pass,con,0,2,1,1);
		add(jp,ok,con,0,3,1,1);
		add(jp,nameinput,con,2,1,1,1);
		add(jp,passinput,con,2,2,1,1);
		add(jp,cancel,con,3,3,1,1);
		jf.setResizable(false);
		jf.setVisible(true);
		//��Button����
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	public static void add(JPanel jp,Component c,GridBagConstraints g,int x,int y,int w,int h) {
		g.gridx=x;
		g.gridy=y;
		g.gridwidth=w;
		g.gridheight=h;
		jp.add(c, g);
	}
}
