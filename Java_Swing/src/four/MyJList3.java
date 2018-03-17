package four;

import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class MyJList3 {
	public static void main(String[]args) {
		JFrame frame=new JFrame("JList");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane=frame.getContentPane();
		DefaultListModel<String> defaultListModel=new DefaultListModel<>();
		String[] s= {"显示器","键盘","鼠标","转接线","硬盘","U盘","耳机","鼠标垫","电源","光驱"};
		for(int i=0;i<s.length;i++) {
			defaultListModel.addElement((i+1)+"."+s[i]);
		}
		JList list=new JList(defaultListModel);
		list.setVisibleRowCount(5);
		list.setBorder(BorderFactory.createTitledBorder("电脑配件"));
		contentPane.add(new JScrollPane(list));
		frame.pack();
		frame.setVisible(true);
	}
}
