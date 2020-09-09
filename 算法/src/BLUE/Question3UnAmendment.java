package BLUE;

import java.util.Scanner;

/**
 * @author sc
 * @date 2020/8/25
 **/
public class Question3UnAmendment {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 10];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int max = a[i];
            int min = a[i];
            for (int j = i; j < n; j++) {
                if (a[j] > max)
                    max = a[j];
                if (a[j] < min)
                    min = a[j];
                if (max - min == j - i) {
                    System.out.println(a[i] + " " + a[j]);
                    sum++;
                }

            }
        }
        System.out.println(sum);
    }
}
