package two;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test_GridBagLayout {
	public static void main(String[]args) {
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
		int x=(width-300)/2;
		int y=(height-150)/2;
		jf.setLocation(x, y);
		//����ؼ�
		JButton ok=new JButton("ȷ��");
		JButton cancel=new JButton("ȡ��");
		JLabel title=new JLabel("   ");
		JLabel name=new JLabel("�û���");
		JLabel pass=new JLabel("����");
		JTextField nameinput=new JTextField(15);
		JTextField passinput=new JTextField(15);
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
	}
	public static void add(JPanel jp,Component c,GridBagConstraints g,int x,int y,int w,int h) {
		g.gridx=x;
		g.gridy=y;
		g.gridwidth=w;
		g.gridheight=h;
		jp.add(c, g);
	}
}
