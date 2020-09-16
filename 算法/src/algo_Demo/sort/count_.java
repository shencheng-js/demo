package algo_Demo.sort;
/*
 * 利用排序的数组判断其内各个数的个数
 * 也可利用数组实现乱序的计算,但是空间复杂度较高
 */
public class count_ {
	int [] nums = {1,2,2,2,2,3,4,4,4,5,6,7};
	public void count() {
		int times=1;
		for (int i = 0; i < nums.length-1; i++) {
			if (nums[i+1]==nums[i]) {
				times++;
			}
			else {
				System.out.println(" "+nums[i]+":"+times);
				times=1;
			}
			
		}
	}
	public static void main(String[] args) {
		count_ aCount_ = new count_();
		aCount_.count();
	}
}
