package two;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class MyJSplitPane {
	public static void main(String[] args) {
		JButton jb1=new JButton("确定");
		JButton jb2=new JButton("取消");
		JSplitPane js=new JSplitPane();
		js.setOneTouchExpandable(true);
		js.setContinuousLayout(true);
		js.setPreferredSize(new Dimension(100,200));
		js.setOrientation(JSplitPane.VERTICAL_SPLIT);
		js.setLeftComponent(jb1);
		js.setRightComponent(jb2);
		js.setDividerSize(8);
		js.setDividerLocation(96);
		JFrame jf=new JFrame("JSplitPane");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setContentPane(js);
		jf.pack();
		//得到屏幕的尺寸
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension di=tk.getScreenSize();
		int w=di.width;
		int h=di.height;
		int jf_w=(w-100)/2;
		int jf_h=(h-200)/2;
		jf.setLocation(jf_w, jf_h);
		jf.setVisible(true);
	}
}
