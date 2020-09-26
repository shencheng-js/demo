package liKou.treeQuestion;

import java.util.*;

/**
 * @author sc
 * @date 2020/9/26
 **/
public class _103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        boolean flag = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> insert = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                insert.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            if (flag) {
                Collections.reverse(insert);
            }
            ret.add(insert);
            flag = !flag;
        }
        return ret;
    }
}
