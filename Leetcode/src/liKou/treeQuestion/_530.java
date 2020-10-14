package liKou.treeQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * 中序遍历，
 */
public class _530 {

    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> temp = new ArrayList<Integer>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                temp.add(root.val);
                root = root.right;
            }
        }
        int len = temp.size();
        int pre = temp.get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            int now = temp.get(i);
            min = Math.min(min, Math.abs(pre - now));
            pre = now;
        }
        return min;
    }
}
