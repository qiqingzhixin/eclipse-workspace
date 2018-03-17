package two;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyLayout {
	public static void main(String[] args) {
		//创建一个窗口
		JFrame jf=new JFrame("测试程序");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300, 200);
		//创建一个面板
		JPanel jp=new JPanel();
		jf.setContentPane(jp);
		JButton [] jb=new JButton[35];
		for(int i=0;i<35;i++) {
			jb[i]=new JButton("button"+i);
		}
		GridLayout gl=new GridLayout(3, 3);
		jf.setLayout(gl);//将面板设置成一个网格的
		JPanel[] jp_array=new JPanel[7];
		int n=0;
		for(int i=0;i<7;i++) {
			jp_array[i]=new JPanel();
			if(i==2) {
				jp_array[i].setLayout(new FlowLayout());//布局为流布局
				jp_array[i].add(jb[n++]);
				jp_array[i].add(jb[n++]);
				jp_array[i].add(jb[n++]);
				jp_array[i].add(jb[n++]);
				jp_array[i].add(jb[n++]);
			}else {
				jp_array[i].setLayout(new BorderLayout());//东南西北中布局
				//向布局中添加按钮
				jp_array[i].add(jb[n++],"North");
				jp_array[i].add(jb[n++],"West");
				jp_array[i].add(jb[n++], "South");
				jp_array[i].add(jb[n++],"East");
				jp_array[i].add(jb[n++], "Center");
			}
			jp.add(jp_array[i]);
		}
		jf.pack();//调节窗口的大小
		jf.setVisible(true);//显示出窗口
		
		
	}

}
