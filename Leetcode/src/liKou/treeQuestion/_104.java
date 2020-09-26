package liKou.treeQuestion;

/**
 * @author sc
 * @date 2020/9/26
 **/

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class _104 {
    public int maxDepth(TreeNode root) {
        return findMax(root);
    }

    private int findMax(TreeNode root) {
        if (root == null) return 0;

        return Math.max(findMax(root.left), findMax(root.right)) + 1;
    }
}
