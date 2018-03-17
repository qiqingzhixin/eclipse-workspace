package four;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

public class MyJList2 {
	public static void main(String[]args) {
		JFrame frame=new JFrame("JList");
		Container contentPane=frame.getContentPane();
		contentPane.setLayout(new GridLayout(1, 3));
		String[] s1= {"美国","日本","大陆","英国","法国","意大利","澳洲","韩国"};
		String[] s2= {"艾二亮","范志毅","伏兵","周宁","杨晨","高峰","南方","其他"};
		String[] s3= {"Nokia 3001","Nokia 8850","Motoroal v8008","Motorola","Panasonic","Panasonic","NecDB2100","Alcatel OT500","Philips Xenium","Ericssson","其他"};
		Vector v=new Vector<String>();
		for(int i=0;i<s3.length;i++) {
			v.addElement(s3[i]);
		}
		JList list1=new JList(s1);
		list1.setBorder(BorderFactory.createTitledBorder("你喜欢哪个国家"));
		JList list2=new JList(s2);
		list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list2.setBorder(BorderFactory.createTitledBorder("你喜欢那个运动员"));
		JList list3=new JList(v);
		list3.setBorder(BorderFactory.createTitledBorder("你喜欢那部手机"));
		list3.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		contentPane.add(new JScrollPane(list1));
		contentPane.add(new JScrollPane(list2));
		contentPane.add(new JScrollPane(list3));
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
