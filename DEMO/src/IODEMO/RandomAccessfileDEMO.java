package IODEMO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class RandomAccessfileDEMO {

	public static void main(String[] args) throws IOException {
		File file = new File("f:" + File.separator + "text.txt");

		/*
		 * RandomAccessFile rdf = new RandomAccessFile(file, "rw");
		 * 
		 * rdf.writeBytes("shencheng"); rdf.writeInt(22);
		 * 
		 * rdf.writeBytes("shen"); rdf.writeInt(21);
		 * 
		 * rdf.writeBytes("cheng"); rdf.writeInt(20);
		 * 
		 * rdf.close();
		 */

		OutputStream oStream = new FileOutputStream(file,true);

		String str = "HELLO WORLD!\r\n";

		byte[] b = str.getBytes();

		oStream.write(b);

		oStream.close();

		InputStream iStream = new FileInputStream(file);

		byte b1[] = new byte[(int)file.length()];

		iStream.read(b1);

		iStream.close();

		int len = b1.length;

		System.out.println("内容为: " + new String(b1));

	}
}
