package liKou.simple;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 没必要第一次找0，从两端找就可以，因为-1和1都算
 */
public class _977 {
    public static void main(String[] args) {
        int[] temp = {-4, -1, 0, 3, 10};
        System.out.println(new _977().sortedSquares(temp));
    }

    public int[] sortedSquares(int[] A) {
        int len = A.length;
        if (len < 1) {
            return A;
        }
        int[] ret = new int[len];
        int index = 0;
        int zheng = 0;
        int fan = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] >= 0) {
                zheng = i;
                break;
            }
        }
        fan = zheng - 1;
        while (zheng <= len - 1 && fan >= 0) {
            System.out.println(zheng + "   " + fan);
            if (A[zheng] < -A[fan]) {
                ret[index] = A[zheng] * A[zheng];
                index++;
                zheng++;

            } else {
                ret[index] = A[fan] * A[fan];
                index++;
                fan--;
            }

        }

        while (zheng <= len - 1) {
            ret[index] = A[zheng] * A[zheng];
            index++;
            zheng++;
        }
        while (fan >= 0) {
            ret[index] = A[fan] * A[fan];
            index++;
            fan++;
        }
        return ret;
    }
}
