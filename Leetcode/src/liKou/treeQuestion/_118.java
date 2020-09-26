package liKou.treeQuestion;

/**
 * @author sc
 * @date 2020/9/26
 **/
public class _118 {
    int[] numTree;

    public TreeNode sortedArrayToBST(int[] nums) {
        numTree = nums;
        return makeTree(0, nums.length - 1);
    }

    private TreeNode makeTree(int start, int end) {
        if (start > end) return null;
        int medium = (start + end) / 2;
        TreeNode temp = new TreeNode(numTree[medium]);
        temp.left = makeTree(start, medium - 1);
        temp.right = makeTree(medium + 1, end);
        return temp;
    }
}