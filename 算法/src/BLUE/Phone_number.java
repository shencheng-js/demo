package BLUE;

import java.util.Scanner;

/**
 * @author sc
 * @date 2020/8/20
 **/
//注意此范例中对于输入的处理，
    //大力出奇迹
    //通过string转char数组后将
    //chars[i] - '0';
    //妙！！！




/*
1. 如果出现连号，不管升序还是降序，都加5分。例如：5678,4321都满足加分标准。
        2. 前三个数字相同，或后三个数字相同，都加3分。例如：4888,6665,7777都满足加分的标准。
        注意：7777因为满足这条标准两次，所以这条规则给它加了6分。
        3. 符合AABB或者ABAB模式的加1分。例如：2255,3939,7777都符合这个模式，所以都被加分。
        注意：7777因为满足这条标准两次，所以这条标准给它加了2分。
        4. 含有：6，8，9中任何一个数字，每出现一次加1分。例如4326,6875,9918都符合加分标准。其中，6875被加2分；9918被加3分。
        尾号最终得分就是每条标准的加分总和！
        要求程序从标准输入接收数据，在标准输出上输出结果。
        输入格式为：第一行是一个整数n（<100），表示下边有多少输入行，接下来是n行4位一组的数据，就是等待计算加分的手机尾号。*/
public class Phone_number {
    // 输入数据
    public static void input(String[] n){
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while(i<n.length){
            n[i++] = scan.nextLine();
        }
    }
    // 得到分数
    public static int getGrade(String n){
        int s = 0;  // 总分
        char[] x = n.toCharArray();
        int a = x[0]-'0';
        int b = x[1]-'0';
        int c = x[2]-'0';
        int d = x[3]-'0';

        if(a+1==b&&b+1==c&&c+1==d||a-1==b&&b-1==c&&c-1==d){
            s += 5; // 1.出现连号 +5分
        }

        if(a==b&&b==c){
            s += 3; // 2.三个数字相同 (前三)+3分
        }
        if(b==c&&c==d){
            s += 3; // 2.三个数字相同 (后三)+3分
        }

        if(a==b&&c==d){
            s += 1; // 3.AABB模式 +1分
        }
        if(a==c&&b==d){
            s += 1; // 3.ABAB模式 +1分
        }

        if(a==6||a==8||a==9){
            s += 1; // 4.a含有：6 或 8 或 9  +1分
        }
        if(b==6||b==8||b==9){
            s += 1; // 4.b含有：6 或 8 或 9  +1分
        }
        if(c==6||c==8||c==9){
            s += 1; // 4.c含有：6 或 8 或 9  +1分
        }
        if(d==6||d==8||d==9){
            s += 1; // 4.d含有：6 或 8 或 9  +1分
        }
        return s;
    }
    //  取得每一行分数并输出
    public static void fun(String[] n){
        for(String x:n){
            System.out.println(getGrade(x));
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String[] n = new String[scan.nextInt()];
        input(n);   // 输入数据
        fun(n);
    }
}