package liKou.medium;

/**
 * @auther {shen}
 * @DATE 2020-11-1
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 将wordDict 中的首字母和单词放进哈希表  不可行，有重复开头的会覆盖
 * 深度搜索  初始算法时间复杂度太高了
 * 动态规划  就是子问题，s能不能，就是取走一个单词后或者加上一个单词的做法
 */
public class _139 {
    public static void main(String[] args) {
        String temp = "leetcode";
        List<String> dic = new ArrayList<>();
        dic.add("leet");
        dic.add("code");


        System.out.println(new _139().wordBreak(temp, dic));
    }

//    List<String> dict = new ArrayList<>();
//
//    public boolean wordBreak(String s, List<String> wordDict) {
//        dict = wordDict;
//        return dfs(s);
//    }
//
//    private boolean dfs(String s) {
//        int len = s.length();
//        if (len == 0) {
//            return true;
//        }
//        boolean flag = false;
//        for (int i = 0; i < dict.size(); i++) {
//            String temp = dict.get(i);
//            if (s.startsWith(temp)) {
//                int tempLen = temp.length();
//                if (dfs(s.substring(tempLen))) {
//                    return true;
//                }
//            }
//        }
//        return false;
//
//    }


    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
