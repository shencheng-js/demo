package liKou;

import java.util.Scanner;

/**
 * @author sc
 * @date 2020/9/12
 **/
public class 数数 {
    public static void main(String[] args) {
        System.out.println("This is 数数");
        Scanner in = new Scanner(System.in);
        while (true){
            int now = in.nextInt();
            System.out.println(calculateTree(now));
        }
    }

    private static int calculateTree(int n) {
        if(n==1)return 3;
        if (n==2)return 9;
        if (n==3)return 24;

        int n3 = 6;
        int n2 = 2;
        int temp = 0;
        for (int i = 4; i < n; i++) {
            temp = n3;
            n3 = 2*n3+2*n2;
            n2 = temp;
        }

        return 6*n2+9*n3;
    }

}
