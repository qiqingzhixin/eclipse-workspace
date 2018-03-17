import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class Main_five {

	public static void main(String []args) {
		JFrame jframe=new JFrame("myjframe");//标题
		jframe.setBounds(100,100,300,300);//位置和大小
//		jframe.setBackground(Color.RED);
		jframe.setVisible(true);//是否显示
		Container container=jframe.getContentPane();
		container.setBackground(Color.blue);
		jframe.setContentPane(container);
		
	}
}
