package liKou.treeQuestion;

/**
 * @author sc
 * @date 2020/9/16
 **/

/**
 * 逆转二叉树，比较简单
 */
public class _226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}

