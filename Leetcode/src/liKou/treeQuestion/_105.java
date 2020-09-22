package liKou.treeQuestion;

/**
 * @author sc
 * @date 2020/9/22
 **/


import java.util.HashMap;
import java.util.Map;

/**
 * 据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 二叉树两种遍历方式：
 * 前序遍历：  根节点+左子树+右子树
 * 中序遍历:   左子树+根节点+右子树
 * 后序遍历：  左子树+右子树+根节点
 * <p>
 * <p>
 * 因而可以利用中序的根节点左右划分子树，递归完成
 */
public class _105 {
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<Integer, Integer>();
        int len = preorder.length;
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        TreeNode ret = makeBtree(preorder, inorder, 0, len - 1, 0, len - 1);
        return ret;
    }

    private TreeNode makeBtree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int preorder_root = preLeft;

        int genIndex = map.get(preorder[preorder_root]);//中序遍历得到根节点位置


        int leftTree = genIndex - inLeft;//左子树的长度
        TreeNode nowGen = new TreeNode(preorder[genIndex]);
        nowGen.left = makeBtree(preorder, inorder, preLeft + 1, preRight + leftTree, inLeft, genIndex - 1);
        nowGen.right = makeBtree(preorder, inorder, preLeft + leftTree + 1, preRight, genIndex + 1, inRight);

        return nowGen;
    }
}

