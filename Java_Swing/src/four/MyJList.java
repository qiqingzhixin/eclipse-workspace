package four;

import java.awt.BorderLayout;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyJList {
	public static void main(String[]args) {
		JFrame frame=new JFrame("���Գ���");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocation(300, 300);
		JPanel panel=new JPanel(new BorderLayout());
		frame.setContentPane(panel);
		String[] name= {"����","����","����","����","С��","С��","С��","С��"};
		JList list=new JList(name);
		JTextField textField=new JTextField();
		panel.add("South",textField);
		panel.add("North", list);
		frame.setVisible(true);
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					textField.setText((String)list.getSelectedValue());
				}
			}
		});
		thread.start();
	}
}
