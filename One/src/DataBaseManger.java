import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManger {
	String name="shop";
	//MySQL的用户名和密码
	String user="root";
	String password="xiaoliangzhang";
	String url="jdbc:mysql://localhost:3306/"+name+"?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	//数据库驱动
	String driver="com.mysql.jdbc.Driver";
	Connection con;
	ResultSet resultSet=null;
	//对数据操作的对象
	Statement statement;
	public DataBaseManger() {
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void connection() {
		try {
			statement=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 对shop表进行操作
	 */
	//添加一个操作
	public void addShop(ItemShop is) {
		String sql="insert into shop values"+is.toString();
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//删除一个操作
	public void deleteShop(ItemShop is) {
		String sql="delete from shop sno='"+is.sno+"'";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//修改一个操作
	public void changeShop(ItemShop is) {
		deleteShop(is);
		addShop(is);
	}
	public String[][] getShop(String classification){
		String sqlCount="select count(*) from shop where classification='"+classification+"'";
		String sql="select *from shop where classification='"+classification+"'";
		String[][]one=null;
		try {
			resultSet=statement.executeQuery(sqlCount);
			resultSet.next();
			one=new String[resultSet.getInt(1)][];
			resultSet=statement.executeQuery(sql);
			for(int i=0;resultSet.next();i++) {
				one[i]=new String[8];
				for(int j=1;j<=8;j++) {
					one[i][j-1]=resultSet.getString(j);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return one;
	}
	public void main(String[] args) {
		DataBaseManger dbm=new DataBaseManger();
		dbm.connection();
		ItemShop is=new ItemShop("1230","美美",80,2000,(float)3.0,(float)4.4,"12345","美食");
	}
	
}
