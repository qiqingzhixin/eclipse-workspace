import java.util.Scanner;
public class TheTow {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		//��¼λ��
		int m=0;
		//����ַ���
		String num="";
		if(n>=0) {
			//ȡ��λ��ֱ��ʣ��һλ
			while(n/10!=0) {
				m++;
				num=num+(n%10)+" ";
				n=n/10;
			}
			//���Ա������һλʱ�ո�
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
