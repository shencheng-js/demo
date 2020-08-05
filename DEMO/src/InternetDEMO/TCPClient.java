package InternetDEMO;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * 数据:
 * 	数据源  f:\\TCPtesst.png
 * 	目的地:服务器
 * 
 * 实现步骤:
 * 	1.创建文件输入流,读入数据源
 * 	2.创建socket对象,绑定127.0.0.1以及8888端口号
 * 	3.利用socket对象获得输入输出流
 * 	4.将由1获得的数据送入服务器
 * 	5.获得服务器返回消息
 * 	6.释放资源
 * 
 */
public class TCPClient {

	public static void main(String[] args) throws Exception {
		File file = new File("f:" + File.separator + "TCPtest.png");
		InputStream localIs = new FileInputStream(file);

		Socket client = new Socket("127.0.0.1", 8778);

		InputStream clientIs = client.getInputStream();
		OutputStream clientOs = client.getOutputStream();

		int len = 0;
		byte[] temp = new byte[1024];
		while ((len = localIs.read(temp)) != -1) {
			clientOs.write(temp, 0, len);
		}
		System.out.println("本地已上传成功");
		client.shutdownOutput();
		len = clientIs.read(temp);

		System.out.println(new String(temp, 0, len));

		client.close();
	}
}
