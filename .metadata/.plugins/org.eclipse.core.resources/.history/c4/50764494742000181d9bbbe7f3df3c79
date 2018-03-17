import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	Socket socket;
	Scanner scanner;
	BufferedReader br;
	public Client() {
		try {
			socket=new Socket("127.0.0.1",8077);
			System.out.println("客户端启用成功");
			br=new BufferedReader(new InputStreamReader(System.in));
			PrintWriter write=new PrintWriter(socket.getOutputStream());
			BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String readline;
			readline=br.readLine();
			while(!readline.equals("exit")){
				write.println(readline);
				write.flush();
				System.out.println("Client:"+readline);
				System.out.println("Server:"+in.readLine());
				readline=br.readLine();
			}
			write.close();
			in.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String args[]) {
		new Client();
	}
}
