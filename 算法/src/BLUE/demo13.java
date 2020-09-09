package BLUE;

import java.util.Scanner;

/**
 * @author sc
 * @date 2020/8/23
 **/

//用-1表示-
    //1表示该列不能有相同，而-1则是该行

    //注意读入使用string即可，再利用charat（）方法
public class demo13 {
    /*private static int[][][] keydata;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (true){
            String temp = in.next();
            System.out.print(temp+" ");
        }


        //scan();
        //print();
    }

    private static void print() {
        for (int i = 0; i < 2; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                for (int i2 = 0; i2 < 4; i2++) {
                    System.out.print(keydata[i][i1][i2]);
                }
                System.out.println();
            }
        }
    }

    private static void scan() {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        keydata = new int[num][3][4];
        for (int i = 0; i < num; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                for (int i2 = 0; i2 < 4; i2++) {

                    keydata[i][i1][i2] = in.nextInt();
                }
            }
        }
    }*/

    public static boolean isOk(char[][] state, int i, int j) {
        if (state[i][j] == '-') {
            for (int j2 = j + 1; j2 < 4; j2++) {
                if (state[i][j2] == '-') {
                    return false;
                } else if (state[i][j2] == '1') {
                    return true;
                }
            }
            for (int j2 = j - 1; j2 >= 0; j2--) {
                if (state[i][j2] == '-') {
                    return false;
                } else if (state[i][j2] == '1') {
                    return true;
                }
            }
        } else if (state[i][j] == '1') {
            for (int i2 = i + 1; i2 < 3; i2++) {
                if (state[i2][j] == '1') {
                    return false;
                } else if (state[i2][j] == '-') {
                    return true;
                }
            }
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (state[i2][j] == '1') {
                    return false;
                } else if (state[i2][j] == '-') {
                    return true;
                }
            }
        }
        return true;
    }
    private static void jasdklf(char[][] state) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (state[i][j] == '0') {
                    state[i][j] = '-';
                    if (isOk(state, i, j)) {
                        System.out.println(i + "" + j + '-');
                        return;
                    }
                    state[i][j] = '0';
                    state[i][j] = '1';
                    if (isOk(state, i, j)) {
                        System.out.println(i + "" + j + '1');
                        return;
                    }
                    state[i][j] = '0';
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        char[][] state = new char[3][4];
        String s;
        while ((n--) > 0) {
            for (int i = 0; i < 3; i++) {
                s = scanner.nextLine();
                for (int j = 0; j < 4; j++) {
                    state[i][j] = s.charAt(j);
                }
            }
            jasdklf(state);
        }
    }
}
