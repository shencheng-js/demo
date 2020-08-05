package InternetDEMO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDEMO {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Socket client = new Socket("127.0.0.1", 8888);
		OutputStream clos = client.getOutputStream();

		InputStream clis = client.getInputStream();
		clos.write("你好,服务器.".getBytes());
		byte[] temp1 = new byte[1024];
		int len = clis.read(temp1);

		System.out.println(new String(temp1, 0, len));

		client.close();
		
	}
}
