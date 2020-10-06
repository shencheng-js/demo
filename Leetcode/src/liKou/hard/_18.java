package liKou.hard;

/**
 * @author sc
 * @date 2020/10/5
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 * <p>
 * 好像就是用dfs可以，但是n^4   去重咋办
 * <p>
 * 可以用两重循环后，使用双指针，
 */
public class _18 {
    public static void main(String[] args) {
        int[] ints = {1, 0, -1, 0, -2, 2};
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null) return ret;
        int len = nums.length;
        if (len < 4) return ret;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            if (nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[j] + nums[i] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }

                int left = j + 1;
                int right = len - 1;

                int nowTarget = target - nums[i] - nums[j];

                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == nowTarget) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;

                    } else if (sum < nowTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ret;
    }


//    Set<List<Integer>> ret = new HashSet<List<Integer>>();
//    List<List<Integer>> ret1 = new ArrayList<List<Integer>>();
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        List<Integer> temp = new ArrayList<Integer>();
//
//        if (nums==null) return ret1;
//        dfs(nums,target,0,temp,0,0);
//        System.out.println(ret);
//        ret1.addAll(ret);
//        return ret1;
//    }
//
//    private void dfs(int[] nums, int target, int now,List<Integer> temp, int start, int step) {
//        if (target == now &&step == 4){
//            ret.add(temp);
//            System.out.println("运行ing+ret"+ret);
//            return;
//        }
//        if (step == 4){
//            return;
//        }
//
//        for (int i = start; i < nums.length; i++) {
//            temp.add(nums[i]);
//            dfs(nums,target,now+nums[i],temp,start+1,step+1);
//            temp.remove(temp.size()-1);
//        }
//    }


}
