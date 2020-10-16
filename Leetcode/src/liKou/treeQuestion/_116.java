package liKou.treeQuestion;


/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 用队列解决很简单
 */
public class _116 {

    //使用了队列，为了使用常量级，可以从左边向下
//    public Node connect(Node root) {
//        if (root==null)return null;
//        Queue<Node> queue  =new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            int len = queue.size();
//            for (int i = 0; i < len; i++) {
//                // 从队首取出元素
//                Node node = queue.poll();
//
//                // 连接
//                if (i < len - 1) {
//                    node.next = queue.peek();
//                }
//
//                // 拓展下一层节点
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//
//            }
//        }
//        return root;
//    }

    public Node connect1(Node root) {
        if (root == null) return null;
        Node leftmost = root;
        Node head;
        while (leftmost.left != null) {
            head = leftmost;

            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        // 从根节点开始
        Node leftmost = root;
        while (leftmost.left != null) {
            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;
            while (head != null) {
                // CONNECTION 1
                head.left.next = head.right;
                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                // 指针向后移动
                head = head.next;
            }
            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }

        return root;
    }

}

