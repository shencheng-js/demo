package liKou.dp;

/**
 * @author sc
 * @date 2020/10/6
 **/

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 动态规划 备忘录
 * <p>
 * <p>
 * 如果凑不出x块钱，那么对于每一个（coin+x）都凑不出来
 */
public class _322 {


    public static void main(String[] args) {
        int[] temp = {1, 3, 5};
        System.out.println(new _322().coinChange(temp, 11));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        int[] memo;//用memo的第i位表示金额为i时最少需要的硬币数
        memo = new int[amount + 1];
        Arrays.fill(memo, 99999999);
        memo[0] = 0;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (coin <= i) memo[i] = Math.min(memo[i], memo[i - coin] + 1);
            }
        }

        if (memo[amount] != 99999999) {
            return memo[amount];
        } else {
            return -1;
        }

    }
}
