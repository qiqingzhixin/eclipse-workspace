package four;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyAbsolutePostion {
	public static void main(String[]args) {
		JFrame jf=new JFrame("æ¯∂‘Œª÷√≤‚ ‘");
		JPanel jp=new JPanel(null);
		jf.setContentPane(jp);
		JButton[] jb=new JButton[16];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				jb[i*4+j]=new JButton(i+":"+j);
				jp.add(jb[i*4+j]);
				jb[i*4+j].setBounds(i*80, j*40, 70, 40);
			}
		}
		jf.setSize(new Dimension(500, 500));
		jf.setVisible(true);
	}
}
