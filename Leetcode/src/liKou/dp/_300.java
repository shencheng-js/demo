package liKou.dp;

/**
 * @author sc
 * @date 2020/10/6
 **/

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * <p>
 * <p>
 * 其实还好，用一维数组dp[j]表示从头到j的最长上升子序列
 * <p>
 * 其实需要计算从每一位开始能得到的   最长上升子序列
 * <p>
 * <p>
 * <p>
 * <p>
 * 好好考虑现在：对于每一位i，参考之前的j位，如果i>j那么当前i选择max（i，j+1）
 * <p>
 * 就是说当前以i结尾的，从头开始找子序列，如果有一个比他小的j，那么他等于Math.max(dp[i], dp[j] + 1)，
 * 即在j的max子序列基础上加i，而如果出现3 1 2 3 i=4这种情况
 */
public class _300 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
//    public int lengthOfLIS(int[] nums) {
//        int len = nums.length;
//        if (len < 2) return len;
//        int[] dp = new int[len + 1];
//        dp[0] = 1;
//        int maxn = 0;
//
//        for (int i = 1; i < len; i++) {
//            int nowMax = 0;
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//                    nowMax = Math.max(nowMax, dp[j]);
//                }
//            }
//            dp[i] = nowMax + 1;
//            maxn = Math.max(maxn, dp[i]);
//        }
//        return maxn;
//    }


}
