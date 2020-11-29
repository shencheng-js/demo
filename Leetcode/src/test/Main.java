package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @auther {shen}
 * @DATE 2020-11-3
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int temp = in.nextInt();
        int result = 0;

        List<Integer> list = chai(temp);
        System.out.print(temp + ",");
        for (int i = 0; i < list.size(); i++) {
            result += cal(list.get(i));
            if (i != list.size() - 1)
                System.out.print(list.get(i) + "!" + "+");
            else {
                System.out.print(list.get(i) + "!");
            }
        }
        System.out.println("=" + result);
        if (result == temp) {
            System.out.println("Yes!");
        } else {
            System.out.println("No");
        }
//        System.out.println(cal(3));
    }

    private static List<Integer> chai(int temp) {
        List<Integer> ret = new ArrayList<>();
        while (temp > 0) {
            ret.add(temp % 10);
            temp /= 10;
        }
        Collections.reverse(ret);
        return ret;
    }

    private static int cal(int temp) {
        int ret = 1;
        for (int i = 1; i <= temp; i++) {
            ret *= i;
        }
        return ret;
    }
}
