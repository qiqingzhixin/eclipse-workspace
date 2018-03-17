package chapter_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Section_one {
	public static void main(String[]args) {
		String url="http://www.ele.me/place/wtw64ku5bdgd?latitude=31.315814&longitude=121.393459";
		String urlbaidu="http://www.baidu.com";
		String result="";
		BufferedReader bufferedReader=null;
		try {
			URL realurl=new URL(url);
			URLConnection connection=realurl.openConnection();
			//实际连接
			connection.connect();
			//读取URL的响应
			bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while((line=bufferedReader.readLine())!=null) {
				result+=line+"\n";
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		
	}
}
