package liKou.simple;


/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * <p>
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 */
public class lc_3 {
    public static void main(String[] args) {
        int[] temp = {1, 2, 4, 3};
        System.out.println(new lc_3().pivotIndex(temp));
    }

    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int tempSum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        for (int i = 0; i < len - 1; i++) {
            if (tempSum * 2 == sum - nums[i]) return i;
            tempSum += nums[i];
        }
        return -1;
    }
}
