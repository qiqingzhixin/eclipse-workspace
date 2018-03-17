package three;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Swing_Listener {
	static JTextField tf;
	static int width=300,height=200;
	public static void main(String[] args) {
		JFrame frame=new JFrame("测试程序");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		frame.setContentPane(panel);
		JButton button=new JButton("确定");
		ActionListener ac=new ActionHande();
		button.addActionListener(ac);
		tf=new JTextField(20);
		tf.setText("点击确定清空文本");
		panel.add("North", tf);
		panel.add("South",button);
		frame.setBounds(200, 200, width, height);
		frame.setVisible(true);
	}
}

class ActionHande implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		new Swing_Listener().tf.setText("");
	}
	
}
