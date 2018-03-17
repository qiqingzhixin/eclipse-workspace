package one;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Containers {
	public static void main(String[] args) {
		JFrame jf=new JFrame("containers");
		jf.setSize(300,200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp=new JPanel();
		JButton jb1=new JButton("确定");
		JButton jb2=new JButton("取消");
		jp.add(jb2);
		jp.add(jb1);
		jf.setContentPane(jp);
		jf.setVisible(true);
	}
}
