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
		jf=new JFrame("管理系统");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jtp=new JTabbedPane(JTabbedPane.LEFT);
		jf.setContentPane(jtp);
		si=new StudentInformation();
		ci=new CourseInfromation();
		is=new InputScore();
		jtp.add("学生管理", si.getPanel());
		jtp.add("课程管理", ci.getJPanel());
		jtp.add("成绩管理", is.getJPanel());
		jf.setContentPane(jtp);
		jf.setSize(800,500);
		jf.setLocation(200, 200);
		jf.setVisible(true);
	}
	public static void main(String[]args) {
		new Adiministrator();
	}
}
