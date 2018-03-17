import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class AndroidServer1 implements Runnable{

	/**
	 * @param args
	 */
	
	int max=10;      //������߳���
	int i=0;         //�ظ�����
	int temp;
	ServerSocket serverSocket;
	Socket socket[];
	
	public AndroidServer1(){
		
		try {
			serverSocket=new ServerSocket(8066);    //��8066�˿ڽ�������
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("can't initate ServerSocket!");
			return;
		}
		
		socket=new Socket[max];
		
		System.out.println("waiting for connect");
		try {
			while((socket[i]=serverSocket.accept())!=null){
				temp=i;
				i++;
				new Thread(this).start();           //ÿ������һ���ͻ��˵����ӣ��ͻῪ��һ�������߳�
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new AndroidServer1();

	}

	@Override
	public void run() {
		Socket sk=socket[temp];
		System.out.println("accept:"+sk.getInetAddress().getHostAddress());
		InputStream is=null;
		OutputStream os=null;
		BufferedReader br=null;
		PrintWriter pw=null;
		try {
			is=sk.getInputStream();
			os=sk.getOutputStream();
			br=new BufferedReader(new InputStreamReader(is));
			pw=new PrintWriter(os);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				sk.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}
		String str;
		try {
			int m=0;
			while((str=br.readLine())!=null){
				//�����Կͻ��˿ͻ��˵��������Ϊ10��
				System.out.println(str);
				if(str.equals("shop")) {
					//�����̵����Ϣ
					pw.println("server->shop"+socket.toString());
					pw.flush();
					DataOutputStream dataOutputStream=new DataOutputStream(sk.getOutputStream());
					FileInputStream fis=new FileInputStream("1.png");
					int size=fis.available();
					System.out.println("size="+size);
					byte[] data=new byte[size];
					fis.read(data);
					dataOutputStream.writeInt(size);
					dataOutputStream.write(data);
					dataOutputStream.flush();
					dataOutputStream.close();
					fis.close();
				}else if(str.equals("food")){
					pw.println("server->food"+socket.toString());
				}
				m++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
