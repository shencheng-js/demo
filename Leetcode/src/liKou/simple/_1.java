package liKou.simple;

/**
 * @author sc
 * @date 2020/10/3
 **/


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 暴力找就完事了，当然，也可以用哈希表
 */
public class _1 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5};
        int ret[] = new _1().twoSum(nums, 3);
        System.out.println(ret[0] + "        " + ret[1]);

    }

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] ret = new int[2];
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                ret[0] = i;
                ret[1] = map.get(target - nums[i]);
            }
        }

        return ret;
    }
}
