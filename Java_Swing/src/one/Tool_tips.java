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
		JButton jb=new JButton("确定");
		JButton jb2=new JButton("取消");
		jp.add(jb);
		jp.add(jb2);
		jb.setToolTipText("这个按钮是一个确定按钮");
		jb2.setToolTipText("这个按钮式一个取消按钮");
		jf.setVisible(true);
	}
}
