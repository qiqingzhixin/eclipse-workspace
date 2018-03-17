import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class Main_four {
	public static void main(String [] args	) {
		JFrame window1=new JFrame("第一个窗口");
		JFrame window2=new JFrame("第二个窗口");
		Container con= window1.getContentPane();
		con.setBackground(Color.yellow);
		window1.setBounds(60, 100, 188, 108);
		window2.setBounds(260, 100, 188, 108);
		window1.setVisible(true);
		window1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window2.setVisible(true);
		window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("hello world");
	}

}
