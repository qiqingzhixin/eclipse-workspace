package one;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LiuXin {
	public static void main(String[]args) {
		JFrame jf=new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp=new JPanel(new BorderLayout());
		jf.setContentPane(jp);
		JTextField jt=new JTextField(20);
		jt.setFocusable(false);
		jp.add(jt,BorderLayout.NORTH);
		JPanel jp1=new JPanel(new GridLayout(4, 4));
		jp.add(jp1,BorderLayout.CENTER);
		JButton[] button=new JButton[16];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				button[i*4+j]=new JButton(""+(i*4+j));
				jp1.add(button[i*4+j]);
			}
		}
		jf.pack();
		jf.setVisible(true);
	}
}
