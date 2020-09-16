package algo_Demo.interesting;

/**
 * @author sc
 * @date 2020/8/23
 **/

import java.util.Scanner;

/**
 * 计算至1949/10/1多少天   1.0版
 * 可扩展至计算任意两天间距离
 * 暂时认定前后顺序不出错，即一前一后
 *
 * 25894至今
 */

/**
 * #############事先确定方案可行性###################
 */


//有bug，当遇见闰年时计算天数差值会差一天
//四种情况，但是不想算了，可以直接利用Java的time计算


//新解决方案：年计算照旧
//月份及日计算其到年底要多少天后相减
public class dayToday {

    public static void main(String[] args) {
        String[] start = new String[3];
        String[] end = new String[3];

        start = scan();
        end = scan();

        System.out.println(calculate(start, end));

    }

    private static int calculate(String[] start, String[] end) {
        int[][]leap = {{31,29,31,30,31,30,31,31,30,31,30,31},
                {31,28,31,30,31,30,31,31,30,31,30,31}};
        boolean mflag = true;
        boolean dflag = true;

        int syear = Integer.parseInt(start[0]);
        int smonth = Integer.parseInt(start[1]);
        int sday = Integer.parseInt(start[2]);

        int eyear = Integer.parseInt(end[0]);
        int emonth = Integer.parseInt(end[1]);
        int eday = Integer.parseInt(end[2]);

        int count = 0;
        for (int i = syear; i < eyear; i++) {
            if (isLeap(i)){
                count +=366;
            }
            else {
                count +=365;
            }
        }

        int snum=0;
        int endnum=0;
        int flag = 1;
        if (isLeap(syear)){
            flag = 0;
        }
        for (int i = smonth; i < 12; i++) {
            snum+=leap[flag][i];
        }
        snum+=sday;
        if (isLeap(eyear)){
            flag = 0;
        }else {
            flag = 1;
        }
        for (int i = smonth; i < 12; i++) {
            endnum+=leap[flag][i];
        }
        endnum+=eday;

        System.out.println(endnum-snum);
        return count+(endnum-snum);
    }

    private static boolean isLeap(int i) {
        return i % 400 == 0 || (i % 4 == 0 && i % 100 != 0);
    }


    private static String[] scan() {
        Scanner in = new Scanner(System.in);
        String temp = in.nextLine();
        String [] temparray = new String[3];
        temparray = temp.split("-");
        return  temparray;
    }

}
