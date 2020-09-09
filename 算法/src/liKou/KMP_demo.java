package liKou;

/**
 * @author sc
 * @date 2020/9/7
 **/
public class KMP_demo {
    public static void main(String[] args) {
        System.out.println(kmp("abdcdacbd", "bd"));
    }

    private static int[] find_pre(String temp) {
        int len = temp.length();
        int[] ret = new int[len];
        int i = 0, k = -1;
        ret[0] = -1;
        while (i < len - 1) {
            if (k == -1 || temp.charAt(i) == temp.charAt(k)) {
                i++;
                k++;
                if(temp.charAt(i) == temp.charAt(k))//当两个字符相同时，就跳过
                    ret[i] = ret[k];
                else
                    ret[i] = k;
            } else {
                k = ret[k];
            }
        }
        return ret;
    }

    private static int kmp(String s, String t) {//s为目标串，而t为模式串
        int[] back = find_pre(t);
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (j == -1 || s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j = back[j];
            }
        }
        if (j >= t.length()) {
            return i - t.length();
        } else {
            return -1;
        }
    }
}
