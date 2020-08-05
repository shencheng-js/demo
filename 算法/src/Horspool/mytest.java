package Horspool;

import java.util.Scanner;

public class mytest {
	int b;
	int test(int a) {
		if(this.b==a)return 1;
		return 0;
	}
	public mytest(int a) {
		this.b=a;
	}
	public static void main(String[] args) {
//		Scanner in =new Scanner(System.in);
//		mytest as=new mytest(in.nextInt());
//		if(as.test(3)==1)System.out.println("right");
//		else {
//			System.out.println("error");
//		}
		System.out.println("horspool".toUpperCase());
	}
}
