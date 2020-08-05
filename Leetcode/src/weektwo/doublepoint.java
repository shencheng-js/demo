package weektwo;

import java.util.Arrays;

public class doublepoint {

	public static void main(String[] args) {
		Solution aSolution = new Solution();
		int[] a = { 1, 3, 5, 6 };
		System.out.println(16>>3);
	}

}

class Solution {
	public int searchInsert(int[] nums, int target) {

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				return i;
			}
			if (nums[i] > target) {
				return i;
			}
		}
		return nums.length;

	}
}