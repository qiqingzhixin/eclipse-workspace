package one;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloWorld {
	public static void main(String []args) {
		JFrame jf=new JFrame("测试窗口");
		JPanel jp=new JPanel();
		jf.setContentPane(jp);
		JButton jb=new JButton("这是个测试按钮");
		jp.add(jb);
		jf.setVisible(true);
	}
}
