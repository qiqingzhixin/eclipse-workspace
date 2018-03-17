package four;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.xml.bind.util.ValidationEventCollector;

public class MyComboBox {
	public static void main(String[]args) {
		JFrame jf=new JFrame("JComboBox");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp=new JPanel(new GridLayout(1, 2));
		String[]s= {"桃花","梅花","玫瑰","牡丹","月季","茉莉","菊花","樱花"};
		String[]name= {"小桃","小梅","小牧","小丹","小月","小莫"};
		Vector<String> v=new Vector();
		for(int i=0;i<name.length;i++) {
			v.addElement(name[i]);
		}
		JComboBox<String> comboBox=new JComboBox<>(s);
		comboBox.addItem("映山红");
		comboBox.setBorder(BorderFactory.createTitledBorder("你最喜欢的花"));
		JComboBox<String>comboBox2=new JComboBox<>(v);
		comboBox2.setBorder(BorderFactory.createTitledBorder("你最好的朋友"));
		jp.add(comboBox);
		jp.add(comboBox2);
		jf.setContentPane(jp);
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(comboBox.getSelectedIndex());
				System.out.println((String)comboBox.getSelectedItem());
			}
		});
		jf.pack();
		jf.setVisible(true);
	}
}
