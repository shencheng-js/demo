package liKou.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther {shen}
 * @DATE 2020-10-29
 */
public class testlist {
    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(1);
        ans.add(2);
        ans.add(3);
        int result = 0;
        for (int i = 0; i < ans.size(); i++) {
            result *= 10;
            result += ans.get(i);

        }
        System.out.println(result);
    }
}
