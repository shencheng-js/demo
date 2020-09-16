package liKou.treeQuestion;

/**
 * @author sc
 * @date 2020/8/28
 **/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * <p>
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 */
public class _863 {


    public static void main(String[] args) {
        /*Integer [] temp = {1,2,3,4,5,6,7,8,9,10};
        TreeNode root = new TreeNode().convert(temp);
        Solution solution = new Solution();
        TreeNode first = root.left.right;*/
    }

}

class Solution {

    static List<Integer> ret = new ArrayList<>();
    public static void main(String[] args) {
        Integer[] temp = {1};
        TreeNode root = new TreeNode().convert(temp);
        TreeNode target = root;
        distanceK(root, target, 2);
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ret = new ArrayList<>();
        if (root == null || target == null) {
            return ret;
        }
        find_downNode(target, K,ret);
        find_upNode(root, target, K,ret);
        return ret;
    }


    public static void find_downNode(TreeNode root, int foot, List<Integer> ret) {
        if (root == null) {
            return;
        }
        if (foot == 0) {
            ret.add(root.val);
            return;
        }
        find_downNode(root.left, foot - 1, ret);
        find_downNode(root.right, foot - 1, ret);
    }


    private static void find_upNode(TreeNode root, TreeNode nowroot, int foot, List<Integer> ret) {
        if (foot == 0) {
            ret.add(nowroot.val);
            return;
        }
        if (root == nowroot) {
            return;
        }
        if (nowroot == root.left) {
            if (foot == 1) {
                ret.add(root.val);
                return;
            } else {
                find_downNode(root.right, foot - 2,ret);
            }
        } else if (nowroot == root.right) {
            if (foot == 1) {
                ret.add(root.val);
                return;
            } else {
                find_downNode(root.left, foot - 2,ret);
            }
        } else {
            TreeNode fathernode = find_fathernode(nowroot, root);
            if (fathernode.left == nowroot) {
                find_downNode(fathernode.right, foot - 2,ret);
            } else {
                find_downNode(fathernode.left, foot - 2,ret);
            }

            find_upNode(root, fathernode, foot - 1,ret);
        }
    }

    public static TreeNode find_fathernode(TreeNode nowroot, TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();

        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode temp = nodeQueue.poll();
            if (temp.left == nowroot || temp.right == nowroot) {
                return temp;
            } else {
                if (temp.right != null) {
                    nodeQueue.add(temp.right);
                }
                if (temp.left != null) {
                    nodeQueue.add(temp.left);
                }
            }
        }
        return null;
    }

}