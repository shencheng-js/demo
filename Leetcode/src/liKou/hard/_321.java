package liKou.hard;

/**
 * @auther {shen}
 * @DATE 2020-12-2
 */

/**
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
 * 现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * <p>
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * <p>
 * <p>
 * <p>
 * 其实就是将两个数组缩减规模后进行拼接，这里缩减规模时用到一个新的知识点，
 * <p>
 * 单调栈
 * 自定义比较方法（合并时相等情况下，看看谁的后面更大，提前让更大的出来）
 * <p>
 * 变态的一题
 */
public class _321 {
    public static void main(String[] args) {
        int[] temp1 = new int[]{6, 7};
        int[] temp2 = new int[]{6, 0, 4};
        int[] ret = new _321().maxNumber(temp1, temp2, 5);
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + "  ");
        }
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int leMin = Math.max(0, k - len2), leMax = Math.min(len1, k);
        int ret[] = new int[k];
        //对于num1进行不同规模的挑选单调栈
        for (int i = leMin; i <= leMax; i++) {
            int left[] = Monotonous_stack(nums1, i);
            int right[] = Monotonous_stack(nums2, k - i);

            int temp[] = Merge(left, right);
            if (compare(temp, ret)) {
                ret = temp;
            }
        }

        return ret;
    }

    private boolean compare(int[] temp, int[] ret) {
        int len = temp.length;
        for (int i = 0; i < len; i++) {
            if (temp[i] == ret[i]) {
                continue;
            } else if (temp[i] > ret[i]) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }

    private int[] Merge(int[] left, int[] right) {
        int leftIndex = 0, leftLen = left.length;
        int rightIndex = 0, rightLen = right.length;
        if (leftLen == 0) {
            return right;
        }
        if (rightLen == 0) {
            return left;
        }

        int sumIndex = 0;
        int ret[] = new int[leftLen + rightLen];

        for (int i = 0; i < leftLen + rightLen; i++) {
            if (compare(left, leftIndex, right, rightIndex) > 0) {
                ret[i] = left[leftIndex++];
            } else {
                ret[i] = right[rightIndex++];
            }
        }
        return ret;

    }

    private int[] Monotonous_stack(int[] nums1, int i) {//单调栈实现
        int[] stack = new int[i];
        int len = nums1.length;
        int top = -1;//设置为-1，和栈的实现过程中类似
        int remain = len - i;//表示可以浪费的位置
        for (int j = 0; j < len; j++) {
            int temp = nums1[j];
            //在何时浪费当前temp
            while (top >= 0 && stack[top] < temp && remain > 0) {  //在遇到比栈顶大的数的时候浪费栈顶，给新人腾位置
                top--;
                remain--;
            }
            if (top < i - 1) {
                stack[++top] = temp;//当前没有浪费位置所以remain不变
            } else {
                //栈装满了，但是后续可能遇到好的，但是暂时没遇到，先浪费
                remain--;
            }
        }
//        for (int k = 0; k < i; k++) {
//            System.out.print(stack[k]+"  ");
//        }
        return stack;
    }
}
