package liKou.treeQuestion;

/**
 * @author sc
 * @date 2020/9/26
 **/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class _113 {

    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    Deque<Integer> temp = new ArrayDeque<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        temp.offerLast(root.val);
        sum -= root.val;

        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new ArrayList<>(temp));
        }

        dfs(root.left, sum);
        dfs(root.right, sum);

        temp.pollLast();
    }
}
