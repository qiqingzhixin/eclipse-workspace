package four;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyJList4 {
	static JLabel label;
	static JList list;
	static String[] s= {"石家庄","澳门","重庆","台湾","香港","广州","桂林","秦皇岛"};
	public static void main(String[] args) {
		JFrame frame=new JFrame("MyJList");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane=frame.getContentPane();
		label=new JLabel();
		list=new JList();
		frame.add(label,BorderLayout.NORTH);
		frame.add(new JScrollPane(list), BorderLayout.CENTER);
		list.setVisibleRowCount(5);
		list.setBorder(BorderFactory.createTitledBorder("你最喜欢的地方"));
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int imp=0;
				String stmp="你目前选取:";
				
			}
		});
		
	}
}
