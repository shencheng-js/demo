package algo_Demo.horspool.Horspool;

import java.util.Scanner;

public class horspool {

    static int[] skip = new int[256];

    static void findskip(char[] a, int n) {
        for (int i = 0; i < 256; i++) {// 将256个字符位置初始化为整个字符串长度
            skip[i] = n;
        }
        for (int i = n - 2; i >= 0; i--) {// 找距离字符串结尾最近的长度
            if (skip[a[i]] == n) {// 确定还没赋过值
                skip[a[i]] = n - i - 1;
            }
        }
    }

    static int[] findpos(char[] a, char[] b) {
        int i = b.length;// 初始化要被查找的串的长度为查找串的长度。
        int j = i;// 查找串的长度。
        int time = 0;
        int[] pos = new int[10];
        while (i <= a.length) {
            boolean flag = true;
            char end1 = a[i - 1];// 保存目标串当前的最后一个字符
            for (int k = b.length - 1, z = i - 1; k >= 0; k--, z--) {
                if (b[k] != a[z]) {
                    i += skip[end1];
                    flag = false;
                    break;
                }
            }
            if (flag) {
                pos[time] = i - j;
                i += skip[end1];
                time++;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入主串:");
        String aimString = in.nextLine();
        System.out.println("请输入模式串:");
        String findString = in.nextLine();

        char[] aimchar = aimString.toCharArray();
        char[] findchar = findString.toCharArray();
        horspool.findskip(findchar, findString.length());

        int[] mypos = new int[10];
        mypos = horspool.findpos(aimchar, findchar);

        if (mypos[0] != 0) {//确定的确找到了位置
            for (int i = 0; i < mypos.length && mypos[i] != 0; i++) {
                System.out.println(findString + "在主串内第" + (i + 1) + "次出现在数组位" + mypos[i] + "处");
            }
        } else {
            System.out.println("未找到相应位置");
        }

    }

}
