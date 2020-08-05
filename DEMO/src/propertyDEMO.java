import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyDEMO {

	public static void main(String[] args) {
		Properties pro = new Properties();
//		pro.setProperty("BJ", "beijing");
//		pro.setProperty("SH", "shanghai");
//		pro.setProperty("YC", "yancheng");
		
		File file = new File("f:"+File.separator+"area.txt");
		
		try {
			pro.load(new FileInputStream(file));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(pro.getProperty("ASD","似乎没有~~~"));
	}
}
