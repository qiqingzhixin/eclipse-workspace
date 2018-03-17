package two;

import java.awt.FlowLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyJInternalPanel {
	public static void main(String[] args) {
		String[] str= {"这是我第一个窗口","这也是你第一个窗口","这同时也是他第一个窗口","这个我第二个窗口","这也是你第二个窗口","这同时也是他第二个窗口"};
		JFrame frame=new JFrame("MyJInternalPane");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel  panel=new JPanel(new FlowLayout());
		frame.setContentPane(panel);
		JDesktopPane dp=new JDesktopPane();
		dp.setLayout(new FlowLayout());
		panel.add(dp);
		
		JInternalFrame jif1=new JInternalFrame("第一个窗口", true, true, true);
		JInternalFrame jif2=new JInternalFrame("第二个窗口",true,true,true);
		JLabel[] label=new JLabel[6];
		for(int i=0;i<6;i++) {
			label[i]=new JLabel(str[i]);
		}
		jif1.setLayout(new FlowLayout());
		jif2.setLayout(new FlowLayout());
		for(int i=0;i<3;i++) {
			jif1.add(label[i]);
		}
		for(int i=3;i<6;i++) {
			jif2.add(label[i]);
		}
		dp.add(jif1);
		dp.add(jif2);
		jif1.setSize(200, 200);
		jif2.setSize(200, 200);
		jif1.setVisible(true);
		jif2.setVisible(true);
		frame.pack();
		frame.setVisible(true);
		
	}
}
