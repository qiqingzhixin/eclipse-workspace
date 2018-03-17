package achievement_query_system;

import java.lang.annotation.Retention;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import com.mysql.jdbc.Statement;

import course.CourseData;
import student.StudentData;

public class DataBaseManage extends MyConstant{
	/**
	 * дһ���������ݿ�ķ���
	 */
//	public Connection getConnection() {
//		
//		
//	}
	//���ݿ��Ƿ����
	public boolean isSql() {
		boolean flag=true;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			statement=con.createStatement();
		}catch(ClassNotFoundException e){
			System.out.println("Sorry,can't find the Driver!");
			e.printStackTrace();
			flag=false;
		}catch(SQLException e) {
			System.out.println("Sorry,can't find the database");
			e.printStackTrace();
			flag=false;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//System.out.println("���ݿ����ݳɹ���ȡ");
		}
		return flag;
	}
	//�������ݿ�
	public void create_database() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(testurl,user,password);
			statement=con.createStatement();
			//�������ݿ�
			statement.executeUpdate("create database "+name);
			statement.close();
			con.close();
//			//�����������ݿ�
//			con=DriverManager.getConnection(url,user,password);
//			statement=con.createStatement();
//			//�������
//			statement.executeUpdate("create table test(id int ,name varchar(10))");
//			statement.executeUpdate("insert into test values(1,'����')");
		}catch(SQLException e) {
			System.out.println("create_database");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�������ݱ�
	public void create_table() {
		try {
			con=DriverManager.getConnection(url,user,password);
			statement=con.createStatement();
			for(int i=0;i<table.length;i++) {
				statement.executeUpdate("create table "+table[i]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public DataBaseManage() {
		//�������ݿ�����ݱ�
		if(!isSql()) {
			create_database();
			create_table();
		}else {
			System.out.println("YES");
		}
	}
	//��ѧ������в���
	//�õ�����
	public HashMap<String, StudentData> getStudentDatas(){
		hashmap=new HashMap<>();
		String sql="select*from S";
		try {
			resultSet=statement.executeQuery(sql);
			while(resultSet.next()) {
				StudentData sd=new StudentData(0,resultSet.getString("sno"),resultSet.getString("sname"),resultSet.getString("sex"),resultSet.getInt("age"),resultSet.getString("sdept"),resultSet.getString("logn"),resultSet.getString("pswd"));
				hashmap.put(resultSet.getString("sno"), sd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hashmap;
	}
	public void addStudentData(StudentData sd) {
		String sql="insert into S values"+sd.toString();
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void changeStudentData(StudentData sd) {
		deleteStudentData(sd);
		addStudentData(sd);
	}
	public void deleteStudentData(StudentData sd) {
		String sql="delete from S where sno='"+sd.sno+"'";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����ѧ�����е�logn������
	public String login(String name,String pass){//0:û�и��û�,1:�������,2:��½�ɹ�
		String sql="select *from S";
		String flag=null;
		try {
			resultSet=statement.executeQuery(sql);
			while(resultSet.next()) {
				if(name.equals(resultSet.getString("logn"))) {
					flag="";
					if(pass.equals(resultSet.getString("pswd"))) {
						flag=resultSet.getString("sno");
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	//��C����в���
	//�õ�C�������
	public HashMap<String,CourseData>getCourseDatas(){
		HashMap<String,CourseData> hm=new HashMap<>();
		String sql="select*from C";
		try {
			resultSet=statement.executeQuery(sql);
			while(resultSet.next()) {
				CourseData cd=new CourseData(0,resultSet.getString("cno"),resultSet.getString("cname"),resultSet.getInt("credit"),resultSet.getString("cdept"),resultSet.getString("tname"));
				hm.put(cd.cno, cd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hm;
	}
	public void addCourseData(CourseData cd) {
		String sql="insert into C values"+cd.toString();
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void changeCourseData(CourseData cd) {
		deleteCourseData(cd);
		addCourseData(cd);
	}
	public void deleteCourseData(CourseData cd) {
		String sql="delete from C where cno='"+cd.cno+"'";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String[] getItemInformation(String cno) {
		String[] one=new String[5];
		String sql="select*from c where cno='"+cno+"'";
		try {
			resultSet=statement.executeQuery(sql);
			resultSet.next();
			one[0]=resultSet.getString("cno");
			one[1]=resultSet.getString("cname");
			one[2]=resultSet.getString("credit");
			one[3]=resultSet.getString("cdept");
			one[4]=resultSet.getString("tname");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return one;
	}
	//��sc����в���
	public String[][] getSI(String sno) {
		String sql="select*from s where sno='"+sno+"'";
		Vector<String> v=new Vector<>();
		String[][]one=new String[1][];
		one[0]=new String[5];
		try {
			resultSet=statement.executeQuery(sql);
			while(resultSet.next()) {
				v.add(resultSet.getString("sno"));
				v.add(resultSet.getString("sname"));
				v.add(resultSet.getString("age"));
				v.add(resultSet.getString("sex"));
				v.add(resultSet.getString("sdept"));
				String[] two= {"sno","sname","age","sex","sdept"};
				for(int i=0;i<5;i++) {
					one[0][i]=resultSet.getString(two[i]);
					//System.out.println(resultSet.getString(i));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return one;
	}
	//��sc����в���
	//��ӿγ�
	public void addCourse(String sno,String cno) {
		String sql="insert into sc values('"+sno+"','"+cno+"',null)";
		System.out.println(sql);
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ӿγ̵ķ���
	public void addScore(String sno,String cno,int n) {
		String sql="update sc set greade="+n+" "+"where sno='"+sno+"' and cno='"+cno+"'";
		System.out.println(sql);
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ɾ���γ�
	public void deleteCourse(String sno,String cno) {
		String sql="delete from sc where sno='"+sno+"' and cno='"+cno+"'";
		//System.out.println(sql);
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ѡ�γ�
	public String[][] getAvailableCourse(String sno){
		Vector<String>v=new Vector<>();
		String sql="select cno,cname from c where cno not in(select cno from sc where sno='"+sno+"')";
		try {
			resultSet=statement.executeQuery(sql);
			while(resultSet.next()) {
				v.add(resultSet.getString("cno"));
				v.add(resultSet.getString("cname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[][] one=new String[v.size()/2][];
		for(int i=0;i<v.size()/2;i++) {
			one[i]=new String[2];
			one[i][0]=v.get(2*i);
			one[i][1]=v.get(2*i+1);
		}
		return one;
	}
	//���޿γ̱�
	public String[][] getLeanedCourse(String sno){
		String sql="select c.cno,cname,greade from sc,c where greade is not null and c.cno=sc.cno and sno='"+sno+"'";
		String sqlcount="select count(*) as cou from sc,c where greade is not null and c.cno=sc.cno and sno='"+sno+"'";
		String[][] one = null;
		try {
			resultSet=statement.executeQuery(sqlcount);
			resultSet.next();
			one=new String[resultSet.getInt("cou")][];
			resultSet=statement.executeQuery(sql);
			int n=0;
			while(resultSet.next()) {
				one[n]=new String[3];
				one[n][0]=resultSet.getString("cno");
				one[n][1]=resultSet.getString("cname");
				one[n][2]=resultSet.getString("greade");
				n++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return one;
	}
	//��ѡ�γ̱�
	public String[][] getSelectedCourse(String sno){
		String sql="select c.cno,cname,c.credit,c.cdept,c.tname from sc,c where greade is null and c.cno=sc.cno and sno='"+sno+"'";
		String sqlcount="select count(*) as cou from sc,c where greade is null and c.cno=sc.cno and sno='"+sno+"'";
		String[][] one = null;
		try {
			resultSet=statement.executeQuery(sqlcount);
			resultSet.next();
			one=new String[resultSet.getInt("cou")][];
			resultSet=statement.executeQuery(sql);
			int n=0;
			while(resultSet.next()) {
				one[n]=new String[5];
				one[n][0]=resultSet.getString("cno");
				one[n][1]=resultSet.getString("cname");
				one[n][2]=resultSet.getString("credit");
				one[n][3]=resultSet.getString("cdept");
				one[n][4]=resultSet.getString("tname");
				n++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return one;
	}
	//�ɼ�������Ҫ�ĺ���
	//��ȡ�γ�����
	public String[] getCourseNames() {
		String sqlcount="select count(cname) as a from c";
		String sql="select cname from c";
		String[] one = null;
		try {
			resultSet=statement.executeQuery(sqlcount);
			resultSet.next();
			one=new String[resultSet.getInt("a")];
			resultSet=statement.executeQuery(sql);
			int n=0;
			while(resultSet.next()) {
				one[n]=resultSet.getString("cname");
				n++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return one;
	}
	//���ݿγ����ֻ�ȡѡ���˵�ѧ��
	public String[][] getSno(String cname){
		String sql="select sno,sc.greade from sc ,c where sc.cno=c.cno and c.cname='"+cname+"' and sc.greade is null";
		String sqlcount="select count(*) as a from sc, c where sc.cno=c.cno and c.cname='"+cname+"' and sc.greade is null";
		String [][] one=null;
		try {
			resultSet=statement.executeQuery(sqlcount);
			resultSet.next();
			int n=resultSet.getInt("a");
			one=new String[n][];
			resultSet=statement.executeQuery(sql);
			for(int i=0;i<n;i++) {
				resultSet.next();
				one[i]=new String[2];
				one[i][0]=resultSet.getString("sno");
				one[i][1]=resultSet.getString("greade");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return one;
	}
	//���ݿγ����ֻ�ȡ��ʦ����
	public String getTeacher(String cname) {
		String sql="select tname from c where c.cname='"+cname+"'";
		String one=null;
		try {
			resultSet=statement.executeQuery(sql);
			resultSet.next();
			one=resultSet.getString("tname");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return one;
	}
	//���ݿγ�����ȡ�γ̺�
	public String getCno(String cname) {
		String sql="select cno from c where cname='"+cname+"'";
		String one=null;
		try {
			resultSet=statement.executeQuery(sql);
			resultSet.next();
			one=resultSet.getString("cno");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return one;
	}
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ȡѧ�������гɼ��γ�
	public String[][] getItemCourse(String sno) {
		String sql="select c.cno,c.cname,sc.greade,c.credit,c.tname from c,sc where sno='"+sno+"' and sc.cno=c.cno and greade is not null";
		String sqlCount="select count(*) from c,sc where sno='"+sno+"' and sc.cno=c.cno and greade is not null";
		String[][] one=null;
		try {
			resultSet=statement.executeQuery(sqlCount);
			resultSet.next();
			int n=resultSet.getInt(1);
			System.out.print(n);
			one=new String[n][];
			resultSet=statement.executeQuery(sql);
			for(int i=0;i<n;i++) {
				resultSet.next();
				one[i]=new String[5];
				one[i][0]=resultSet.getString("cno");
				one[i][1]=resultSet.getString("cname");
				one[i][2]=resultSet.getString("greade");
				one[i][3]=resultSet.getString("credit");
				one[i][4]=resultSet.getString("tname");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return one;
	}
	public String getAvg(String sno) {
		String sql="select avg(sc.greade) from c,sc where sno='"+sno+"' and sc.cno=c.cno and greade is not null";
		String one=null;
		try {
			resultSet=statement.executeQuery(sql);
			resultSet.next();
			one=Integer.toString(resultSet.getInt(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return one;
	}
	public static void main(String[] args) {
//		DataBaseManage dbm=new DataBaseManage();
//		StudentData[] data=new StudentData[5];
//		String[] names= {"С��","С��","С��","С��","С��"};
//		String[] sexes= {"��","Ů","��","Ů","Ů"};
//		
//		for(int i=0;i<5;i++) {
//			data[i]=new StudentData(0,"1412"+i,names[i],sexes[i],20,"�����ѧԺ","1412"+i,"000000");
//			//dbm.addStudentData(data[i]);
//		}
//		//dbm.deleteStudentData(data[3]);
//		data[2].password="111111";
//		dbm.changeStudentData(data[2]);
		
//		DataBaseManage dbm=new DataBaseManage();
//		CourseData[] data=new CourseData[5];
//		String[] cnames= {"���ݽṹ","��ɢ��ѧ","΢����","�������","���������"};
//		String[] tnames= {"������","��ѩ","����","�����Ȱ�","��ѩ˪"};
//		for(int i=0;i<5;i++) {
//			data[i]=new CourseData(0,"198"+i,cnames[i],4,"�����",tnames[i]);
//			dbm.addCourseData(data[i]);
//		}
		//dbm.deleteCourseData(data[2]);
		//data[1].credit=3;
		//dbm.changeCourseData(data[1]);
		
		DataBaseManage dbm=new DataBaseManage();
//		String name="1410";
//		String pass="00000";
//		System.out.println(dbm.login(name, pass));
//		System.out.println(dbm.getSI("14120"));
		//��ӿγ�
//		dbm.addCourse("14120", "123");
		//��ӷ���
//		dbm.addScore("14120", "123", 100);
		//ɾ���γ�
//		dbm.deleteCourse("14120","123");
//		dbm.addCourse("14121","1981");
//		dbm.addCourse("14122", "1982");
//		dbm.addCourse("14121", "1982");
//		dbm.addScore("14121", "1981", 88);
//		String[][] one=dbm.getAvailableCourse("14120");
//		for(int i=0;i<one.length;i++) {
//			for(int j=0;j<one[i].length;j++) {
//				System.out.println(one[i][j]);
//			}
//		}
//		dbm.addCourse("14121","1984");
//		String[][]one=dbm.getSelectedCourse("14121");
//		for(int i=0;i<one.length;i++) {
//			for(int j=0;j<one[i].length;j++) {
//				System.out.print(one[i][j]);
//			}
//			System.out.println();
//		}
//		dbm.getSI("14121");
//		String[] one=dbm.getCourseNames();
//		for(int i=0;i<one.length;i++) {
//			System.out.println(one[i]);
//		}
		String[][] one=dbm.getItemCourse("14122");
		for(int i=0;i<one.length;i++) {
			for(int j=0;j<one[i].length;j++) {
				System.out.print(one[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println(dbm.getAvg("14122"));
	}
}
