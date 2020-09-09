package liKou;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sc
 * @date 2020/8/29
 **/
public class _214 {
}


class olution {
    public static void main(String[] args) {
        System.out.println(new olution().shortestPalindrome("abbacd"));
    }

    public String shortestPalindrome(String s) {
        if (s==null){
            return null;
        }
        int len = s.length();
        String one;
        String two;
        if (differentChar(s)) {
            return headaxis(s);
        }
        for (int i = 1; i < len; i++) {
            if (findSymmetrytwo(s,i)){
                two = headaxis(s.substring(i));
                System.out.println(two);
            }
            if (findSymmetry(s, i)) {
                one = headaxis(s.substring(i));
            }
        }
        return headaxis(s);
    }

    private boolean findSymmetrytwo(String temp,int index) {
        if ((index+1)<temp.length()&&temp.charAt(index) == temp.charAt(index-1)){
            return true;
        }
        return false;
    }

    private boolean differentChar(String temp) {
        Set<Character> judge = new HashSet<Character>();
        for (int i = 0; i < temp.length(); i++) {
            judge.add(temp.charAt(i));
        }
        if (judge.size() == temp.length()) return true;
        else return false;
    }

    private boolean findSymmetry(String temp, int index) {
        int left = index - 1;
        int right = index + 1;
        int len = temp.length();
        while (left > -1 && right < len) {
            if (temp.charAt(left) != temp.charAt(right)) return false;

            left--;
            right++;
        }
        if (left == -1) {
            return true;
        } else {
            return false;
        }
    }

    private static String headaxis(String temp) {
        StringBuffer ret = new StringBuffer();
        for (int i = temp.length() - 1; i > 0; i--) {
            ret.append(temp.charAt(i));
        }
        ret.append(temp);
        return ret.toString();
    }

}