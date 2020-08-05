package IODEMO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.*;

public class BufferReaderDEMO {

	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String str = buf.readLine();
		System.out.println(str);
		//System.out.println(System.getProperty("file.encoding"));
		
	}
}
