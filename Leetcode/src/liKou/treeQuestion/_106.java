package liKou.treeQuestion;

/**
 * @author sc
 * @date 2020/9/25
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 思路与105近似
 */
public class _106 {
    int post_idx;
    /* Map<Integer, Integer> map = new HashMap<Integer, Integer>();

     public Tree.TreeNode buildTree(int[] inorder, int[] postorder) {
         int len = inorder.length;
         for (int i = 0; i < len; i++) {
             map.put(inorder[i], i);
         }
         return Recursion(inorder, postorder, 0, len - 1, 0, len - 1);
     }

     private Tree.TreeNode Recursion(int[] inorder, int[] postorder, int inleft, int inright, int posleft, int posright) {
         if (posleft > posright) return null;

         int rootIndex = map.get(postorder[posright]);

         int leftTree = rootIndex - inleft;

         System.out.println("这一轮的根是： "+postorder[posright]+"  "+leftTree+"   "+rootIndex);
         Tree.TreeNode temp = new Tree.TreeNode(postorder[posright]);
         if (leftTree<=0) return temp;
           temp.left = Recursion(inorder, postorder, inleft, inleft + leftTree, posleft, posleft + leftTree-1);
         temp.right = Recursion(inorder, postorder, inleft + leftTree + 1, inright, posleft + leftTree + 1, posright--);


         return temp;
     }*/
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        int[] q = {9, 3, 15, 20, 7};
        int[] w = {9, 15, 7, 20, 3};
        new _106().buildTree(q, w);
    }

    public TreeNode helper(int left, int right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (left > right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 构造右子树
        root.right = helper(index + 1, right);
        // 构造左子树
        root.left = helper(left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }

}
