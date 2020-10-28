package liKou.simple;


import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。
 * # 代表退格字符。
 * <p>
 * 利用栈
 */
public class _844 {

    public static void main(String[] args) {
        System.out.println(new _844().backspaceCompare("abcd", "bbcd"));
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<Character>();
        Stack<Character> t = new Stack<Character>();

        int lens = S.length();
        int lent = T.length();
        char temp;
        for (int i = 0; i < lens; i++) {
            temp = S.charAt(i);
            if (temp == '#') {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(temp);
            }
        }
        for (int i = 0; i < lent; i++) {
            temp = T.charAt(i);
            if (temp == '#') {
                if (!t.isEmpty()) {
                    t.pop();
                }
            } else {
                t.push(temp);
            }
        }

        if (s.size() != t.size()) {
            return false;
        }
//        System.out.println(s.size());
        int temps = s.size();
        for (int i = 0; i < temps; i++) {
            char ss = s.pop();
            char tt = t.pop();
//            System.out.println(ss+"  "+tt+"  "+i+"  "+s.size());
            if (ss != tt) {
                return false;
            }
        }
        return true;
    }
}
