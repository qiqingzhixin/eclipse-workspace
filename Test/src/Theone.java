import java.util.Scanner;
import java.util.regex.Pattern;

public class Theone {
	public static void main(String[] args) {
		//模式串全是字母或者汉字
		String patter="^[a-zA-Z0-9]*$";
		//建立模式串
		Pattern pattern=Pattern.compile(patter);
		//输入
		Scanner scannce=new Scanner(System.in);
		String inputString=scannce.nextLine();
		//对文字做处理
		if(inputString.length()<=20&&pattern.matches(patter,inputString)) {
			//条件成立
			String deal="";
			for(int i=0;i<inputString.length();i+=2) {
				deal+=inputString.charAt(i);
			}
			System.out.println(deal);
		}else {
			//条件不成立
			System.out.println("ERROR!");
		}
	}
	
}
