package one;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloWorld {
	public static void main(String []args) {
		JFrame jf=new JFrame("���Դ���");
		JPanel jp=new JPanel();
		jf.setContentPane(jp);
		JButton jb=new JButton("���Ǹ����԰�ť");
		jp.add(jb);
		jf.setVisible(true);
	}
}
