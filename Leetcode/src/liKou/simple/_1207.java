package liKou.simple;

/**
 * @auther {shen}
 * @DATE 2020-10-28
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 * 利用map只会保存最后一次送入的键值对的值
 */
public class _1207 {

//    public static void main(String[] args) {
//        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//        map.put(1,2);
//        map.put(1,3);
//        System.out.println(map.get(1));
//    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int now : arr) {
            map.put(now, map.getOrDefault(now, 0) + 1);//getordeafalut这个方法很好，适合于遍历改变的情况
        }
        Set<Integer> times = new HashSet<>();
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            times.add(x.getValue());
        }
        return map.size() == times.size();
    }
}
