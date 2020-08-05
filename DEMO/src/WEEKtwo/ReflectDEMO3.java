package WEEKtwo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class ReflectDEMO3 {
	
	public static void main(String[] args) {
		Class<?> c = null;
		try {
			c = Class.forName("WEEKtwo.Person");
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(Modifier.toString(4));
		Class<?> superClass1 = c.getSuperclass();
		System.out.println(superClass1.getName());
		Constructor<?> []cons = c.getConstructors();
		for (int i = 0; i < cons.length; i++) {
			Constructor<?> constructor = cons[i];
			System.out.println(constructor);
		}
	}
}
