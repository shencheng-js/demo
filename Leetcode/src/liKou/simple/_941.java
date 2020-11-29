package liKou.simple;

/**
 * @auther {shen}
 * @DATE 2020-11-3
 */

/**
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 原先准备找出所有的特殊错误情况，再在中途反悔
 * <p>
 * 但是这种算法是我只管走，我只在正确情况下走，错误就不走了，所以只在最后判断是否到达终点
 */
public class _941 {
    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 4};

        System.out.println(new _941().validMountainArray(temp));

    }

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int len = A.length;
        int index = 0;
        while (index < len - 2 && A[index] < A[index + 1]) {
            index++;
//            System.out.println(index);
        }//找遍前山脚,如果没动，就错了
        if (index == 0) {
            return false;
        }
        while (index < len - 1 && A[index] > A[index + 1]) {
            index++;
//            System.out.println(index);
        }
//        System.out.println(index+"====="+(len-1));
        return index == len - 1;

    }
}
