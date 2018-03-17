import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;


public class DataBaseManage {
	String user="root";
	String password="xiaoliangzhang";
	//一定存在的database
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	String url="jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	//数据库驱动
	String driver="com.mysql.jdbc.Driver";
	//对数据操作的对象
	java.sql.Statement statement;
	//学生数据信息 查询对象
	ResultSet resultSet;
	public DataBaseManage() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			statement=con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//对商店表进行插入
	/**
	 * 
	 * @param sno
	 * @param sname
	 * @param evalute
	 * @param msales
	 * @param d
	 * @param f
	 * @param idpicture
	 * @param classification
	 */
	public void addFood(String fno,String fname,int evalute ,int msales, double  price,String sno,String idpicture,String classification) {
		String sql="insert into food values('"+fno+"','"+fname+"','"+evalute+"','"+msales+"','"+price+"','"+sno+"','"+idpicture+"','"+classification+"')";
		System.out.println(sql);
		try {
			statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//查 按照类别查找
	public String[][] findFood(String classification){
		String sql="select*from food where classification='"+classification+"'";
		String sqlCount="select count(*) from food where classification='"+classification+"'";
		System.out.println(sqlCount);
		String[][] item=null;
		System.out.println(sql);
		try {
			resultSet=statement.executeQuery(sqlCount);
			resultSet.next();
			int size=resultSet.getInt(1);
			System.out.println(size);
			item=new String[size][];
			resultSet=statement.executeQuery(sql);
			for(int i=0;resultSet.next();i++) {
				item[i]=new String[8];
				for(int j=0;j<8;j++) {
					item[i][j]=resultSet.getString(j+1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}
	//删除
	public void deleteFood(String sno) {
		String sql="delete from food where sno='"+sno+"'";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//改
	public void changeFood(String fno,String fname,int evalute ,int msales, double  price,String sno,String idpicture,String classification) {
		deleteFood(sno);
		addFood(fno, fname, evalute, msales, price, sno, idpicture, classification);
	}
	
	//增
	public void addShop(String sno,String sname,int evalute ,int msales, double  d,double f,String idpicture,String classification) {
		String sql="insert into shop values('"+sno+"','"+sname+"','"+evalute+"','"+msales+"','"+d+"','"+f+"','"+idpicture+"','"+classification+"')";
		System.out.println(sql);
		try {
			statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//查 按照类别查找
	public String[][] findShop(String classification){
		String sql="select*from shop where classification='"+classification+"'";
		String sqlCount="select count(*) from shop where classification='"+classification+"'";
		System.out.println(sqlCount);
		String[][] item=null;
		System.out.println(sql);
		try {
			resultSet=statement.executeQuery(sqlCount);
			resultSet.next();
			int size=resultSet.getInt(1);
			System.out.println(size);
			item=new String[size][];
			resultSet=statement.executeQuery(sql);
			for(int i=0;resultSet.next();i++) {
				item[i]=new String[8];
				for(int j=0;j<8;j++) {
					item[i][j]=resultSet.getString(j+1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}
	//删除
	public void deleteShop(String sno) {
		String sql="delete from shop where sno='"+sno+"'";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//改
	public void changeShop(String sno,String sname,int evalute ,int msales, double  d,double f,String idpicture,String classification) {
		deleteShop(sno);
		addShop(sno, sname, evalute, msales, d, f, idpicture, classification);
	}
	
	public static void main(String[]args) {
		
		DataBaseManage dbm=new DataBaseManage();
		Random ran=new Random();
		for(int i =0;i<800;i++) {
			String fno=getNo(i);
			String sname=getFoodName();
			int evalute=(ran.nextInt()%100+100)%100;
			int msales=(ran.nextInt()%5000+5000)%5000;
			double d=(ran.nextDouble()%5+5)%5;
			double f=(ran.nextDouble()%10+10)%10;
			String idpicture=getPath();
			String classification=getClassifity();
			String sno=getShopNo();
			
			dbm.addFood(fno, sname, evalute, msales, f, sno,idpicture, classification);
//			dbm.addShop(fno, sname, evalute, msales, d, f, idpicture, classification);
		}
	}
	public static String getNo(int i) {
		String str=null;
		if(i<10) {
			str="000"+i;
		}else if(i<100) {
			str="00"+i;
		}else if(i<1000) {
			str="0"+i;
		}
		return str;
	}
	public static String getShopName() {
		String[] str1= {"河北","山东","上海","云南","安徽","浙江","昆明","深圳","乌鲁木齐"};
		String[] str2= {"饺子","大饼","牛肉面","拉面","火锅","米粉","雪糕","炒饼","烧烤","冒菜","焖鸡"};
		String[] str3= {"馆","摊","屋","厅"};
		Random random=new Random();
		int n=random.nextInt();
		if(n<0) {
			n=-n;
		}
		int m=random.nextInt();
		if(m<0) {
			m=-m;
		}
		int h=random.nextInt();
		if(h<0) {
			h=-h;
		}
		return str1[n%9]+str2[m%11]+str3[h%4];
	}
	public static String getPath() {
		Random ra=new Random();
		int n=ra.nextInt();
		if(n<0) {
			n=-n;
		}
		n=n%81+1;
		String str="D:/food/"+"bb1 ("+n+").gif";
//		String str="D:/picture/"+"ab1 ("+n+").gif";
		return str;
	}
	public static String getClassifity() {
		String[] str= {"精品炒饭","辣区","特辣区","甜品类","养生类","汤粉类","炒面类","凉菜"};
//		String[] str= {"美食","早餐","水果","饮品"};
		Random ra=new Random();
		int n=ra.nextInt();
		if(n<0) {
			n=-n;
		}
		n=n%8;
		return str[n];
	}
	public static String getShopNo() {
//		String[] str= {"美食","早餐","水果","饮品"};
		Random ra=new Random();
		int n=ra.nextInt();
		if(n<0) {
			n=-n;
		}
		n=n%100;
		return getNo(n);
	}
	public static String getFoodName() {
		String[] str1= {"河北","山东","上海","云南","安徽","浙江","昆明","深圳","乌鲁木齐"};
		String[] str2= {"饺子","大饼","牛肉面","拉面","火锅","米粉","雪糕","炒饼","烧烤","冒菜","焖鸡"};
		Random random=new Random();
		int n=random.nextInt();
		if(n<0) {
			n=-n;
		}
		int m=random.nextInt();
		if(m<0) {
			m=-m;
		}
		return str1[n%9]+str2[m%11];
	}
}
