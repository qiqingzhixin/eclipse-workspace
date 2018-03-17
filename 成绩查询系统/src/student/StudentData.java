package student;

public class StudentData {
	public int flag;//0:Î´ÐÞ¸Ä,1:Ìí¼Ó,2:É¾³ý£¬3:ÐÞ¸Ä
	public String sno;
	public String sname;
	public String sex;
	public int age;
	public String sdept;
	public String logn;
	public String password;
	public StudentData(int flag,String sno,String sname,String sex,int age,String sdept,String logn,String password) {
		this.flag=flag;
		this.sno=sno;
		this.sname=sname;
		this.sex=sex;
		this.age=age;
		this.sdept=sdept;
		this.logn=logn;
		this.password=password;
	}
	public StudentData() {
	}
	public String toString() {
		return "('"+sno+"','"+sname+"','"+sex+"','"+age+"','"+sdept+"','"+logn+"','"+password+"')";
	}
	public static void main(String[]args) {
		StudentData sd=new StudentData(0,"1","2","3",4,"5","6","7");
		String sql=sd.toString();
	}
}
