package algo_Demo.tree;

import java.util.*;

/**
 * @author sc
 * @date 2020/9/16
 **/

/**
 * 遍历树的三种方式以及打错了产生的bfs逐层遍历~~~~
 * 有点尴尬
 */
public class Traverse {
    public static void main(String[] args) {
        Integer[] dataTree = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        TreeNode root = TreeNode.convert(dataTree);
        System.out.println(posOrder(root));

        //inOrder(root);
        //posOrder(root);
    }

    private static List<Integer> preOrder(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        List<Integer> ret = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            ret.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }

        }
        return ret;
    }//先序遍历

    public static List<Integer> inOrder(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> ret = new ArrayList<Integer>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                ret.add(root.val);
                root = root.right;
            }
        }

        return ret;
    }//中序遍历

    private static Object posOrder(TreeNode root) {

        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        List<Integer> ret = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            ret.add(temp.val);


            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }

        Collections.reverse(ret);
        return ret;
    }//后序遍历

    private static List<Integer> bfsTree(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            ret.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }

        }


        return ret;
    }
}
