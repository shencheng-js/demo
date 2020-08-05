package IODEMO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class InOutDEMO {
	public static void main(String[] args) throws IOException {
		
		
		
		System.setIn(new FileInputStream("f:"+File.separator+"text.txt"));
		InputStream myIn = System.in;
		byte[] b= new byte[1024];
		int len = myIn.read(b);
		System.out.println("Context:"+new String(b,0,len));
		myIn.close();
		
		
	}
}
