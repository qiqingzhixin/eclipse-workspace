package two;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyScrollPanel {
	public static void main(String[]args) {
		String text="We are people of xxx software ,we are trying our best to server you!";
		JFrame jf=new JFrame("myscrollPanel");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300, 150);
		JTextArea jt=new JTextArea(text);
		JScrollPane js=new JScrollPane(jt);
		jf.setContentPane(js);
		jf.setVisible(true);
	}
}
