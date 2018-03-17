package two;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyLayout {
	public static void main(String[] args) {
		//����һ������
		JFrame jf=new JFrame("���Գ���");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300, 200);
		//����һ�����
		JPanel jp=new JPanel();
		jf.setContentPane(jp);
		JButton [] jb=new JButton[35];
		for(int i=0;i<35;i++) {
			jb[i]=new JButton("button"+i);
		}
		GridLayout gl=new GridLayout(3, 3);
		jf.setLayout(gl);//��������ó�һ�������
		JPanel[] jp_array=new JPanel[7];
		int n=0;
		for(int i=0;i<7;i++) {
			jp_array[i]=new JPanel();
			if(i==2) {
				jp_array[i].setLayout(new FlowLayout());//����Ϊ������
				jp_array[i].add(jb[n++]);
				jp_array[i].add(jb[n++]);
				jp_array[i].add(jb[n++]);
				jp_array[i].add(jb[n++]);
				jp_array[i].add(jb[n++]);
			}else {
				jp_array[i].setLayout(new BorderLayout());//���������в���
				//�򲼾�����Ӱ�ť
				jp_array[i].add(jb[n++],"North");
				jp_array[i].add(jb[n++],"West");
				jp_array[i].add(jb[n++], "South");
				jp_array[i].add(jb[n++],"East");
				jp_array[i].add(jb[n++], "Center");
			}
			jp.add(jp_array[i]);
		}
		jf.pack();//���ڴ��ڵĴ�С
		jf.setVisible(true);//��ʾ������
		
		
	}

}
