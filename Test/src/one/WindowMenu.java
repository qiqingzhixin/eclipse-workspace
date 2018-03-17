package one;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class WindowMenu {
	JMenuBar menubar;//�˵���
	JMenu menu,subMenu;//�˵���
	JMenuItem item1,item2;//ÿһ��
	JFrame jframe;//����
	public WindowMenu() {
		
	}
	public WindowMenu(String s,int x,int y,int w,int h) {
		init(s);
		jframe.setBounds(x,y,w,h);//���ô��ڴ�С
		jframe.setVisible(true);//���ô����Ƿ�ɼ�
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//�ر�״̬
	}
	void init(String s) {
		jframe=new JFrame(s);
		menubar=new JMenuBar();
		menu=new JMenu("�˵�");
		subMenu=new JMenu("�����Ŀ");
		item1=new JMenuItem("Java ����");
		item2=new JMenuItem("��������");
		item1.setAccelerator(KeyStroke.getKeyStroke('A'));//���ÿ�ݼ�
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		menu.add(item1);//���һ��
		menu.addSeparator();//��ӷָ���
		menu.add(item2);//�����һ��
		menu.add(subMenu);//����Ӳ˵���
		subMenu.add(new JMenuItem("��������ϵͳ"));//���һ��
		subMenu.add(new JMenuItem("ũ����Ϣϵͳ"));//���һ��
		menubar.add(menu);//��˵��������һ��˵���
		menubar.add(new JMenu("one"));//
		jframe.setJMenuBar(menubar);//���ò˵���
		
		
	}
}
