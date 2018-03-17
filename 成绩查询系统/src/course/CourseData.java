package course;

public class CourseData {
	public int flag;//
	public String cno;
	public String cname;
	public int credit;
	public String cdept;
	public String tname;
	public CourseData() {
		
	}
	public CourseData(int flag,String cno,String cname,int credit,String cdept,String tname) {
		this.flag=flag;//0:Î´ÐÞ¸Ä,1:Ìí¼Ó,2:É¾³ý,3:ÐÞ¸Ä
		this.cno=cno;
		this.cname=cname;
		this.credit=credit;
		this.cdept=cdept;
		this.tname=tname;
	}
	public CourseData(int flag,String cno,String cname,String credit,String cdept,String tname) {
		this.flag=flag;
		this.cno=cno;
		this.cname=cname;
		this.credit=Integer.valueOf(credit);
		this.cdept=cdept;
		this.tname=tname;
	}
	public String toString() {
		return "('"+cno+"','"+cname+"','"+credit+"','"+cdept+"','"+tname+"')";
	}
	public static void main(String[]args) {
		CourseData cd=new CourseData(1,"1","1","1","1","1");
		System.out.println(cd);
	}
}
