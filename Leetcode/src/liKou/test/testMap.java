package liKou.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sc
 * @date 2020/10/3
 **/
public class testMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 2);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }
}
