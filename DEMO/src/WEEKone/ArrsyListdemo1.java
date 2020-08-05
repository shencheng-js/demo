package WEEKone;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;

public class ArrsyListdemo1 {
	public static void main(String[] args) {
		java.util.List<String> allList = null;
		Collection<String> allCollection = null;
		allList = new ArrayList<String>();
		allCollection = new ArrayList<String>();
		allList.add("shen");
		allList.add("???");
		allList.add(0, "cheng");
		System.out.println(allList);
		allCollection.add("!!!");
		allCollection.addAll(allList);
		allList.addAll(0,allList);
//		allCollection.addAll(0,allList);报错,因为collections是原始类,而list
		//是扩充后的,有addall方法
		System.out.println(allCollection);
		System.out.println(allList);
	}
}
