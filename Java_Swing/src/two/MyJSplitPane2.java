package two;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class MyJSplitPane2 {
	public static void main(String[]args) {
		String[] name= {"确定","取消","优秀","良好"};
		JButton[] jb=new JButton[4];
		for(int i=0;i<4;i++) {
			jb[i]=new JButton(name[i]);
		}
		JPanel p1=new JPanel(new FlowLayout());
		JPanel p2=new JPanel(new FlowLayout());
		p1.add(jb[0]);
		p1.add(jb[1]);
		p2.add(jb[2]);
		p2.add(jb[3]);
		JSplitPane js=new JSplitPane();
		js.setLeftComponent(p1);
		js.setRightComponent(p2);
		js.setPreferredSize(new Dimension(50, 100));
		js.setDividerSize(6);
		js.setDividerLocation(97);
		js.setOneTouchExpandable(true);
		JFrame jf=new JFrame("测试程序");
		jf.setContentPane(js);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension di=tk.getScreenSize();
		int jf_w=(di.width-100)/2;
		int jf_h=(di.height-200)/2;
		jf.setLocation(jf_w, jf_h);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
	}
}
