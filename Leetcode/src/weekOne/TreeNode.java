package weekOne;

import java.util.Scanner;

public class TreeNode {
    public static void main(String[] args) {
        myway aSolution = new myway();
        aSolution.isMatch("", "weqwe.eqwe.dasd*weqw");
    }
}

/*
class Solution {
	public int maxProduct(int[] nums) {
		int res = nums[0];
		int max[] = new int[nums.length];
		int min[] = new int[nums.length];
		max[0] = nums[0];
		min[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
           
            if(nums[i-1]==0){
                max[i]=nums[i];
                min[i]=nums[i];
                res = Math.max(res, max[i]);
                continue;
            }
            

			if (nums[i] > 0) {
				max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
				min[i] = Math.min(min[i - 1] * nums[i],nums[i]);
			}else{
                max[i] = Math.max(max[i - 1] * nums[i], nums[i]);;
				min[i] = Math.min(max[i - 1] * nums[i],nums[i]);
            }
			res = Math.max(res, max[i]);
		}

		return res;
	}
}*/
class myway {
    public boolean isMatch(String s, String p) {
        Scanner read_p = new Scanner(p);
        String replaceString = p;
        String aString = replaceString.replace('.', '*');
        System.out.println(p);
        System.out.println(replaceString);
        System.out.println(aString);
        return false;
    }
}