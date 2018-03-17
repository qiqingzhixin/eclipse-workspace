package shop;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerMain {
	ServerSocket server=null;
	int port;
	int max=10;
	int i=0;
	int temp;
	Socket socket;
	public ServerMain(int port) {
		this.port=port;
		try {
			server=new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("can't initate ServerSocket!");
			e.printStackTrace();
		}
//		
//		socket=new Socket[max];
		try {
			while((socket=server.accept())!=null) {
				//接受客户端
				new Thread(new MyRunnable()).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[]args) {
		new ServerMain(8066);
	}
	class MyRunnable implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("accept:"+socket.getInetAddress().getHostAddress());
			InputStream inputStream=null;
			DataOutputStream dataOutputStream=null;
			BufferedReader br=null;
			try {
				inputStream=socket.getInputStream();
				br=new BufferedReader(new InputStreamReader(inputStream));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.print("IoException");
				e.printStackTrace();
			}
			String str=null;
			try {
				//读取客户端发来的消息
				while((str=br.readLine())!=null) {
					dataOutputStream=new DataOutputStream(socket.getOutputStream());
					System.out.println(str);
					int k=Integer.parseInt(str);
					String item=null;
					switch(k) {
					case 0:
						item="0.png";
						break;
					case 1:
						item="1.png";
					case 2:
						item="2.png";
					case 3:
						item="3.png";
					}
					System.out.print(item);
					FileInputStream fis=new FileInputStream(item);
					int size=fis.available();
					byte[] data=new byte[size];
					fis.read(data);
					dataOutputStream.writeInt(size);
					dataOutputStream.write(data);
					dataOutputStream.flush();
					fis.close();
					dataOutputStream.close();
				}
				System.out.print("while");
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
