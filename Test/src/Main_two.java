import java.io.Console;

public class Main_two {

	public static void main(String [] args) {
		boolean success=false;
		int count=0;
		Console cons;
		cons=System.console();
		System.out.println(cons.toString());
		while(true) {
			System.out.println("����������:");
			count++;
			String pass=new String(cons.readPassword());
			if(pass.equals("I love this game")) {
				success=true;
				System.out.println("��"+count+"��������ȷ!");
				break;
			}else {
				System.out.println("��"+count+"�����룺"+pass+"����ȷ");
			}
			if(count==3) {
				System.out.println("��"+count+"������������붼����ȷ");
			}
		}
		if(success) {
			System.out.println("���,��ӭ��!");
		}
		
	}
}
