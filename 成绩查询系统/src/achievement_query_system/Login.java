package achievement_query_system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

public class Login {
	JFrame main_login;
	JPanel jp_image;
	JPanel jp_text;
	JPanel jp_button;
	public Login() {
		//��ʼ����������
		main_login=new JFrame("ϵͳ��¼");
		main_login.setBounds(100, 200, 800, 400);
		main_login.setVisible(true);
		main_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رճ���
		jp_image=new JPanel();
		//���һ��jpanel 
		main_login.add(jp_image);
		jp_image.setLayout(null);
		//���ͼƬ
		
		
		//����û���������
		JLabel user_name=new JLabel("�û���:");
		user_name.setFont(new Font("�û���:",20, 20));
		user_name.setBounds(100,20,100,100);
		JLabel user_pass=new JLabel("����:");
		user_pass.setFont(new Font("",20,20));
		user_pass.setBounds(100,100,100,100);
		jp_image.add(user_name);
		jp_image.add(user_pass);
		
		//��ӵ�¼�ӿں��˳�
		
	}
}
