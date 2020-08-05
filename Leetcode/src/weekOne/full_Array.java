package weekOne;

import java.util.Scanner;

/*
 *   7/6全排列算法,尚未手敲过
 */
public class full_Array {
	/*
	 * static int count=0; public static void check(int n,int[] a,int N){//换位函数 int
	 * i; if(n==N){//符合条件输出 Put(a); } for(i=n;i<N;i++){ int x=a[n]; a[n]=a[i];
	 * a[i]=x; check(n+1,a,N);//考虑下面分叉 x=a[n]; a[n]=a[i];//回溯 a[i]=x; } } public
	 * static void Put(int[] a){//输出函数 int i; for (i=0;i<a.length;i++){
	 * System.out.print(a[i]+" "); } System.out.println(); count++; }
	 * 
	 * 
	 * public static void main(String[] args) { Scanner in = new Scanner(System.in);
	 * int num=in.nextInt(); int []myarray = new int[num+1]; for (int i = 0; i <
	 * myarray.length; i++) { myarray[i] = i+6; } full_Array.check(0, myarray, num);
	 * System.out.println(count); }
	 */
	public static int count = 0;

	public static void main(String[] argv) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();// 输入N 这里用于输出1到N的全排列
		int[] key = new int[N];
		for (int i = 0; i < key.length; i++) {
			key[i] = i + 1;
		}
		check(0, key, N);
	}

	public static void check(int n, int[] a, int N) {// 换位函数
		int i;
		if (n == N) {// 符合条件输出
			Put(a);
		}
		for (i = n; i < N; i++) {
			int x = a[n];
			a[n] = a[i];
			a[i] = x;
			check(n + 1, a, N);// 考虑下面分叉
			x = a[n];
			a[n] = a[i];// 回溯
			a[i] = x;
		}
	}

	public static void Put(int[] a) {// 输出函数
		int i;
		for (i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	
	
	public static void dictionary_order(int[]a){
		int left=0;
		int right=a.length;
		
	}
}
