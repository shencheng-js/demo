package WEEKtwo;

import java.lang.reflect.Field;

public class ReflectDEMO4 {

	public static void main(String[] args) {
		Class<?> c1 = null;
		try {
			c1 = Class.forName("WEEKtwo.Person");
		} catch (Exception e) {
			// TODO: handle exception
		}
		{
			Field f[] = c1.getDeclaredFields();
			for (int i = 0; i < f.length; i++) {
				System.out.println(f[i]);
				
			}
		}
	}
}
