package liKou.treeQuestion;

/**
 * @author sc
 * @date 2020/9/26
 **/

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * 递归深度搜索，为null返回0，而逐次加1
 */

public class _110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return ((Math.abs(dfs(root.left) - dfs(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right));
        }
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        else {
            return Math.max(dfs(root.left), dfs(root.right)) + 1;
        }
    }
}
