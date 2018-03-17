package test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Main {
	public static void main(String[] args) {
		Connection con;
		//驱动名字
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/school";
		//用户名和密码
		String user="root";
		String password="xiaoliangzhang";
		try {
			Class.forName(driver);
			//连接数据库
			con=(Connection) DriverManager.getConnection(url, user, password);
			if(!con.isClosed()) {
				System.out.println("Succeede connection to the Datdase!");
				Statement statement=(Statement) con.createStatement();
				String sql="select*from S";
				ResultSet rs=statement.executeQuery(sql);
				System.out.println("--------------------------");
				System.out.println("执行结果如下所示：");
				String xh =null;
				String xm=null;
				while(rs.next()) {
					xh=rs.getString("xh");
					xm=rs.getString("xm");
					System.out.println(xh+"\t"+xm);
				}
				rs.close();
				con.close();
			}
		}catch(ClassNotFoundException e){
			System.out.println("Sorry,can't find the Driver!");
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("数据库数据成功获取");
		}
	}}
