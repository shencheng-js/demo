import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InternetDEMO {
	
	public static void main(String[] args) {
		InetAddress locAdd = null;
		InetAddress remAdd = null;
		try {
			locAdd = InetAddress.getLocalHost();
			remAdd = InetAddress.getByName("www.baidu.com");
		} catch (UnknownHostException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(locAdd.getHostAddress());
		System.out.println(remAdd.getHostAddress());
		try {
			System.out.println(locAdd.isReachable(1));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
