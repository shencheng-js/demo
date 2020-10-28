package liKou.hard;

/**
 * @auther {shen}
 * @DATE 2020-11-1
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 139的进阶版本，139判断能不能用字典里的组成
 * 这个使用了回溯算法，dfs
 * <p>
 * 答案中用了set应该是字典中有重复元素，不过直接借用list也可以
 */
public class _140 {
    public static void main(String[] args) {
        String temp = "catsanddog";
        List<String> hah = new ArrayList<>();
        //cat","cats","and","sand","dog
        hah.add("cat");
        hah.add("cats");
        hah.add("and");
        hah.add("sand");
        hah.add("dog");

        List<String> templ = new _140().wordBreak(temp, hah);
        for (int i = 0; i < templ.size(); i++) {
            System.out.println(templ.get(i));
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        List<String> res = new ArrayList<String>();
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }


//        System.out.println(dp[len]);
        if (dp[len]) {
            Deque<String> path = new ArrayDeque<>();
            dfs(s, len, wordDict, dp, path, res);
            return res;
        }
        return res;
    }

    private void dfs(String s, int len, List<String> wordSet, boolean[] dp, Deque<String> path, List<String> res) {
        if (len == 0) {
            res.add(String.join(" ", path));
            return;
        }
//        System.out.println("???");
        for (int i = len - 1; i >= 0; i--) {
            String suffix = s.substring(i, len);
//            System.out.println(suffix+"  "+dp[i]);
            if (wordSet.contains(suffix) && dp[i]) {
                path.addFirst(suffix);
//                System.out.println(suffix);
                dfs(s, i, wordSet, dp, path, res);
                path.removeFirst();
            }
        }
    }
}
