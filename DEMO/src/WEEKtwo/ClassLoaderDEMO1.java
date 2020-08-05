package WEEKtwo;

public class ClassLoaderDEMO1 extends ClassLoader{
	public static void main(String[] args) {
		Class<?> c = ClassLoaderDEMO1.class;
		ClassLoader loader = c.getClassLoader();
		
		System.out.println(loader);
		System.out.println(c.getClassLoader());
		System.out.println(c.getClassLoader().getParent());
		myperson aMyperson = new myperson();
	}
}
class myperson{
	public myperson() {
		// TODO 自动生成的构造函数存根
		System.out.println("构造函数启动!!!");
	}
}