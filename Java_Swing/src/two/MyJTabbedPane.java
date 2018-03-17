package two;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MyJTabbedPane {
	public static void main(String[] args) {
		String[] name= {"个人收入","工资","奖金","津贴","社保"};
		JFrame jf=new JFrame("JTabbedpane");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocation(200, 200);
		JTabbedPane jt=new JTabbedPane(JTabbedPane.LEFT);
		jf.setContentPane(jt);
		JPanel[] jp=new JPanel[5];
		for(int i=0;i<5;i++) {
			jp[i]=new JPanel();
		}
		for(int i=0;i<5;i++) {
			jt.add("panel"+i, jp[i]);
			jt.setTitleAt(i,name[i]);
			jt.setEnabledAt(i, true);
		}
		jt.setPreferredSize(new Dimension(500, 200));
		jt.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		jf.pack();
		jf.setVisible(true);
		
	}
}
