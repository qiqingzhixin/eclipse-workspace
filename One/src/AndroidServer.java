import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AndroidServer {
	int max=10;
	ServerSocket serverSocket;
	Socket[] socket;
	int port;
	int n;
	int temp;
	public AndroidServer(int port) {
		this.port=port;
		n=0;
		socket=new Socket[max];
		try {
			serverSocket=new ServerSocket(this.port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("can't initate ServerSocket!");
			e.printStackTrace();
		}
		try {
			while((socket[n]=serverSocket.accept())!=null) {
				temp=n;
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Socket sk=socket[temp];
						System.out.println("accept"+sk.getInetAddress().getHostAddress());
						InputStream is=null;
						OutputStream os=null;
						BufferedReader br=null;
						PrintWriter pw=null;
						try {
							is=sk.getInputStream();
							os=sk.getOutputStream();
							br=new BufferedReader(new InputStreamReader(is));
							pw=new PrintWriter(os);
							String str;
							while((str=br.readLine())!=null) {
								System.out.println(str);
								pw.println("Server->"+str);
								pw.flush();
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();
				n++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new AndroidServer(8066);
	}
}
