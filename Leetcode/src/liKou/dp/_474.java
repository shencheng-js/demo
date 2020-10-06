package liKou.dp;

/**
 * @author sc
 * @date 2020/10/6
 **/


/**
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 * <p>
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 * <p>
 * 首先将字符串数组化为数组，   2n为第n个字符串0的数量，而2n+1则是1的数量
 * <p>
 * 啥子是变的？m和n    dp[i][j]表示i个0和j个1能表示的最多字符串
 * <p>
 * dp[0][0] = 0,且当前数量不符合时不变，求max
 */
public class _474 {

    public static void main(String[] args) {
        String[] temp = {"10", "0001", "111001", "1", "0"};

        System.out.println(new _474().findMaxForm(temp, 5, 3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[] str = handleStrs(strs);
        int[][] dp = new int[m + 1][n + 1];
        int len = strs.length;
//        Arrays.fill(dp,0);
        for (int k = 0; k < len; k++) {
            int my0 = str[2 * k];
            int my1 = str[2 * k + 1];

            for (int i = m; i >= my0; i--) {
                for (int j = n; j >= my1; j--) {
                    if (i >= my0 && j >= my1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - my0][j - my1] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    private int[] handleStrs(String[] strs) {
        int[] ret = new int[1024];
        for (int i = 0; i < strs.length; i++) {
            String temp = strs[i];
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '0') {
                    ret[2 * i]++;
                } else {
                    ret[2 * i + 1]++;
                }
            }
        }
        return ret;
    }
}
