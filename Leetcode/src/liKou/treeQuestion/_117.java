package liKou.treeQuestion;

/**
 * @author sc
 * @date 2020/9/28
 **/

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class _117 {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = null;
        three.right = seven;
        new _117().connect(one);

    }

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        if (root == null) return null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            Node pre = null;
            for (int i = 0; i < len; i++) {
                Node now = queue.poll();
                if (now.left != null) queue.offer(now.left);
                if (now.right != null) queue.offer(now.right);
                if (i != 0) {
                    pre.next = now;
                }
                pre = now;
            }
        }
        return root;
    }
}
