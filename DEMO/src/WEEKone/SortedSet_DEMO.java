package WEEKone;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSet_DEMO {
	public static void main(String[] args) {
		SortedSet<String> allSet = new TreeSet<String>();
		allSet.add("H");
		allSet.add("B");
		allSet.add("C");
		allSet.add("D");
		allSet.add("E");
		allSet.add("F");
		allSet.add("G");
		Iterator<String> iter = allSet.iterator();
		while (iter.hasNext()) {
			String string= iter.next();
			if ("E".equals(string)) {
				iter.remove();
			}
			else {
			//	System.out.print(string+".");
			}
			
			
		}
		System.out.println(allSet);
	}
}
