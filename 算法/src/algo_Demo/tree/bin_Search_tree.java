package algo_Demo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sc
 * @date 2020/9/21
 **/
public class bin_Search_tree {

    public static TreeNode root;

    public static void main(String[] args) {

        int[] ints = {4, 2, 3, 4, 5, 6};
        for (int i : ints) {
//            System.out.println("正在插入 "+i);
            insert_Node(i);
        }
        System.out.println(inorder(root));

    }

    private static List<Integer> inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                int k;
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                ret.add(root.val);
                root = root.right;
            }
        }
        return ret;


    }

    private static void insert_Node(int i) {
        TreeNode temp = new TreeNode(i);
        if (root == null) {
            root = temp;
            return;
        } else {
            TreeNode parent = new TreeNode();
            TreeNode current = root;

            while (true) {
                parent = current;
                if (i < current.val) {
                    current = current.left;
                    if (current == null) {
                        parent.left = temp;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = temp;
                        return;
                    }
                }
            }
        }
    }

    private static void convert_Recur() {
    }
}
