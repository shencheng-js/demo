package algo_Demo.interesting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigInteger;

/**
 * @author sc
 * @date 2020/8/25
 **/

/**
 * 计算a+bi的n次方
 */
public class xushu_Pow {
    public static void main(String[] args) throws FileNotFoundException {
        BigInteger a = BigInteger.valueOf(2);
        BigInteger b = BigInteger.valueOf(3);
        BigInteger c = BigInteger.valueOf(2);
        BigInteger d = BigInteger.valueOf(3);

        System.out.println(d);
        for (int i = 1; i < 2; i++) {//计算i次方
            BigInteger A = a.multiply(c).subtract(b.multiply(d));
            BigInteger B = a.multiply(d).add(b.multiply(c));

            a = A;
            b = B;
        }

        File file = new File("E:\\fileTest\\result.txt");

        PrintStream ps = new PrintStream(file);
        PrintStream out = new PrintStream(System.out);

        System.setOut(ps);
        System.out.println(a+"+"+b+"i");



    }
}
