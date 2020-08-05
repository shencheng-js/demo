package WEEKone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class map_DEMO {
	public static void main(String[] args) {
		Map<Integer, String> translate = new HashMap<Integer, String>();
		
		Set<Integer> mykey = new HashSet<Integer>();
		translate.put(1, "one");
		translate.put(2, "two");
		translate.put(3, "three");
		translate.put(4, "four");
		translate.put(5, "five");
		translate.put(6, "six");
		translate.put(7, "seven");
		mykey = translate.keySet();
//		System.out.println(translate.get);
		translate.remove(5);
		mykey = translate.keySet();
		System.out.println(mykey);
		System.out.println(translate.size());
		System.out.println(translate.get(1));
		
	}
}
