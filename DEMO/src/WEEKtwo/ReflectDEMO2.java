package WEEKtwo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

interface china{
	public static final String NATION = "China";
	
}
interface hometown{
	public static final String town = "FuNing";
	
}
public class ReflectDEMO2 {

	public static void main(String[] args) {
		Class<?> c = null;
		try {
			c = Class.forName("WEEKtwo.Person");
		} catch (Exception e) {
			// TODO: handle exception
		}
		Class<?> c2[] = c.getInterfaces();
		for (int i = 0; i < c2.length; i++) {
			System.out.println(c2[i].getName());
			
		}
		
		Method[] c3 = c.getMethods();
		for (int i = 0; i < c3.length; i++) {
			System.out.println(c3[i].getName());
		}
		
		Constructor<?> cons[] = null;
		cons = c.getConstructors();
		Person per = null;
		try {
			per = (Person)cons[0].newInstance("shencheng",22);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//per.setAge(22);
		//per.setName("shencheng");
		System.out.println(per);
		
		
	}
}
class Person implements china,hometown{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	public void sayChina() {
		System.out.println("我是一个中国人.");
	}
	public String sayHello(String name,int age) {
		return name+"今年的年纪是"+age+"岁";
	}
	@Override
	public String toString() {
		return "名字=" + name + ", 年龄=" + age + ", 国籍是"+NATION+" "+town+".";
	}
	
}