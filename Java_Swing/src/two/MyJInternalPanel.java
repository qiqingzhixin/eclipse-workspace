package two;

import java.awt.FlowLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyJInternalPanel {
	public static void main(String[] args) {
		String[] str= {"�����ҵ�һ������","��Ҳ�����һ������","��ͬʱҲ������һ������","����ҵڶ�������","��Ҳ����ڶ�������","��ͬʱҲ�����ڶ�������"};
		JFrame frame=new JFrame("MyJInternalPane");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel  panel=new JPanel(new FlowLayout());
		frame.setContentPane(panel);
		JDesktopPane dp=new JDesktopPane();
		dp.setLayout(new FlowLayout());
		panel.add(dp);
		
		JInternalFrame jif1=new JInternalFrame("��һ������", true, true, true);
		JInternalFrame jif2=new JInternalFrame("�ڶ�������",true,true,true);
		JLabel[] label=new JLabel[6];
		for(int i=0;i<6;i++) {
			label[i]=new JLabel(str[i]);
		}
		jif1.setLayout(new FlowLayout());
		jif2.setLayout(new FlowLayout());
		for(int i=0;i<3;i++) {
			jif1.add(label[i]);
		}
		for(int i=3;i<6;i++) {
			jif2.add(label[i]);
		}
		dp.add(jif1);
		dp.add(jif2);
		jif1.setSize(200, 200);
		jif2.setSize(200, 200);
		jif1.setVisible(true);
		jif2.setVisible(true);
		frame.pack();
		frame.setVisible(true);
		
	}
}
