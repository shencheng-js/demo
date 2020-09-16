package algo_Demo.copy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_bag {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		Thing[] things = new Thing[3];
//		things[0] = new Thing(2, 200);// 100
//		things[1] = new Thing(1, 200);// 200
//		things[2] = new Thing(2, 300);// 150
//		Arrays.sort(things);
//		for (int i = 0; i < things.length; i++) {
//			System.out.println(things[i].value + " " + things[i].weight);
//
//		}

		System.out.println("请输入背包容量以及物品数量");
		int capa = in.nextInt();// 背包容量
		int num = in.nextInt();// 物品数量
		double money = 0;//
		Thing[] things = new Thing[num];

		for (int i = 0; i < things.length; i++) {// 装载物品的重量与价格

			System.out.println("请输入第" + (i + 1) + "件物品的重量与价格");
			int wei = in.nextInt();
			int value = in.nextInt();
			things[i] = new Thing(wei, value);
		}

		Arrays.sort(things);// 对物品排序,价值和重量之比更大的靠前

		for (int i = 0; capa > 0&&i<things.length; i++) {// 装载物品的重量与价格
			if (capa > things[i].weight) {
				money += things[i].value;
				System.out.println("第" + (i + 1) + "步" + "装入重量为" + things[i].weight + "价值为" + things[i].value + "的物品");
				System.out.println("现在总价格为" + money + "剩余容积为" + capa);
				capa -= things[i].weight;
			} else {
				money += (double) things[i].value * ((double) capa / things[i].weight);
				int fenmu = maximum.findone(capa, things[i].weight);
				System.out.println("第" + (i + 1) + "步" + "当前物品无法完全放入,只能放入" + capa / fenmu + "/"
						+ things[i].weight / fenmu + "的重量为" + things[i].weight + "价值为" + things[i].value + "的物品");
				System.out.println("现在总价格为" + money + "且容积用光");
				capa = 0;
			}

		}

	}
}

class Thing implements Comparable<Thing> {
	public int weight;
	public int value;

	public Thing(int weight, int value) {
		// TODO 自动生成的构造函数存根
		this.value = value;
		this.weight = weight;
	}

	@Override
	public int compareTo(Thing o) {
		// TODO 自动生成的方法存根
		if (this.value / this.weight > o.value / o.weight) {
			return -1;
		} else if (this.value / this.weight == o.value / o.weight) {
			return 0;
		}
		return 1;
	}

}

class maximum {
	public static int findone(int a, int b) {
		int flag = 0;
		for (int i = 1; i < Math.min(a, b); i++) {
			if (a % i == 0 && b % i == 0) {
				flag = i;
			}
		}
		return flag;
	}
}