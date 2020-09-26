package liKou.dp;

/**
 * @author sc
 * @date 2020/9/1
 **/
public class _486 {
}

class Solution2 {
    public boolean PredictTheWinner(int[] nums) {
        int left = 0;
        int len = nums.length;
        int right = len - 1;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = len - 2; i > 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }

}
