package liKou;

/**
 * @author sc
 * @date 2020/9/14
 **/

import java.util.*;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 */

public class _94 {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = TreeNode.convert(ints);
        System.out.println(new _94().stackLateOrder(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        centerOrder(ret, root);
        return ret;
    }

    //递归调用
    private void centerOrder(List<Integer> ret, TreeNode root) {
        if (root == null) return;
        centerOrder(ret, root.left);
        ret.add(root.val);
        centerOrder(ret, root.right);
    }

    //栈结构
    private List<Integer> stackCenterOrder(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ret.add(root.val);
            root = root.right;
        }
        return ret;
    }

    private List<Integer> stackPreOrder(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                ret.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
        return ret;
    }

    private List<Integer> stackLateOrder(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> src = new Stack<TreeNode>();
        Stack<TreeNode> res = new Stack<TreeNode>();
        src.push(root);
        while (!src.isEmpty()) {
            TreeNode p = src.pop();
            ret.add(p.val);
            if (p.left != null) {
                src.push(p.left);
            }
            if (p.right != null) {
                src.push(p.right);
            }
        }
        //输出最终后序遍历的结果
        return ret;
    }


}
