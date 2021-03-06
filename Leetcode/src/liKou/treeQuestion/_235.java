package liKou.treeQuestion;

/**
 * @author sc
 * @date 2020/9/27
 **/


/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 一.
 * 可以利用分别遍历到p与q的路径，再加以遍历找到最后一个公共的节点
 * （不是二叉搜索树也可以利用此方法解决问题）
 * <p>
 * 二.
 * 利用二叉树性质，即左小右大，进而寻找   root    ，root 应该是于p，与q之间，
 * 如果都比root大，则去root。right找；反之亦然
 * <p>
 * <p>
 * <p>
 * ***********题目自己先想，累了就歇着*******************
 */
public class _235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;

        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
}
