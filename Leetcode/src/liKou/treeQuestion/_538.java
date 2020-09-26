package liKou.treeQuestion;

/**
 * @author sc
 * @date 2020/9/21
 **/


import java.util.Stack;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 * 二叉搜索树即为左大右小那种
 * 而累加则是可以利用中序遍历，但是是逆序中序遍历
 * <p>
 * 从左至右边或者从右至左
 */
public class _538 {

    public static void main(String[] args) {
        Integer[] temp = {1, 2, 3};
        TreeNode root = TreeNode.convert(temp);
        System.out.println(root.val);
        inOrder(root);

    }

    private static TreeNode inOrder(TreeNode root) {
        liKou.treeQuestion.TreeNode temp = root;
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();


        int sum = 0;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.right;
            } else {
                root = stack.pop();
                //System.out.println("当前val"+" "+root.val);
                root.val += sum;
                sum = root.val;
                System.out.println(sum);
                root = root.left;
            }
        }
        return temp;
    }//中序遍历

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
