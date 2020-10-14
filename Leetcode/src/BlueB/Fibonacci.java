package BlueB;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        final int size = 10007;
        int n1 = 1;
        int n2 = 1;
        int temp = 0;
        for (int i = 2; i < n; i++) {
            temp = n2 % size;
            n2 = (n1 % size + n2 % size) % size;
            n1 = temp;
        }
        System.out.println(n2);
    }
}
