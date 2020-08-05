package InternetDEMO;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPclient {

	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket(9000);
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, 1024);
		
		System.out.println("等待接收数据");
		
		ds.receive(dp);
		
		String str = new String(dp.getData(),0,dp.getLength())+"  from  "+dp.getAddress().getHostAddress();
		System.out.println(str);
		ds.close();
	}
}
