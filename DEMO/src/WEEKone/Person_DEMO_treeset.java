package WEEKone;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Person_DEMO_treeset implements Comparable<Person_DEMO_treeset>{

	private int age;
	private String name;
	
	public Person_DEMO_treeset(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return "我的名字是:"+name+",今年"+age+"岁了";
	}
	@Override
	public int compareTo(Person_DEMO_treeset o) {
		// TODO 自动生成的方法存根
		if (this.age>o.age) {
			return 1;//从小到大
		}else if (this.age<o.age) {
			return -1;
		}else {
			return this.name.compareTo(o.name);
		}
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode()*this.age;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person_DEMO_treeset other = (Person_DEMO_treeset) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public static void main(String[] args) {
		Set<Person_DEMO_treeset> persons = new HashSet<Person_DEMO_treeset>();
		persons.add(new Person_DEMO_treeset(20, "s"));
		persons.add(new Person_DEMO_treeset(22, "s"));
		persons.add(new Person_DEMO_treeset(23, "w"));
		persons.add(new Person_DEMO_treeset(20, "q"));
		persons.add(new Person_DEMO_treeset(233, "1"));
		persons.add(new Person_DEMO_treeset(22, "123"));
		System.out.println(persons);
		
		System.out.println(1>2);
	}
	
}
/*
class Integer implements Comparable<Integer>{

	private int num;

	@Override
	public int compareTo(Integer o) {
		// TODO 自动生成的方法存根
		if (this.num>o.num) {
			return -1;
		}else if (this.num<o.num) {
			return 1;
		}
		return 0;
	}
	
}*/