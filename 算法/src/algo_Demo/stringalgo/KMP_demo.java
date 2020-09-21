package algo_Demo.stringalgo;

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
        int i = 0, k = -1;//k代表了最长前缀，而ret[]==-1代表此时无前缀
        ret[0] = -1;
        while (i < len - 1) {
            if (k == -1 || temp.charAt(i) == temp.charAt(k)) {
                i++;
                k++;
                if (temp.charAt(i) == temp.charAt(k))//当两个字符相同时，就跳过
                    ret[i] = ret[k];
                else//找不到最长，即为k==-1时
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
        while (i < s.length() && j < t.length()) {//i实际上是一直向前走的
            if (j == -1 || s.charAt(i) == t.charAt(j)) {//j==-1意味着无法找到最长前缀，两者都得前进
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
