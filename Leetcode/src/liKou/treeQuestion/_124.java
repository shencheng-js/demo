package liKou.treeQuestion;

/**
 * @author sc
 * @date 2020/9/22
 **/

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _124 {
    int max_Sum = Integer.MIN_VALUE;
    //此处int不要使用static多次操作后值会保存之前结果

    public int maxPathSum(TreeNode root) {
        find(root);
        return max_Sum;
    }

    private int find(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, find(root.left));
        int right = Math.max(0, find(root.right));

        int now_sum = root.val + left + right;
        max_Sum = Math.max(max_Sum, now_sum);
        return root.val + Math.max(left, right);

    }

}
