import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket=null;
	int port;
	Socket socket;
	DataOutputStream dos;
	FileInputStream fis;
	DataInputStream dis;
	DataBaseManage dbm;
	public Server(int port) {
		this.port=port;
		try {
			serverSocket=new ServerSocket(this.port);
			dbm=new DataBaseManage();
			socket=serverSocket.accept();
			dos=new DataOutputStream(socket.getOutputStream());
			dis=new DataInputStream(socket.getInputStream());
			int n;
			n=dis.readInt();
			System.out.println(n);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//发送数据
	public void sendData() {
		sendString("name");
		sendImage("2.png");
	}
	
	//发送字符串
	public void sendString(String str) {
		byte[] data=str.getBytes();
		try {
			dos.writeInt(data.length);
			dos.write(data);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//发送图片
	public void sendImage(String path) {
		try {
			fis=new FileInputStream(path);
			int size=fis.available();
			byte[] data=new byte[size];
			fis.read(data);
			dos.writeInt(size);
			dos.write(data);
			System.out.println("发送成功");
			dos.flush();
//			dos.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//接受字符串
	public String getData() {
		String item=null;
		try {
			int n=dis.readInt();
			byte[] data=new byte[n];
			int len=0;
			while(len<n) {
				len+=dis.read(data,len,n-len);
			}
			item=new String(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}
	
	public static void main(String[]args) {
		new Server(8066);
//		String[] one= {"123","345","6667","554","333","222","333","44"};
//		String item=StringPack(one);
//		System.out.println(item);
//		String[] b=StringUnPack(item);
//		for(int i=0;i<b.length;i++) {
//			System.out.println(b[i]);
//		}
//		System.out.println(b.length);
//		String[] str=new String[8];
//		if(str[3]==null) {
//			System.out.println("ok");
//		}else {
//			System.out.println("no");
//		}
	}
	//字符串打包
	public static String StringPack(String[] item) {
		String one=item[0]+" ";
		for(int i=1;i<item.length;i++) {
			one+=(item[i]+" ");
		}
		return one;
	}
	//字符串解包
	public static String[] StringUnPack(String str) {
		return str.split(" ");
	}
}
