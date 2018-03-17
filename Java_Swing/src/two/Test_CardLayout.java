package two;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class MyCard extends JFrame{
	private JPanel jp;
	private JPanel p;
	private JButton bu;
	private JButton bd;
	private JButton[] b;
	private JPanel [] p1;
	private CardLayout card;
	private int n;
	private ActionListener actionListener;
	public MyCard() {
		super("CardLayout text");
//		try {
//			UIManager.setLookAndFeel("com.sum.java.swing.plaf.windows.WindowsLookAndFeel");
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//				| UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		card=new CardLayout(5,5);
		jp=new JPanel(card);
		p=new JPanel();
		bu=new JButton("上一步");
		bd=new JButton("下一步");
		b=new JButton[3];
		p.add(bu);
		for(int i=0;i<3;i++) {
			b[i]=new JButton(""+(i+1));
			b[i].setMargin(new Insets(2, 2, 2, 2));
			p.add(b[i]);
		}
		p.add(bd);
		p1=new JPanel[3];
		Color[] color= {Color.RED,Color.YELLOW,Color.GREEN};
		for(int i=0;i<3;i++) {
			p1[i]=new JPanel();
			p1[i].setBackground(color[i]);
			p1[i].add(new JLabel("JPanel_"+(1+i)));
			jp.add(p1[i],"p"+(1+i));
		}
		bu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				card.previous(jp);
				System.out.println("hello world");
			}
		});
		bd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				card.next(jp);
			}
		});
		for(int i=0;i<3;i++) {
			b[i].addActionListener(new myActionListener());
		}
		this.getContentPane().add(jp);
		this.getContentPane().add(p, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,200);
		this.setVisible(true);
		
	}
	class myActionListener implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.print(arg0.getActionCommand());
			card.show(jp, "p"+arg0.getActionCommand());
		}
		
	}
}
public class Test_CardLayout {
	public static void main(String[] args) {
		System.out.print("ehllowo");
		MyCard mycard=new MyCard();
	}
}
