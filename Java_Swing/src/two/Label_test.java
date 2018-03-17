package two;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Label_test {
	public static void main(String[]args) {
		JFrame jf=new JFrame("Label");
		jf.setSize(300, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp=new JPanel();
		jf.setContentPane(jp);
		JLabel jl=new JLabel("this is a label for a test");
		JLabel jl2=new JLabel("the label can not be changed");
		jp.add(jl);
		jp.add(jl2);
		jf.setVisible(true);
	}
}
