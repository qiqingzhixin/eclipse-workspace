package two;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyJpanel {
	public static void main(String[] args) {
		String[] name= {"小赵","小李","小王","小周","小钱","小孙","小政","小吴","姓"};
		String[] location= {"North","South","East","West","Center"};
		JFrame jf=new JFrame("myjpanel");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300, 150);
		JPanel jp=new JPanel(new BorderLayout());
		JPanel [] p=new JPanel[5];
		JButton [] jb=new JButton[9];
		for(int i=0;i<9;i++) {
			jb[i]=new JButton(name[i]);
		}
		for(int i=0;i<5;i++) {
			p[i]=new JPanel(new FlowLayout());
			p[i].add(jb[2*i]);
			if(i!=4) {
				p[i].add(jb[2*i+1]);
			}
		}
		for(int i=0;i<5;i++) {
			jp.add(p[i],location[i]);
		}
		jf.setContentPane(jp);
		jf.pack();
		jf.setVisible(true);
	}
}
