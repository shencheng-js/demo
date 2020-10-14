package liKou.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 */
public class _1002 {
    public List<String> commonChars(String[] A) {
        int strLen = A.length;
        int[][] tong = new int[strLen][26];

        List<String> ret = new ArrayList<>();

        for (int i = 0; i < strLen; i++) {
            String temp = A[i];
            int len = temp.length();
            for (int j = 0; j < len; j++) {
                tong[i][temp.charAt(j) - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < strLen; j++) {
                min = Math.min(min, tong[j][i]);
            }
            for (int k = 0; k < min; k++) {
                ret.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ret;
    }
}
