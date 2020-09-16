package algo_Demo.interesting;

import java.text.ParseException;
import java.util.Calendar;

/**
 * @author sc
 * @date 2020/8/23
 **/

/**
 * 计算两个日期间相差多少天
 */
public class demo19plus {
    public static void main(String[] args) throws ParseException {
        Calendar c1 = Calendar.getInstance();
        c1.set(2020, 8, 31);
        Calendar c2 = Calendar.getInstance();
        c2.set(2021, 2, 12);
        long t1 = c1.getTimeInMillis();
        long t2 = c2.getTimeInMillis();
        long days = (t2 - t1) / (24 * 60 * 60 * 1000);
        System.out.println(days);
    }
}
