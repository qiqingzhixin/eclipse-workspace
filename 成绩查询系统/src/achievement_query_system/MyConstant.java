package achievement_query_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import student.StudentData;

public class MyConstant {
	//数据库的名字
	String name="achievement";
	//数据表
	String[] table= {"S(sno char(8) not null primary key,sname varchar(20) not null,sex char(2) not null,age char(2) not null,sdept char(10) not null,logn char(20)not null,pswd varchar(30)not null)",
			"C(cno char(4) not null primary key, cname varchar(20) not null,credit integer not null,cdept char(10) not null,tname varchar(20) not null)",
			"SC(sno char(8) not null references S(sno),cno char(4) not null references C(cno), greade integer,primary key(sno,cno))",
			};
	//MySQL的用户名和密码
	String user="root";
	String password="xiaoliangzhang";
	//一定存在的database
	String testurl="jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=utf-8&useSSL=false";	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	String url="jdbc:mysql://localhost:3306/"+name+"?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	//数据库驱动
	String driver="com.mysql.jdbc.Driver";
	//对数据操作的对象
	java.sql.Statement statement;
	//学生数据信息 查询对象
	HashMap<String, StudentData>hashmap;
	ResultSet resultSet;
	//课程数据信息
	
	//
}
