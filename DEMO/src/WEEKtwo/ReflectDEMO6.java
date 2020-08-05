package WEEKtwo;

import java.lang.reflect.Method;

public class ReflectDEMO6 {
	public static void main(String[] args) {
		Class<?> c1 = null;
		Object obj = null;
		try {
			c1 = Class.forName("WEEKtwo.Person");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			obj=c1.newInstance();
		} catch (Exception e) {
			// TODO: handle exception
		}
		setter(obj, "name", "xiaoshen", String.class);
		System.out.print("名字: ");
		getter(obj, "name");
		setter(obj, "age", 19, int.class);
		System.out.print("年龄: ");
		getter(obj, "age");
		
	}
	/**
	 * 
	 * @param obj 操作对象
	 * @param att 操作属性
	 * @param value 属性值
	 * @param type 属性类型
	 */
	public static void setter(Object obj,String att,Object value,Class<?> type) {
		try {
			Method met = obj.getClass().getMethod("set"+myUpper(att),type);
			met.invoke(obj, value);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void getter(Object obj,String att) {
		try {
			Method met = obj.getClass().getMethod("get"+myUpper(att));
			System.out.println(met.invoke(obj));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static String myUpper(String str) {
		return str.substring(0, 1).toUpperCase()+str.substring(1);
	}
}
