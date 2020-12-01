package liKou.medium;

/**
 * @auther {shen}
 * @DATE 2020-12-1
 */

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 暴力就很简单，顺序找到target开始和结束，但是这个数组为升序，可以利用二分查找
 * <p>
 * 考察二分查找，为了代码复用，大于等于和大于不同的
 */
public class _34 {
    public static void main(String[] args) {
        int temp[] = new int[]{1};
        int ret[] = new _34().searchRange(temp, 1);
        System.out.println(ret[0] + "  " + ret[1]);

    }

    public int[] searchRange(int[] nums, int target) {
        int leftindex = bineryserach(nums, target, true); //找大于等于的第一个
        int rightindex = bineryserach(nums, target, false) - 1; //找大于的第一个
        if (leftindex >= 0 && rightindex < nums.length && rightindex >= leftindex) {
            return new int[]{leftindex, rightindex};
        }

        return new int[]{-1, -1};
    }

    private int bineryserach(int[] nums, int target, boolean flag) {
        int left = 0;
        int right = nums.length - 1;
        int ret = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid] || (flag && target <= nums[mid])) {  //利用这个不停逼近，每次更新位置
                right = mid - 1;
                ret = mid;
            } else {
                left = mid + 1;
            }
        }
        return ret;
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
