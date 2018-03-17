package one;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Set_Border {
	public static void main(String[]args) {
		JFrame jf=new JFrame("border");
		jf.setSize(300,200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp=new JPanel();
		jf.setContentPane(jp);
		JButton jb1=new JButton("确定");
		JButton jb2=new JButton("取消");
		jp.add(jb1);
		jp.add(jb2);
		jb1.setBorder(BorderFactory.createLineBorder(Color.red));
		jf.setVisible(true);
	}
}
