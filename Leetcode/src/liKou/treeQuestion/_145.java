package liKou.treeQuestion;

/**
 * @author sc
 * @date 2020/9/29
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * <p>
 * 哈哈哈，提交了三次，笑死我，没考虑root == null的情况
 */
public class _145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            ret.add(temp.val);
            if (temp.left != null) stack.add(temp.left);
            if (temp.right != null) stack.add(temp.right);
        }
        Collections.reverse(ret);
        return ret;
    }
}
