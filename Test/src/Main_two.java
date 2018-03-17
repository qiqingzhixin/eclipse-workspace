import java.io.Console;

public class Main_two {

	public static void main(String [] args) {
		boolean success=false;
		int count=0;
		Console cons;
		cons=System.console();
		System.out.println(cons.toString());
		while(true) {
			System.out.println("请输入密码:");
			count++;
			String pass=new String(cons.readPassword());
			if(pass.equals("I love this game")) {
				success=true;
				System.out.println("第"+count+"次输入正确!");
				break;
			}else {
				System.out.println("第"+count+"次密码："+pass+"不正确");
			}
			if(count==3) {
				System.out.println("您"+count+"次数输入的密码都不正确");
			}
		}
		if(success) {
			System.out.println("你好,欢迎你!");
		}
		
	}
}
