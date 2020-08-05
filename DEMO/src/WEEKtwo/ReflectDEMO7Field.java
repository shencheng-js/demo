package WEEKtwo;

import java.lang.reflect.Field;

public class ReflectDEMO7Field {

	public static void main(String[] args) {
		Class<?> c1 = null;
		Object obj = null;

		try {
			c1 = Class.forName("WEEKtwo.Person");
			obj = c1.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		Field nameField = null;
		Field ageField = null;
		
		try {
			nameField = c1.getDeclaredField("name");
			ageField = c1.getDeclaredField("age");
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		nameField.setAccessible(true);
		ageField.setAccessible(true);
		try {
			nameField.set(obj, "zhongshen");
			ageField.set(obj, 40);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(obj);
	}
}
