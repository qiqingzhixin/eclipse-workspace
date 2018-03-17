package one;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menutest {
	public static void main(String[]args) {
		JFrame jf=new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300, 200);
		jf.setTitle("学生管理系统");
		//添加菜单
		JMenuBar jmb=new JMenuBar();
		jf.setJMenuBar(jmb);
		//添加三个菜单项
		JMenu jm1=new JMenu("文件");
		JMenu jm2=new JMenu("编辑");
		JMenu jm3=new JMenu("视图");
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		//菜单组件
		JMenuItem jmi1=new JMenuItem("打开");
		JMenuItem jmi2=new JMenuItem("保存");
		JMenuItem jmi3=new JMenuItem("打印");
		JMenuItem jmi4=new JMenuItem("退出");
		//添加菜单组件
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.addSeparator();
		jm1.add(jmi3);
		jm1.addSeparator();
		jm1.add(jmi4);
		JPanel jp=new JPanel();
		JButton jb=new JButton("这是一个测试按钮");
		jp.add(jb);
		jf.setContentPane(jp);
		jf.setVisible(true);
				
	}
}
