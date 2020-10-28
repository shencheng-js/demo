package liKou.treeQuestion;

/**
 * @auther {shen}
 * @DATE 2020-10-29
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * <p>
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * <p>
 * 计算从根到叶子节点生成的所有数字之和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 深度搜索
 */
public class _129 {
    List<Integer> ans = new ArrayList<Integer>();

    public static void main(String[] args) {
        TreeNode one = new TreeNode(4);
        TreeNode two = new TreeNode(9);
        TreeNode three = new TreeNode(0);
        TreeNode four = new TreeNode(5);
        TreeNode six = new TreeNode(1);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = six;
        System.out.println(new _129().sumNumbers(one));
    }

    public int sumNumbers(TreeNode root) {
        List<Integer> temp = new ArrayList<Integer>();
        dfs(temp, root);
        int ret = 0;
        for (int i = 0; i < ans.size(); i++) {
            ret += ans.get(i);
        }
        return ret;
    }

    private void dfs(List<Integer> temp, TreeNode root) {
        //结束的条件不对，这样会算两遍
        if (root == null) {
            return;
        }
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            int result = 0;
            for (int i = 0; i < temp.size(); i++) {
                result *= 10;
                result += temp.get(i);
            }
//            System.out.println(result);
            ans.add(result);
            return;
        }
        if (root.left != null) {
            dfs(temp, root.left);
            temp.remove(temp.size() - 1);
        }
        if (root.right != null) {
            dfs(temp, root.right);
            temp.remove(temp.size() - 1);
        }

//
    }
}
