package InternetDEMO;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
/*
 * 最后得出的都是html语言文本;
 */
public class InternetDEMO2 {

	public static void main(String[] args) {
		URL url =null;
		InputStream input = null;
		try {
			url = new URL("http", "www.baidu.com", 80, "/baidu?tn=monline_3_dg&ie=utf-8&wd=shen");
			//80是端口号,  其实遵循了计算机网络关于url的规定     :  协议  主机  端口号 路径
			input = url.openStream();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Scanner scan = new Scanner(input);
	
		scan.useDelimiter("\n");
		while (scan.hasNext()) {
			System.out.println(scan.next());
			
		}
	}
}
