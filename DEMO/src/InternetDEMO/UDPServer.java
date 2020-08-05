package InternetDEMO;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket(3000);
		String str = "Hello client.";
		DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(),InetAddress.getByName("localhost"),9000);
		System.out.println("发送消息");
		ds.send(dp);
		ds.close();
	}
}
