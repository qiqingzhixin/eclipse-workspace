package managedata;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import student.StudentData;

public class MyTable extends JTable{
//	public static void main(String[]args) {
//		JFrame frame=new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		JPanel jp=new JPanel(new BorderLayout());
//		frame.setContentPane(jp);
//		Object[][] one= {
//				{1,1,1,1,1,1},
//				{2,2,2,2,2,2},
//				{3,3,3,3,3,3},
//				{4,4,4,4,4,4}
//		};
//		String[] title= {
//				"ѧ��","2","3","4","5","6"
//		};
//		MyTable table=new MyTable(one,title);
//		jp.add(new JScrollPane(table),BorderLayout.CENTER);
//		frame.pack();
//		frame.setVisible(true);
//	}
	DefaultTableModel defaultTableModel;
	public MyTable(Object[][] one,String[] two) {
		// TODO Auto-generated constructor stub
		super(one,two);
	}
	public MyTable(DefaultTableModel dtm) {
		super(dtm);
	}
	//��дJtbale���getDefaultRenderer(Class<?>columnClass)����
    public TableCellRenderer getDCellRenderer(Class<?> columnClass){//���嵥Ԫ��
        DefaultTableCellRenderer cr=(DefaultTableCellRenderer)super
                .getDefaultRenderer(columnClass);//��ñ��ĵ�Ԫ�����
        cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);//���õ�Ԫ�����ݾ�����ʾ
        return cr;
         
    }
    //��дJtable���isCellEditable(int row,int column)����
    public boolean isCellEditable(int row,int column){//��񲻿ɱ༭
        return false;
    }
}
