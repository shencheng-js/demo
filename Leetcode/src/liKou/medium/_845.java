package liKou.medium;


/**
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * <p>
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * <p>
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * <p>
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * <p>
 * 这个题目没有仔细思考，看的答案，找山底往山顶找，
 * 但是这种情况下不要用for循环，不好控制指针走向，用for更好
 */
public class _845 {
    public static void main(String[] args) {
        int temp[] = {2, 2, 2};
        System.out.println(new _845().longestMountain(temp));
    }

    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int len = A.length;
        int left = 0;
        int ret = 0;
        int right = left + 1;

        while (left < len - 2) {
            right = left + 1;
            if (A[left] < A[left + 1]) {
                while (right < len - 1 && A[right] < A[right + 1]) {
                    right++;
                }
                if (right < len - 1 && A[right] > A[right + 1]) {
                    while (right < len - 1 && A[right] > A[right + 1]) {
                        right++;
                    }
                    ret = Math.max(ret, right - left + 1);
                } else {
                    right++;
                }
            }
            left = right;
        }
        return ret;
    }
}
