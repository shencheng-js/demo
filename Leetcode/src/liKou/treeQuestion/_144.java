package liKou.treeQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @auther {shen}
 * @DATE 2020-10-27
 */

//返回树的前序遍历，非递归算法
public class _144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
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
    }
}
