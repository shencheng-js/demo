package WEEKtwo;

import java.lang.reflect.Array;

public class ReflectDEMO8Array {

	/*public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int []temp = {1,2,3,4,5};
		Class<?> c = temp.getClass().getComponentType();
		System.out.println(c.getName());
		System.out.println("长度: "+Array.getLength(temp));
		System.out.println("首元素: "+Array.get(temp, 0));
		Array.set(temp, 0, 0);
		System.out.println("经过变化后首元素: "+Array.get(temp, 0));
	}*/  //     reflect 机制下array的使用

	
	
	//修改数组的大小
	public static void main(String[] args) {
		int[] temp = {1,2,3,4};
		int[] newtemp = (int[])arrayInc(temp, 5);
		print(newtemp);
		System.out.println("===================");
		String []temp1 = {"ha","ja","ka"};
		String []newtemp1 =(String[])arrayInc(temp1, 2);
		print(newtemp1);
	}
	
	
	public static Object arrayInc(Object obj,int len) {
		Class<?> c = obj.getClass().getComponentType();
		//Class<?> c1 = c.getComponentType();
		Object newo = Array.newInstance(c, len);
		int co = Array.getLength(obj);
		if (co<len) {
			System.arraycopy(obj, 0, newo, 0, co);
		}
		else {
			System.arraycopy(obj, 0, newo, 0, len);
			System.out.println("数组反向缩减了");
		}
		return newo;
	}
	
	public static void print(Object obj) {
		Class<?> c = obj.getClass();
		if (!c.isArray()) {
			return;
		}
		
		Class<?> c1 = c.getComponentType();
		
		System.out.println(c1.getName()+"数组的长度是:"+Array.getLength(obj));
		for (int i = 0; i < Array.getLength(obj); i++) {
			System.out.print(Array.get(obj, i));
			if (i<Array.getLength(obj)-1) {
				System.out.print(",");
			}
		}
	}
	
}
