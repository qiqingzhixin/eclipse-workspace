package one;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menutest {
	public static void main(String[]args) {
		JFrame jf=new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300, 200);
		jf.setTitle("ѧ������ϵͳ");
		//��Ӳ˵�
		JMenuBar jmb=new JMenuBar();
		jf.setJMenuBar(jmb);
		//��������˵���
		JMenu jm1=new JMenu("�ļ�");
		JMenu jm2=new JMenu("�༭");
		JMenu jm3=new JMenu("��ͼ");
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		//�˵����
		JMenuItem jmi1=new JMenuItem("��");
		JMenuItem jmi2=new JMenuItem("����");
		JMenuItem jmi3=new JMenuItem("��ӡ");
		JMenuItem jmi4=new JMenuItem("�˳�");
		//��Ӳ˵����
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.addSeparator();
		jm1.add(jmi3);
		jm1.addSeparator();
		jm1.add(jmi4);
		JPanel jp=new JPanel();
		JButton jb=new JButton("����һ�����԰�ť");
		jp.add(jb);
		jf.setContentPane(jp);
		jf.setVisible(true);
				
	}
}
