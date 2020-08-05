package ENUMDEMO;

import java.util.Set;
import java.util.TreeSet;

public class getEnumContent {
	public static void main(String[] args) {
		Color c = Color.BLUE;
		System.out.println(c);

		for (Color c1 : Color.values()) {
			System.out.println(c1.ordinal()+"  "+c1.name()+"  "+c1.getName());

		}
		Set<Color> t = new TreeSet<Color>();
	
	}
}

