import java.util.Scanner;
import java.util.regex.Pattern;

public class Theone {
	public static void main(String[] args) {
		//ģʽ��ȫ����ĸ���ߺ���
		String patter="^[a-zA-Z0-9]*$";
		//����ģʽ��
		Pattern pattern=Pattern.compile(patter);
		//����
		Scanner scannce=new Scanner(System.in);
		String inputString=scannce.nextLine();
		//������������
		if(inputString.length()<=20&&pattern.matches(patter,inputString)) {
			//��������
			String deal="";
			for(int i=0;i<inputString.length();i+=2) {
				deal+=inputString.charAt(i);
			}
			System.out.println(deal);
		}else {
			//����������
			System.out.println("ERROR!");
		}
	}
	
}
