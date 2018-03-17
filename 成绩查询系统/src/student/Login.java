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
		//数据
		DataBaseManage dbm=new DataBaseManage();
		//界面
		JFrame jf=new JFrame("系统登录");
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
		//定义控件
		JButton ok=new JButton("登录");
		JButton cancel=new JButton("退出");
		JLabel title=new JLabel("   ");
		JLabel name=new JLabel("用户名:");
		JLabel pass=new JLabel("口令:");
		JTextField nameinput=new JTextField(15);
		JPasswordField passinput=new JPasswordField(15);
		//设置监听器
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String logn=nameinput.getText();
				String pass=passinput.getText();
				String flag=dbm.login(logn, pass);
				if(flag==null) {
					JOptionPane.showMessageDialog(jf,"用户不存在","登陆失败",JOptionPane.WARNING_MESSAGE );
				}else if(flag.equals("")) {
					JOptionPane.showMessageDialog(jf, "密码错误","登陆失败",JOptionPane.WARNING_MESSAGE);
				}else {
					//JOptionPane.showMessageDialog(jf, "你好"+flag,"登录成功",JOptionPane.INFORMATION_MESSAGE);
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
		//GridBagConstraints 进行约束设置
		GridBagConstraints con=new GridBagConstraints();
		con.fill=GridBagConstraints.HORIZONTAL;
		con.anchor=GridBagConstraints.EAST;
		con.weightx=3;
		con.weighty=4;
		//放置控件
		add(jp,title,con,1,0,4,1);
		add(jp,name,con,0,1,1,1);
		add(jp,pass,con,0,2,1,1);
		add(jp,ok,con,0,3,1,1);
		add(jp,nameinput,con,2,1,1,1);
		add(jp,passinput,con,2,2,1,1);
		add(jp,cancel,con,3,3,1,1);
		jf.setResizable(false);
		jf.setVisible(true);
		//对Button设置
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
