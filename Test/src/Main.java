import java.awt.AWTException;
import java.awt.Robot;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int n;
		System.out.print("请输入有几个线程:");
		Scanner cin=new Scanner(System.in);
		n=cin.nextInt();
		int [] s=new int [n];
		grn(s,n);
		for(int i=0;i<n;i++) {
			System.out.print(s[i]+"\t");
		}
		xun(s,n);
		System.out.println("\n1.priority\n2+.round robin\n");
		managepcb managepcb=new managepcb(n, s);
		if(cin.nextInt()==1) {
			managepcb.run_pri();
		}else {
			managepcb.run_rou();
		}
	}
	private static void xun(int[] s, int n) {
		// TODO Auto-generated method stub
		int[] s1=new int[n];
		int h=s[0];
		for(int i=0;i<n-1;i++) {
			s1[s[i]-1]=s[i+1];
		}
		for(int i=0;i<n;i++) {
			s[i]=s1[i];
		}
		
	}
	static void grn(int [] ary,int n) {
	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    for (int i = 1; i < n+1; i++) {
	        temp.add(i);
	    }
	    int index = 0;
	    while (true) {
	        if(list.size()==n){
	            break;
	        }
	        int it = temp.get((int) (Math.random() * n));
	        if (list.contains(it)) {
	            continue;
	        } else {
	            ary[index] = it;
	            list.add(it);
	            index++;
	        }
	    }
	}
}
class pcb{
	public int id;
	public int priority;
	public int cuptime;
	public int alltime;
	public int next;
	public char state;
	public pcb(int id,int priority,int cuptime,int alltime,int next,char state) {
		this.id=id;
		this.priority=priority;
		this.cuptime=cuptime;
		this.alltime=alltime;
		this.next=next;
		this.state=state;
	}
	public String toString() {
		String one=id+" "+priority+" "+cuptime+" "+alltime+" "+state+" "+next;
		return one;
	}
}
class managepcb{
	public pcb[] p;//PCB数组
	int n;//有多少个PCB
	int head,tail,run;//等待链表的头，等待链表的尾，运行的PCB
	int [] lian;//在优先级调度中等待链表
	int num;//在优先级中的有多少个进程没有完成
	public managepcb(int n,int[] next) {//PCB的建立和初始化
		this.n=n;
		p=new pcb[n+1];
		for(int i=1;i<=n;i++) {
			Random random=new Random();
			int priority=random.nextInt(20);
			int alltime=random.nextInt(20)+1;
			p[i]=new pcb(i,priority,0,alltime,next[i-1],'W');
		}
		lian=new int[n];
		num=n;
		lian[0]=1;
		for(int i=1;i<n;i++) {
			lian[i]=i+1;
			for(int j=i;j>0;j--) {
				if(p[lian[j]].priority>p[lian[j-1]].priority) {
					int h=lian[j];
					lian[j]=lian[j-1];
					lian[j-1]=h;
				}
			}
		}
	}
	public void run_pri() {//优先级调度算法
		show_pri(0);
		System.out.println();
		while(num!=0) {
			run=lian[0];
			p[run].state='R';
			p[run].alltime--;
			p[run].cuptime++;
			p[run].priority-=3;
			if(p[run].alltime==0) {//一个进程运行完
				p[run].state='F';
				for(int i=1;i<num;i++) {
					lian[i-1]=lian[i];
				}
				num--;
				show_pri(0);
				System.out.println();
			}else {//进程未运行完，时间片运行完
				show_pri(1);
				System.out.println();
				p[run].state='W';
				int i;
				for(i=1;i<num;i++) {
					if(p[run].priority<p[lian[i]].priority) {
						lian[i-1]=lian[i];
					}else {
						lian[i-1]=run;
						break;
					}
				}
				if(i==num) {
					lian[i-1]=run;
				}
			}
		}
		
	}
	public void show_pri(int Num) {//优先级的输出
		System.out.println("========================================================\n"
				+"RUNNING PROC.\tWAITING QUEUE");
		System.out.print("\t\t\t");
		for(int i=Num;i<num;i++) {
			System.out.print(lian[i]+"\t");
		}
		System.out.println("\n========================================================");
		System.out.print("ID\t\t");
		for(int i=1;i<=n;i++) {
			System.out.print(p[i].id+"\t");
		}
		System.out.print("\nPRIORITY\t");
		for(int i=1;i<=n;i++) {
			System.out.print(p[i].priority+"\t");
		}System.out.print("\nCPUTIME\t\t");
		for(int i=1;i<=n;i++) {
			System.out.print(p[i].cuptime+"\t");
		}
		System.out.print("\nALLTIME\t\t");
		for(int i=1;i<=n;i++) {
			System.out.print(p[i].alltime+"\t");
		}
		System.out.print("\nSTATE\t\t");
		for(int i=1;i<=n;i++) {
			System.out.print(p[i].state+"\t");
		}System.out.print("\nNEXT\t\t");
		for(int i=1;i<=n;i++) {
			System.out.print(p[i].next+"\t");
		}
	}
	public void run_rou() {//时间片轮转法
		System.out.println();
		run=(n+1)*n/2;
		for(int i=1;i<=n;i++) {
			run-=p[i].next;
			if(p[i].next==0) {
				tail=i;
			}
		}
		head=p[run].next;
		show_rou(0);
		while(p[run].alltime!=0||p[run].next!=0) {
			p[run].alltime--;
			p[run].cuptime++;
			if(p[run].alltime==0) {
				p[run].state='F';
				show_rou(1);
				run=head;
				if(head!=0) {
					head=p[head].next;
				}else {
					break;
				}
			}else {
				p[run].state='R';
				show_rou(1);
				p[run].state='W';
				p[tail].next=run;
				tail=run;
				p[run].next=0;
				if(head!=0) {
					run=head;
					head=p[head].next;
				}
			}
		}
	}
	public void show_rou(int Num) {
		int h;
		if(Num==0) {
			h=run;
		}else {
			h=head;
		}
		System.out.println("========================================================\nRUNNING ROUND.	WAITING QUEUE");
		System.out.print("\t\t");
		while(h!=0) {
			System.out.print(p[h].id+"\t");
			h=p[h].next;
		}
		System.out.println("\n========================================================");
		System.out.print("ID\t\t");
		for(int i=1;i<=n;i++) {
			System.out.print(p[i].id+"\t");
		}
		System.out.print("\nPRIORITY\t");
		for(int i=1;i<=n;i++) {
			System.out.print(p[i].priority+"\t");
		}System.out.print("\nCPUTIME\t\t");
		for(int i=1;i<=n;i++) {
			System.out.print(p[i].cuptime+"\t");
		}
		System.out.print("\nALLTIME\t\t");
		for(int i=1;i<=n;i++) {
			System.out.print(p[i].alltime+"\t");
		}
		System.out.print("\nSTATE\t\t");
		for(int i=1;i<=n;i++) {
			System.out.print(p[i].state+"\t");
		}System.out.print("\nNEXT\t\t");
		for(int i=1;i<=n;i++) {
			System.out.print(p[i].next+"\t");
		}
		System.out.println();
	}
}