package InternetDEMO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/*
 * 1.读取键盘输入
 * 2.向服务器发送的输出流
 * 3.读取服务器返回的输入流
 */
public class ECHOclient {

	public static void main(String[] args) throws Exception{
		Socket client = new Socket("localhost",7777);
		
		BufferedReader buf = null;
		PrintStream out = null;
		BufferedReader input = null;
		
		input = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintStream(client.getOutputStream());
		buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		boolean flag = true;
		while (flag) {
		//	System.out.println("请输入信息: ");
			String str = input.readLine();
			out.println(str);
			if ("bye".equals(str)) {
				flag = false;
			}
			else {
				String ret = buf.readLine();
				System.out.println(ret);
			}
		}
		client.close();
		buf.close();
		
		
	}
}
