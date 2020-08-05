package InternetDEMO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDEMO {

	public static void main(String[] args) throws Exception {
		System.out.println("收到客户机请求,建立连接!");
		ServerSocket server = new ServerSocket(8888);
		File file = new File("f:"+File.separator+"text.txt");
		Socket client1 = server.accept();
		
		OutputStream os = client1.getOutputStream();

		InputStream is = client1.getInputStream();

		byte[] temp = new byte[1024];
		int len = is.read(temp);
		System.out.println(new String(temp, 0, len));
		OutputStream fileout = new FileOutputStream(file);
		fileout.write(temp);
		
		os.write("收到消息,你好客户机.".getBytes());

		
		client1.close();
		server.close();
	}
}
