package WEEKtwo;

import java.lang.reflect.Method;

public class ReflectDEMO5 {
	public static void main(String[] args) {
		Class<?> c1 = null;
		try {
			c1 = Class.forName("WEEKtwo.Person");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			//Method met = c1.getMethod("sayChina");
			//met.invoke(c1.newInstance());       无参方法使用
			
			Method met = c1.getMethod("sayHello", String.class,int.class);
			String rv = (String)met.invoke(c1.newInstance(), "老沈",29);
			System.out.println(rv);//有参方法调用
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
