package InternetDEMO;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class InternetDEMO3 {

	public static void main(String[] args) throws Exception {
		
		//urlconnection测试
		URL url= new URL("https://www.baidu.com/");
		URLConnection urlconn = url.openConnection();
		System.out.println(urlconn.getContentLength());
		System.out.println(urlconn.getContentType());
		
		//encoder与decoder
		
		String name = "沈成";
		String encode = URLEncoder.encode(name,"UTF-8");
		System.out.println(encode);
		String decode = URLDecoder.decode(encode,"UTF-8");
		System.out.println(decode);
	}
}
