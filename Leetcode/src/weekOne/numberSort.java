package weekOne;

public class numberSort {

	public static int[] bombSort(int a[]) {

		boolean countTimes = true;
		for (int i = 0; i < a.length - 1 && countTimes; i++) {
			countTimes = false;
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] >= a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					countTimes = true;
				}
			}
		}

		return a;

	}

	public static int[] quickSort(int a[], int left, int right) {
		if (left >= right) {
			return a;
		}
		int datum = a[left];
		int now_left = left;
		int now_right = right;
		while (now_left < now_right) {
			while (now_left < now_right && a[now_right] > datum) {
				now_right--;
			}
			a[now_left] = a[now_right];

			while (now_left < now_right && a[now_left] <= datum) {
				now_left++;
			}
			a[now_right] = a[now_left];
		}
		a[now_left] = datum;

		numberSort.quickSort(a, left, now_left - 1);
		numberSort.quickSort(a, now_left + 1, right);

		return a;

	}

	public static int[] selectSort(int a[]) {

		for (int i = 0; i < a.length; i++) {
			int min = 1000000;
			int min_i = i;
			for (int j = i; j < a.length; j++) {
				if (min >= a[j]) {
					min = a[j];
					min_i = j;
				}
			}
			a[min_i] = a[i];
			a[i] = min;

		}

		return a;

	}
	public static int[] insertSort(int a[]) {
		
		for (int i = 1; i < a.length; i++) {
			for (int j = i;j>0&&a[j]<a[j-1];j--) {
				int temp = a[j-1];
				a[j-1]=a[j];
				a[j]=temp;
			}
		}
		return a;
		
	}
	public static int[] mergeSort(int a[],int left,int right) {
		if (left==right) {
			return new int[] { a[left] };
		}
		int mid=(left+right)/2;
		
		int[] left_a = numberSort.mergeSort(a, left, mid);
		int[] right_a = numberSort.mergeSort(a, mid+1, right);
		int[] total_a=new int[left_a.length+right_a.length];
		
		int i=0,j=0,k=0;
		while (i<left_a.length&&j<right_a.length&&k<total_a.length) {
			if (left_a[i]>right_a[j]) {
				total_a[k]=right_a[j];
				j++;
				k++;
			}
			else {
				total_a[k]=left_a[i];
				i++;
				k++;
			}
		}
		while (i<left_a.length&&k<total_a.length) {
			total_a[k]=left_a[i];
			i++;
			k++;
		}
		while (j<right_a.length&&k<total_a.length) {
			total_a[k]=right_a[j];
			j++;
			k++;
		}
		return total_a;
		
	}
	public static void main(String[] args) {
		int[] nums = {9,8,7,6,5,4,3,21,1};
		nums = numberSort.mergeSort(nums,0,nums.length-1);
		for (int i :nums) {
			System.out.print(i+"  ");

		}
	}
}
