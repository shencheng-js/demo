package BLUE;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sc
 * @date 2020/8/20
 **/



/*看下面的算式：
        □□ x □□ = □□ x □□□
        它表示：两个两位数相乘等于一个两位数乘以一个三位数。
        如果没有限定条件，这样的例子很多。
        但目前的限定是：这9个方块，表示1~9的9个数字，不包含0。
        该算式中1至9的每个数字出现且只出现一次！
        比如：
        46 x 79 = 23 x 158
        54 x 69 = 27 x 138
        54 x 93 = 27 x 186
        .....
        请编程，输出所有可能的情况！
        注意：
        左边的两个乘数交换算同一方案，不要重复输出！
        不同方案的输出顺序不重要*/


public class Formula {

    static List<String> lis1 = new ArrayList<String>();//符合算式条件然重复的
    static List<String> lis2 = new ArrayList<String>();//不重复的，可直接输出
    // 输出
    public static void print(){
        for(String s:lis2){
            String a = s.substring(0,2);
            String b = s.substring(2,4);
            String c = s.substring(4,6);
            String d = s.substring(6);
            System.out.println(a+" x "+b+" = "+c+" x "+d);
        }
    }


    public static void main(String[] args) {
        int[] ints = new int[9];
        init(ints);
        arrays(ints,0,ints.length-1);
        quchong();
        print();
    }

    private static void quchong() {
        lis2.add(lis1.get(0));
        for (int i = 1; i < lis1.size(); i++) {
            String temp = lis1.get(i);
            if (myequal(temp)){
                lis2.add(temp);
            }
        }
    }

    private static boolean myequal(String temp) {
        String a1 = temp.substring(0,2);
        String a2 = temp.substring(2,4);

        for (int i = 0; i < lis2.size(); i++) {
            String temp1 =lis2.get(i);
            String b1 = temp1.substring(0,2);
            String b2 = temp1.substring(2,4);

            if (a1.equals(b2)&&a2.equals(b1))return false;
        }
        return true;
    }

    private static void arrays(int[] ints, int start, int end) {
        if (start>=end){
            put(ints);
        }
        else {
            for (int i = start;i<=end;i++){
                int n = ints[start];
                ints[start]=ints[i];
                ints[i] = n;
                arrays(ints,start+1,end);
                n = ints[start];
                ints[start]=ints[i];
                ints[i] = n;
            }
        }
    }

    private static void put(int[] ints) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < ints.length; i++) {
            buffer.append(ints[i]);
        }
        int a1 = Integer.parseInt(buffer.substring(0,2).toString());
        int a2 = Integer.parseInt(buffer.substring(2,4).toString());
        int a3 = Integer.parseInt(buffer.substring(4,6).toString());
        int a4 = Integer.parseInt(buffer.substring(6).toString());

        if (a1*a2==a3*a4){
            lis1.add(buffer.toString());
        }
    }

    private static void init(int[] ints) {
        for (int i = 0; i < 9; i++) {
            ints[i] = i+1;
        }
        return;
    }


}
