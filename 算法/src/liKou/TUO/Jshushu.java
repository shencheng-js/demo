package liKou.TUO;

import java.util.Scanner;

/**
 * @author sc
 * @date 2020/9/10
 **/

/**
 * 题目描述
 *
 * 输入 n，求长度为 n 的数字串的个数，要求：
 *
 *     每一位为 1、2 或 3；
 *     不得连续出现 3 个相同的数字。
 *
 *     一种想法是去重，但是很麻烦
 *
 *     另一种是正向找正确的，利用树
 *     发现每组单棵子树有  3 * 2 + 2 这一规律
 *     而且随着树深度加深  逐渐变为  3^n
 *     逐层相加  *2
 */
public class Jshushu {
}
class Main{
    final static long size = (long) Math.pow(10,13);
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
     //   System.out.println(size);
        if (n==1) System.out.println(3);
        else if (n==2) System.out.println(9);
        else{
            System.out.println(count(n));
        }
    }

    private static long count(int n) {
        long[] three = new long[n+1];
        calculateThree(three);
        return three[n];
    }

    private static void calculateThree(long[] three) {
        three[1] = 3;
        three[2] = 9;
        for (int i = 3; i <three.length; i++) {
            three[i] = ((three[i-1]+three[i-2])*2)%size;
        }
    }
}
