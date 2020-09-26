package liKou.treeQuestion;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * @author sc
 * @date 2020/9/26
 **/

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * bfs即可
 */
public class _102 {

    public static void main(String[] args) {
        Integer[] temp = {3, 9, 20, null, null, 15, 7};
        TreeNode source = TreeNode.convert(temp);
        System.out.println(new _102().levelOrder(source));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> insert = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                insert.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            ret.add(insert);
        }
        return ret;
    }
}
