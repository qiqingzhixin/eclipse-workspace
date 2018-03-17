package three;

import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Swing_Listener3 {
	public static void main(String[]args) {
		JFrame frame=new JFrame("测试程序");
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				JButton button1=new JButton("确定");
				JButton button2=new JButton("取消");
				JLabel label=new JLabel("你确定关闭系统吗？");
				JDialog d=new JDialog((JFrame)arg0.getSource(),"系统出错！",true);
				d.setSize(200,100);
				d.setLocation(350, 400);
				JPanel panel=new JPanel();
				panel.setLayout(new GridLayout(1,2));
				d.add("Center",label);
				d.add("South",panel);
				panel.add(button1);
				panel.add(button2);
				d.setVisible(true);
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		frame.setBounds(200, 200, 500, 500);
		
		frame.setVisible(true);
	}
}
