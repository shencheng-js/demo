package liKou;

import java.util.*;

/**
 * @author sc
 * @date 2020/9/12
 **/
public class _637 {
    public static void main(String[] args) {

        Integer [] temp = {1,2,3,null,4,5,6,7,8,9,10};
        TreeNode root = new TreeNode().convert(temp);
        Solution solution = new Solution();

        System.out.println(solution.averageOfLevels(root));
    }
    static class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            if (root == null) return null;
            List<Double> ret = new ArrayList<Double>();
            Queue<TreeNode> temp = new LinkedList<>();
            double floorsum = 0;
            int quequesum = 1;
            temp.offer(root);
            while (!temp.isEmpty()) {
                quequesum = temp.size();
                for (int i = 0; i < quequesum; i++) {
                    TreeNode temptree = temp.poll();
                    floorsum += temptree.val;
                    if (temptree.left != null) temp.add(temptree.left);
                    if (temptree.right != null) temp.add(temptree.right);
                }
                ret.add(floorsum / quequesum);
                floorsum = 0;
            }
            return ret;
        }
    }
}
