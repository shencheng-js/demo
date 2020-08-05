package weekOne;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		Solution aSolution = new Solution();
		int[][] A = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };

		System.out.println(aSolution.calculateMinimumHP(A));

//		System.out.println(aSolution.numSubarraysWithSum(A, 2));
	}
}

class Solution1 {
	public int numSubarraysWithSum(int[] A, int S) {
		int count = 0;
		int right = 0;
		int left = 0;
		int sum = 0;

		while (right < A.length - 1) {

			if (sum == S) {
				count++;
				sum -= A[left++];

			} else if (sum < S) {
				sum += A[right++];

			}
		}

		return count;

	}
}

class Solution {
	public int calculateMinimumHP(int[][] dungeon) {
		int[][] dp = new int[dungeon.length][dungeon[0].length];
		dp[0][0] = dungeon[0][0];

		int max = -1;
		for (int i = 1; i < dp.length; i++) {

			dp[0][i] = dp[0][i - 1] + dungeon[0][i];

		}

		for (int i = 1; i < dp[0].length; i++) {

			dp[i][0] = dp[i - 1][0] + dungeon[i][0];
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp.length; j++) {
				dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]);
				max = Math.min(max, dp[i][j]);
			}

		}
		return Math.abs(max);

	}
}