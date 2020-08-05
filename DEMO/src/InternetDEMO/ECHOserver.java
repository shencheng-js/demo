package InternetDEMO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ECHOserver {

	public static void main(String[] args) throws Exception {

		ServerSocket socket = new ServerSocket(7777);

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根

				BufferedReader buf = null;
				PrintStream out = null;
				Socket server = null;
				boolean f = true;
				while (f) {
					// TODO 自动生成的方法存根
					System.out.println("服务器运行,等待连接~~~");
					try {
						server = socket.accept();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					boolean flag = true;
					try {
						buf = new BufferedReader(new InputStreamReader(server.getInputStream()));
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					try {
						out = new PrintStream(server.getOutputStream());
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

					while (flag) {
						String str = null;
						try {
							str = buf.readLine();
						} catch (IOException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
						if (str == null || "".equals(str) || "bye".equals(str)) {
							flag = false;
						} else {
							out.println("ECHO:" + str);
						}

					}
					out.close();
					try {
						server.close();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

				}
				try {
					socket.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

			}
		}).start();

	}
}
