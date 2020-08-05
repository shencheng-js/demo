package IODEMO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InputData {

	private BufferedReader buf = null;

	public InputData() {
		// TODO 自动生成的构造函数存根
		buf = new BufferedReader(new InputStreamReader(System.in));
	}

	public String getString(String info) {
		String temp = null;
		System.out.println(info);

		try {
			temp = buf.readLine();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return temp;
	}

	public int getInt(String info, String warnstr) {
		int temp = 0;
		String medium = null;
		boolean flag = true;
		while (flag) {
			medium = getString(info);
			if (medium.matches("^\\d+$")) {
				temp = Integer.parseInt(medium);
				flag = false;
			} else {
				System.out.println(warnstr);
			}

		}
		return temp;
	}

	public float getFloat(String info, String warnstr) {
		float temp = 0;
		String medium = null;
		boolean flag = true;
		while (flag) {
			medium = getString(info);
			if (medium.matches("^\\d+.?\\d+$")) {
				temp = Float.parseFloat(medium);
				flag = false;
			} else {
				System.out.println(warnstr);
			}

		}
		return temp;
	}
	
	public java.util.Date getDate(String info, String warnstr) {
		java.util.Date temp = null;
		String medium = null;
		boolean flag = true;
		while (flag) {
			medium = getString(info);
			if (medium.matches("^\\d{4}-\\d{2}-\\d{2}$")) {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					temp = sdf.parse(medium);
					flag = false;
				} catch (ParseException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			} else {
				System.out.println(warnstr);
			}

		}
		return temp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		InputData iData = new InputData();
		//java.util.Date second = iData.getDate("Please input the second num.", "Your input is illeagl");
		System.out.println(System.getProperty("file.encoding"));
	}
}

class test {

}