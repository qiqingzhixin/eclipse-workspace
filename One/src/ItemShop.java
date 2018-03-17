
public class ItemShop {
	public String sno;
	public String sname;
	public int evalute;
	public int msales;
	public float distribution;
	public float ssales;
	public String idpicture;
	public String classification;
	public String toString() {
		return "('"+sno+"','"+sname+"',"+evalute+","+msales+","+distribution+","+ssales+",'"+idpicture+"','"+classification+"')";
	}
	public ItemShop() {
		
	}
	public ItemShop(String sno,String sname,int evalute,int msales,float distribution,float ssales,String idpicture,String classification) {
		this.sno=sno;
		this.sname=sname;
		this.evalute=evalute;
		this.distribution=distribution;
		this.msales=msales;
		this.ssales=ssales;
		this.idpicture=idpicture;
		this.classification=classification;
	}
	public String[] getItemShop() {
		String[] one=new String[5];
		one[0]=sname;
		one[1]=Integer.toString(evalute);
		one[2]=Integer.toString(msales);
		one[3]=Float.toString(ssales);
		one[4]=Float.toString(distribution);
		return one;
	}
	public static void main(String[] args) {
		ItemShop is=new ItemShop();
		is.sno="123";
		is.sname="—Û—Û";
		is.evalute=4;
		is.msales=(int) 3;
		is.distribution=(float)5;
		is.ssales=(float) 4.4;
		is.idpicture="lujin";
		is.classification="√¿ ≥";
		System.out.println(is);
	}
}
