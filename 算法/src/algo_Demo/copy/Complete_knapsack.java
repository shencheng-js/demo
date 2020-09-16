package algo_Demo.copy;

import java.util.Scanner;

public class Complete_knapsack {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入物品种类");
		int thing_num=in.nextInt();
		System.out.println("请输入背包容量");
		int capacity=in.nextInt();
		int [][]thing_detail=new int[thing_num][2];
		for (int i = 0; i < thing_num; i++) {
			if (in.nextInt()>capacity) {
				continue;
			}
			thing_detail[i][0]=in.nextInt();
			thing_detail[i][1]=in.nextInt();
		}
	}
}
