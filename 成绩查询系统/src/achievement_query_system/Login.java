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
		//初始化整个界面
		main_login=new JFrame("系统登录");
		main_login.setBounds(100, 200, 800, 400);
		main_login.setVisible(true);
		main_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭程序
		jp_image=new JPanel();
		//添加一个jpanel 
		main_login.add(jp_image);
		jp_image.setLayout(null);
		//添加图片
		
		
		//添加用户名和密码
		JLabel user_name=new JLabel("用户名:");
		user_name.setFont(new Font("用户名:",20, 20));
		user_name.setBounds(100,20,100,100);
		JLabel user_pass=new JLabel("密码:");
		user_pass.setFont(new Font("",20,20));
		user_pass.setBounds(100,100,100,100);
		jp_image.add(user_name);
		jp_image.add(user_pass);
		
		//添加登录接口和退出
		
	}
}
