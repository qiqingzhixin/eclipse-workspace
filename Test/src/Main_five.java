import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class Main_five {

	public static void main(String []args) {
		JFrame jframe=new JFrame("myjframe");//����
		jframe.setBounds(100,100,300,300);//λ�úʹ�С
//		jframe.setBackground(Color.RED);
		jframe.setVisible(true);//�Ƿ���ʾ
		Container container=jframe.getContentPane();
		container.setBackground(Color.blue);
		jframe.setContentPane(container);
		
	}
}
