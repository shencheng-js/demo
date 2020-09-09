package BLUE.week2;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sc
 * @date 2020/8/26
 **/


/*
 *
 * Definition for a binary tree node.

 */
class TreeNode1 {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode1(int x) {
        val = x;
    }
}

public class bfs_lk {
    public static  List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> ans = new LinkedList<>();

        Queue<TreeNode> temp = new LinkedList<>();

        ans.get(1).add(2);
        System.out.println(ans.get(1).get(2));

        return null;

    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new LinkedList<>();
        ans.get(0).add(2);
        System.out.println(ans.get(1).size());
        //levelOrderBottom(null);

    }
}
