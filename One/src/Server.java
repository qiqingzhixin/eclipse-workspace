import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[]args) {
		new Server().oneServer();
	}
	public void oneServer() {
		ServerSocket server=null;
		try {
			server=new ServerSocket(8077);
			System.out.println("服务器启动成功");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Socket socket=null;
		try {
			socket=server.accept();
			
		}catch(Exception e) {
			System.out.println("Error."+e);
		}
		String line;
		try {
			BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter write=new PrintWriter(socket.getOutputStream());
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Client:"+in.readLine());
			line=br.readLine();
			while(!line.equals("end")) {
				write.println(line);
				write.flush();
				System.out.println("Server:"+line);
				System.out.println("Client:"+in.readLine());
				line=br.readLine();
				write.close();
				in.close();
				socket.close();
				server.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
