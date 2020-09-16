package algo_Demo.dfs;

/**
 * @author sc
 * @date 2020/9/11
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。
 * 组合中只允许含有 1 - 9 的正整数，
 * 并且每种组合中不存在重复的数字。
 */

/**
 * 利用了dfs，
 *
 *
 *
 *
 *
 * ！！！！！！！！！！！
 * 然而起初自己的dfs发生了错误，在于使用dfs有两种方式：
 * 一种于dfs内使用for循环 ：添加当前元素后dfs，随后撤销
 * 另一种不适用for：对当前元素二重选择：加入或者不加入
 * 即可先添加，在dfs  随后撤销该操作，在dfs
 *
 *！！！！！！！！！！！！！
 *
 * 这就是使用第一种方式的dfs
 * 下文dfs则是第二种
 *
 * private void dfs(List<List<Integer>> res, List<Integer> list, int k, int start, int n) {
 *         //终止条件，找到一组合适的
 *         if (list.size() == k && n == 0) {
 *             res.add(new ArrayList<>(list));
 *             return;
 *         }
 *         //注意这里，因为不能有重复的集合以及集合中不能有重复的数字，所以这里的i不能从0开始，
 *         // 要从上一个选择之后的下一个值开始
 *         for (int i = start; i <= 9; i++) {
 *             //选择当前值
 *             list.add(i);
 *             //递归
 *             dfs(res, list, k, i + 1, n - i);
 *             //撤销选择
 *             list.remove(list.size() - 1);
 *         }
 *
 */
public class _216 {
    public static void main(String[] args) {

    }
    class Solution {
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            dfs(1, 9, k, n);
            return ans;
        }

        public void dfs(int cur, int n, int k, int sum) {
            if (temp.size() + (n - cur + 1) < k || temp.size() > k) {
                return;
            }
            if (temp.size() == k) {
                int tempSum = 0;
                for (int num : temp) {
                    tempSum += num;
                }
                if (tempSum == sum) {
                    ans.add(new ArrayList<Integer>(temp));
                    return;
                }
            }
            temp.add(cur);
            dfs(cur + 1, n, k, sum);
            temp.remove(temp.size() - 1);
            dfs(cur + 1, n, k, sum);
        }
    }
}
