import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Test_2 {
	public static void main(String[] args) {
		Connection con;
		//��������
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/school";
		//�û���������
		String user="root";
		String password="xiaoliangzhang";
		try {
			Class.forName(driver);
			//�������ݿ�
			con=(Connection) DriverManager.getConnection(url, user, password);
			if(!con.isClosed()) {
				System.out.println("Succeede connection to the Datdase!");
				Statement statement=(Statement) con.createStatement();
				String sql="select*from S";
				ResultSet rs=statement.executeQuery(sql);
				System.out.println("--------------------------");
				System.out.println("ִ�н��������ʾ��");
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
			System.out.println("Sorry,can't find the database");
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("���ݿ����ݳɹ���ȡ");
		}
	}
}
