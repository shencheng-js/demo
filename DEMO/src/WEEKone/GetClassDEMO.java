package WEEKone;
class x{
	
}
public class GetClassDEMO {
	public static void main(String[] args) {
		Class<?> c1 = null;
		Class<?> c2 = null;
		Class<?> c3 = null;
		System.out.println(new x().getClass());
		try {
			c1 = Class.forName("WEEKone.x");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("你的类名输错了");
		}
		c2 = new x().getClass();
		c3 = x.class;
		System.out.println("c1的类名"+c1.getName());
		System.out.println("c2的类名"+c2.getName());
		System.out.println("c3的类名"+c3.getName());
	}
}
