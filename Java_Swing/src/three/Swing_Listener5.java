package three;

import java.awt.List;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Swing_Listener5 extends JFrame implements FocusListener{
	private static final long serialVersionUID = 1L;
	List info=new List(10);
	JTextField textField=new JTextField();
	JButton button=new JButton("ȷ��");
	public Swing_Listener5(String str) {
		// TODO Auto-generated constructor stub
		super(str);
		add(info,"North");
		add(textField,"Center");
		add(button,"South");
		info.addFocusListener(this);
		
	}
	public static void main(String[]args) {
		Swing_Listener5 sl=new Swing_Listener5("���Գ���");
		sl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sl.pack();
		sl.setLocation(300, 300);
		sl.setVisible(true);
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.isTemporary()) {
			info.add("��ʱ�Ի��");
		}else {
			info.add("�����Ի��");
		}
		
	}
	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.isTemporary()) {
			info.add("��ʱ��ʧȥ");
		}else {
			info.add("������ʧȥ");
		}
	}
}
