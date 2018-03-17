import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AndroidServer2 {
	public static void main(String[] args) {    
        try {    
            ServerSocket server = new ServerSocket(8066); 
            System.out.println("one");
            Socket socket = server.accept();    
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());    
            FileInputStream fis = new FileInputStream("1.png");    
            int size = fis.available();
            System.out.println("size = "+size);  
            byte[] data = new byte[size];    
            fis.read(data);    
            dos.writeInt(size);    
            dos.write(data);    
            dos.flush();    
            dos.close();    
            fis.close();    
            socket.close();    
            server.close();    
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
    }
}
