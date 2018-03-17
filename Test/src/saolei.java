import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class saolei {
	public static void main(String[]args) {
		JFrame jf=new JFrame("É¨À×");
		jf.setSize(450,450);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp=new JPanel(null);
		jf.setContentPane(jp);
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				JButton jb=new JButton();
				jp.add(jb);
				jb.setBounds(i*20, j*20, 20, 20);
			}
		}
		jf.setVisible(true);
	}
}
