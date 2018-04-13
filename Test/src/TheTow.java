import java.util.Scanner;
public class TheTow {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		//记录位数
		int m=0;
		//存放字符串
		String num="";
		if(n>=0) {
			//取个位数直到剩下一位
			while(n/10!=0) {
				m++;
				num=num+(n%10)+" ";
				n=n/10;
			}
			//可以避免最后一位时空格
			num+=n;
		}else {
			n=-n;
			while(n/10!=0) {
				m++;
				num=num+(n%10)+" ";
				n=n/10;
			}
			m+=1;
			num+=(-n);
		}
		System.out.print(m+" ");
		System.out.println(num);
		
	}
}
