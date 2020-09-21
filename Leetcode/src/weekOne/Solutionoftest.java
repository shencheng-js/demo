package weekOne;

public class Solutionoftest {

    public static void main(String[] args) {
//		Solution aSolution = new Solution();
        int[] a = {1, 0};
        System.out.println();

    }
}
/*
class Solution {
	public int maxProfit(int[] prices) {
		//hold为第i天的持有股票的收益
		//unhold是手上没有的收益
		int hold[] = new int[prices.length];
		int unhold[] = new int[prices.length];
		hold[0] = -prices[0];
		unhold[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			if (i == 1) { // base case
				hold[i] = Math.max(hold[i - 1], -prices[1]);
			}
			else {
				hold[i] = Math.max(hold[i-1], unhold[i-2]-prices[i]);
			}
			unhold[i]=Math.max(unhold[i - 1], hold[i - 1] + prices[i]);
		}

		return unhold[prices.length - 1];
	}
}*/



/*
class Solution {
    public boolean isPalindrome(String s) {
    	if (s==null) {
			return false;
		}
    	int left = 0;
    	int right = s.length()-1;
    	char leftchar;
    	char rightchar;
    	s = s.toLowerCase();
        while (left<right) {
        	leftchar=s.charAt(left);
//        	System.out.println(leftchar);
        	
			if (!Character.isLetter(leftchar)||!Character.isDigit(leftchar)) {
				left++;
//				System.out.println("空格"+s.charAt(left-1));
				continue;
				
			}
			rightchar=s.charAt(right);
			if (!Character.isLetter(rightchar)||) {
				right--;
//				System.out.println("空格"+s.charAt(right+1));
				continue;
			}
			if (s.charAt(left)!=s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
        return true;
    }
}*/


/*
class Solution {
    public List<Integer> countSmaller(int[] nums) {
    	 ArrayList<Integer> resultList = new ArrayList<Integer>(); 
    	Arrays.parallelSort(nums);
    	
    }
}*/