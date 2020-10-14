package BlueB;

import java.util.HashSet;
import java.util.Set;

public class _10T2 {
    public static void main(String[] args) {
        String temp = "0100110001010001";

        int len = temp.length();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < len; i++) {//子串的末尾
            for (int j = 0; j <= i; j++) {
                String nowTemp = temp.substring(j, i + 1);
                System.out.println(nowTemp + "  当前j和i" + j + "   " + i);
                set.add(nowTemp);
            }
        }
        System.out.println(set.size());


    }
}
