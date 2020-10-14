package BlueB;

import java.util.Scanner;

public class jisuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOforder = in.nextInt();
        String input = in.nextLine();
        while (input.equals("CLEAR")) {
            calcul();
            input = in.nextLine();
        }
    }

    private static void calcul() {
        Scanner in = new Scanner(System.in);
        int jinzhi = 10;
        int nownum = 0;
        int tempnum;
        String nowstring = in.nextLine();
        while (nowstring.equals("EQUAL")) {

        }
    }
}
