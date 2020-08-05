package WEEKtwo;

public class ReflectDEMO1 {
	public static void main(String[] args) {
		X newx = new X();
		System.out.println(newx.getClass().getName());
		Class<?> c1 = null;
		Class<?> c2 = null;
		Class<?> c3 = null;
		try {
			c1 = Class.forName("WEEKtwo.X");
		} catch (Exception e) {
			// TODO: handle exception
		}
		c2 = new X().getClass();
		c3 = X.class;
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c3.getName());
	}
}
class X{
}
