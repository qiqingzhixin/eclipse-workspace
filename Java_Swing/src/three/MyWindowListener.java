package three;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyWindowListener extends JFrame {
	public MyWindowListener() {
		// TODO Auto-generated constructor stub
		super("���Դ���");
		WindowListener windowlistener= new windowhandler();
		addWindowListener(windowlistener);
		
	}
	class windowhandler extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			JButton button1= new JButton("ȷ��");
			JButton button2 =new JButton("ȡ��");
			JLabel label=new JLabel("��ȷ��Ҫ�ر�ϵͳ��");
			
			JDialog dialog=new JDialog((JFrame)e.getSource(),"ϵͳ�����ˣ�",true);//����
			dialog.setSize(200, 100);
			dialog.setLocation(100,100);
			JPanel panel=new JPanel(new GridLayout(1, 2));
			dialog.add("South", panel);
			dialog.add("Center", label);
			panel.add(button1);
			panel.add(button2);
			dialog.setVisible(true);
		}
	}
	public static void main(String[]args) {
		MyWindowListener mwl=new MyWindowListener();
		mwl.setSize(300,400);
		mwl.setVisible(true);
	}
}
