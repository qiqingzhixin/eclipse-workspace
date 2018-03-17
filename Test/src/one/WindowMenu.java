package one;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class WindowMenu {
	JMenuBar menubar;//菜单栏
	JMenu menu,subMenu;//菜单项
	JMenuItem item1,item2;//每一项
	JFrame jframe;//窗口
	public WindowMenu() {
		
	}
	public WindowMenu(String s,int x,int y,int w,int h) {
		init(s);
		jframe.setBounds(x,y,w,h);//设置窗口大小
		jframe.setVisible(true);//设置窗口是否可见
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭状态
	}
	void init(String s) {
		jframe=new JFrame(s);
		menubar=new JMenuBar();
		menu=new JMenu("菜单");
		subMenu=new JMenu("软件项目");
		item1=new JMenuItem("Java 话题");
		item2=new JMenuItem("动画话题");
		item1.setAccelerator(KeyStroke.getKeyStroke('A'));//设置快捷键
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		menu.add(item1);//添加一项
		menu.addSeparator();//添加分割线
		menu.add(item2);//再添加一项
		menu.add(subMenu);//添加子菜单栏
		subMenu.add(new JMenuItem("汽车销售系统"));//添加一项
		subMenu.add(new JMenuItem("农场信息系统"));//添加一项
		menubar.add(menu);//向菜单栏中添加一项菜单项
		menubar.add(new JMenu("one"));//
		jframe.setJMenuBar(menubar);//设置菜单栏
		
		
	}
}
