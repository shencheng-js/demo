package liKou.hard;


/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * <p>
 * <p>
 * 先求和sum，如果是奇数显然不可以，否则就看能不能找到和等于sum/2的数组子数组
 * <p>
 * 思路前一截没啥大毛病，后面没必要用dfs哈哈，太大了，机器顶不住，用动态规划即可
 * 而且动态规划这里不要盯着如何凑出sum/2，要考虑每一个数能凑出的情况
 */
public class _416 {
    int result;

    public static void main(String[] args) {
        int[] temp = {1, 5, 5, 11};
        System.out.println(new _416().canPartition(temp));
    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len < 2) return false;
        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }
        System.out.println(sum);
        if (sum % 2 == 1) {
            return false;
        }
        result = sum / 2;
//        System.out.println(result+" "+maxNum);
        if (maxNum > result) {
            return false;
        }
        boolean[][] dp = new boolean[len][result + 1];
        dp[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= result; j++) {
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][result];
    }

//    private boolean dfs(int[] nums, int i, int nowSum) {
//        if (nowSum==result&&i<=nums.length-1)return true;
//        else if (i>nums.length-1) return false;
//        else {
////            System.out.println("此时i:"+i+",sum="+nowSum);
//            return dfs(nums,i+1,nowSum)||dfs(nums,i+1,nowSum+nums[i]);
//        }
//    }


}
