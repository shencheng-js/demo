package liKou.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sc
 * @date 2020/9/28
 **/
public class testQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
