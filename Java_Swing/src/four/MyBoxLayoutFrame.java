package four;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyBoxLayoutFrame {
	JFrame  jf;
	public MyBoxLayoutFrame() {
		// TODO Auto-generated constructor stub
		jf=new JFrame();
		jf.setTitle("Boxtest");
		JPanel jp=new JPanel();
		jf.setContentPane(jp);
		JLabel jl=new JLabel("姓名:");
		JTextField jtf=new JTextField(10);
		Box hbox1=Box.createHorizontalBox();
		hbox1.setSize(new Dimension(200, 200));
		hbox1.add(jl);
		hbox1.add(Box.createHorizontalStrut(200));
		hbox1.add(jtf);
		JLabel jl2=new JLabel("密码 ");
		JTextField jtf2=new JTextField(10);
		Box hbox2=Box.createHorizontalBox();
		hbox2.add(jl2);
		hbox2.add(Box.createHorizontalStrut(20));
		hbox2.add(jtf2);
		JButton jb=new JButton("确定");
		JButton jb2=new JButton("取消");
		Box hbox3=Box.createHorizontalBox();
		hbox3.add(jb);
		hbox3.add(jb2);
		Box vbox=Box.createVerticalBox();
		vbox.add(hbox1);
		vbox.add(hbox2);
		vbox.add(Box.createVerticalGlue());
		vbox.add(hbox3);
		jp.add(vbox,BorderLayout.CENTER);
		jf.setBounds(400, 400, 400, 400);
		jf.setVisible(true);
	}
	public static void main(String[]args) {
		new MyBoxLayoutFrame();
	}
}
