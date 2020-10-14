package liKou.simple;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> ret = new ArrayList<>();
        ret.add(1);
        ret.add(2);
        ret.add(3);
        System.out.println(ret.indexOf(2));
        System.out.println(ret.indexOf(4));
    }
}
