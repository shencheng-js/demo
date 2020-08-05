package IODEMO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyDEMO {

	public static void copy(String root,String dest) {
		File rootFile = new File(root);
		File destFile = new File(dest);
		if (!rootFile.exists()) {
			System.out.println("源文件不存在");
			System.exit(1);
		}
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(rootFile);
			output = new FileOutputStream(destFile);
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		if (input!=null&&output!=null) {
			int temp = 0;
			try {
				while ((temp = input.read())!=-1) {
					output.write(temp);
					
				}
				System.out.println("复制结束");
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				input.close();
				output.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	public static void copyBig(String root,String dest) {
		File rootFile = new File(root);
		File destFile = new File(dest);
		if (!rootFile.exists()) {
			System.out.println("源文件不存在");
			System.exit(1);
		}
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(rootFile);
			output = new FileOutputStream(destFile);
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		if (input!=null&&output!=null) {
			int temp = 0;
			byte[]data = new byte[100];
			
			try {
				while ((temp = input.read(data))!=-1) {
					output.write(data,0,temp);
					
				}
				System.out.println("复制结束");
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				input.close();
				output.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		String root = "f:"+File.separator+"text.txt";
		String dest = "f:"+File.separator+"tet.txt";
		copy(root, dest);
	}
}
