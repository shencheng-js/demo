package WEEKone;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArrsyListdemo2 {
	public static void main(String[] args) {
		List<String> allList = new ArrayList<String>();
		
		allList.add("Hello");
		allList.add(0, "world");
		allList.add("shen");
		allList.add("cheng");
		List<String> allsub = allList.subList(1,3);
		//System.out.println(allList);
		//System.out.println(allsub);
		
		for (int i = 0; i < allList.size(); i++) {
			//System.out.print(allList.get(i)+".");
			
		}
		System.out.println();
		for (int i = allList.size()-1; i >0; i--) {
			//System.out.print(allList.get(i)+".");
			
		}
		
		//System.out.println(allList);
		allList.remove(0);
		allList.remove("shen");
		//System.out.println(allList);
		String str[] = allList.toArray(new String[] {});
		//System.out.println(str[0]);
		LinkedList<String> alllink = new LinkedList<String>();
		
		alllink.add("A");
		alllink.add("B");
		alllink.add("C");
		alllink.add("D");
		alllink.add("F");
		System.out.println("链表初始化序列为: "+alllink);
		alllink.addFirst("1");
		alllink.addLast("0");
		System.out.println("链表处理后序列为: "+alllink);
		String allstr = alllink.element();
		System.out.println(allstr);
		System.out.println("链表使用element后序列为: "+alllink);
		allstr = alllink.peek();
		System.out.println(allstr);
		
		System.out.println("链表使用peek后序列为: "+alllink);
		allstr = alllink.poll();
		System.out.println(allstr);
		System.out.println("链表使用poll后序列为: "+alllink);
	}
	
	
}
