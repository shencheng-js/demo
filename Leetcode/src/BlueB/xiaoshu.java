package BlueB;

import java.util.Scanner;

public class xiaoshu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int m = in.nextInt();
        int wei = in.nextInt();
        double n = n1 * 1.0;
        double result = n / m;
        result *= Math.pow(10, wei);

        System.out.println(result);
    }
}
