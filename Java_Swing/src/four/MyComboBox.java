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
		String[]s= {"�һ�","÷��","õ��","ĵ��","�¼�","����","�ջ�","ӣ��"};
		String[]name= {"С��","С÷","С��","С��","С��","СĪ"};
		Vector<String> v=new Vector();
		for(int i=0;i<name.length;i++) {
			v.addElement(name[i]);
		}
		JComboBox<String> comboBox=new JComboBox<>(s);
		comboBox.addItem("ӳɽ��");
		comboBox.setBorder(BorderFactory.createTitledBorder("����ϲ���Ļ�"));
		JComboBox<String>comboBox2=new JComboBox<>(v);
		comboBox2.setBorder(BorderFactory.createTitledBorder("����õ�����"));
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
