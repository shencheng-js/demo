package InternetDEMO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 服务器
 * 
 * 数据源:
 * 	客户机的网络资源
 * 	服务器存储  g:\\upload\\server.png
 * 
 * 操作步骤:
 * 	1.
 */

//让服务器一直坚挺
public class TCPServer {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(8778);

		// 让此处死循环
		while (true) {

			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO 自动生成的方法存根
					try {
						Socket socket = server.accept();

						InputStream socketIs = socket.getInputStream();
						OutputStream socketOs = socket.getOutputStream();

						File file = new File("g:" + File.separator + "upload");
						if (!file.exists()) {
							file.mkdirs();
						}
						OutputStream localIs = new FileOutputStream(
								file + File.separator + System.currentTimeMillis() + ".png");

						int len = 0;
						byte[] temp = new byte[1024];
						while ((len = socketIs.read(temp)) != -1) {
							localIs.write(temp, 0, len);
						}

						socketOs.write("收到文件".getBytes());
						localIs.close();
						socket.close();

					} catch (Exception e) {
						// TODO: handle exception
					}

				}
			}).start();

		}

	}
}
