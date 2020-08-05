package IODEMO;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;

public class FILEdemo1 {

	public static void main(String[] args) {
		File file = new File("f:"+File.separator+"text.txt");
		
		File file2 = new File("f:"+File.separator+"testfile");
		
		File file3 = new File("d:"+File.separator+"MATLAB");
		print(file3);
		/*if (file.delete()) {
			System.out.println("success");
		}
		else {
			System.out.println("false");
		}*/
		
		/*
		if (file.exists()) {
			file.delete();
		}
		else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}*/
		
		/*
		if (file2.getParentFile().exists()) {
			file2.mkdirs();
		}
		*/
		
		/*
		File str[] = file3.listFiles();
		for (int i = 0; i < str.length; i++) {
			if (str[i].isDirectory()) {
				System.out.println(str[i]);
			}
			
		}*/
	}
	
	
	
	public static void print(File file) {
		
		
		if (file!=null) {
			if(file.isDirectory()) {
				File f[] = file.listFiles();
				if(f!=null) {
					for (int i = 0; i < f.length; i++) {
						print(f[i]);
						
					}
				}
				
			}else {
					System.out.println(file);
				}
		}
		
		
	}
}
