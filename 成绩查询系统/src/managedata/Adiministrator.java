package managedata;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Adiministrator {
	JFrame jf;
	JTabbedPane jtp;
	StudentInformation si;
	CourseInfromation ci;
	InputScore is;
	public Adiministrator() {
		jf=new JFrame("����ϵͳ");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jtp=new JTabbedPane(JTabbedPane.LEFT);
		jf.setContentPane(jtp);
		si=new StudentInformation();
		ci=new CourseInfromation();
		is=new InputScore();
		jtp.add("ѧ������", si.getPanel());
		jtp.add("�γ̹���", ci.getJPanel());
		jtp.add("�ɼ�����", is.getJPanel());
		jf.setContentPane(jtp);
		jf.setSize(800,500);
		jf.setLocation(200, 200);
		jf.setVisible(true);
	}
	public static void main(String[]args) {
		new Adiministrator();
	}
}
