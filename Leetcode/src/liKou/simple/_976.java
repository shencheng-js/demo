package liKou.simple;

/**
 * @auther {shen}
 * @DATE 2020-11-29
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * <p>
 * <p>
 * 多动脑子，排序后必然后面比前面大，只要小的两个加起来比最后一个大就可以了
 */
public class _976 {
    public static void main(String[] args) {

//        System.out.println(new _976().largestPerimeter(temp));

    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
//      无法使用Arrays的方法放int型数组，应为他是一个链接
        Set<Integer> set = new HashSet<Integer>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            set.add(A[i]);
        }
        len = set.size();
//        System.out.println(set.size());
        for (int i = len - 1; i > 1; i--) {
            for (int j = i - 1; j > 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    int flag = weather(A[i], A[j], A[k]);
                    if (flag != 0) {
                        return flag;
                    }
                }
            }
        }
        return 0;
    }

    private int weather(int i, int j, int k) {
        if ((i + j) > k && (i + k) > j && (j + k) > i) {
            return (i + j + k);
        } else return 0;
    }
}
