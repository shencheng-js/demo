package liKou.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author sc
 * @date 2020/9/18
 **/

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class _47 {

}

class Solution {

    List<List<Integer>> ret = new ArrayList<>();
    Set<List<Integer>> tempret = new TreeSet<>();

    public static void main(String[] args) {
        int[] tempInt = {1, 1, 2};
        System.out.println(new Solution().permuteUnique(tempInt));
    }

    public static void swap(int[] arr, int i, int j) {
        // 交换函数
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        all_Sort(nums, 0, nums.length);
        ret.addAll(tempret);
        return ret;
    }

    private void all_Sort(int[] nums, int start, int target) {
        if (start == target) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            tempret.add(temp);
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            all_Sort(nums, start + 1, target);
            swap(nums, i, start);
        }
    }
}
