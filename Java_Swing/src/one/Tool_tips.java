package one;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tool_tips {
	public static void main(String[]args) {
		JFrame jf=new JFrame("tool_test");
		jf.setSize(300, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp=new JPanel();
		jf.setContentPane(jp);
		JButton jb=new JButton("ȷ��");
		JButton jb2=new JButton("ȡ��");
		jp.add(jb);
		jp.add(jb2);
		jb.setToolTipText("�����ť��һ��ȷ����ť");
		jb2.setToolTipText("�����ťʽһ��ȡ����ť");
		jf.setVisible(true);
	}
}
