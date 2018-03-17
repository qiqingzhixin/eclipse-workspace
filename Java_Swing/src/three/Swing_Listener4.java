package three;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Swing_Listener4 {
	public static void main(String[]args) {
		new Swing_Listener4();
	}
	JButton b;
	public Swing_Listener4() {
		// TODO Auto-generated constructor stub
		JFrame frame=new JFrame("测试程序");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		b=new JButton("确定");
		b.addActionListener(new action());
		panel.add(b);
		frame.setSize(200,400);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
	class action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			((JButton)arg0.getSource()).setText("取消");
		}
		
	}
}
