package liKou.dp;

/**
 * @author sc
 * @date 2020/10/7
 **/

/**
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * <p>
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * <p>
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * <p>
 * 返回 A 的最大湍流子数组的长度。
 * <p>
 * <p>
 * 我的理解是：在i到j的左闭右开区间里，要么奇数位大于偶数
 * <p>
 * 形成波动即可
 */
public class _978 {
    public int maxTurbulenceSize(int[] A) {
        int N = A.length;
        int ans = 1;         //最长序列
        int anchor = 0;        //锚点，当遇到不符合条件的地方在此重新下锚

        for (int i = 1; i < N; ++i) {
            int c = Integer.compare(A[i - 1], A[i]);
            if (i == N - 1 || c * Integer.compare(A[i], A[i + 1]) != -1) {     //当遇到最后一位或者是前后对比相同时下锚
                if (c != 0) ans = Math.max(ans, i - anchor + 1);    //看看这一次航行多远，找最远的距离
                anchor = i;        //再次下锚
            }
        }
        return ans;
    }
}
