package BLUE;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author sc
 * @date 2020/8/24
 **/
public class demo23 {

    static Set<String> lis1 = new HashSet<>();

    public static void main(String[] args) {
        //System.out.println("1234".replace());

        fun("123456789",1);
        print();
        System.out.println(lis1.size());
        System.out.println(Math.pow(3,8));
    }

    private static void print() {
        Iterator<String> iterator = lis1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }

    public static void fun(String v, int n) {
        if (n == 9) {    // 修改到最后一位符号时输出
            lis1.add(v);
        } else {    // 递归向后修改，数字 变为 数字加符号
            fun(v.replace(n + "", n + "+"), n + 1);
            fun(v.replace(n + "", n + "-"), n + 1);
            fun(v, n + 1);
        }
    }
}