package liKou.dfs;

import java.util.*;

/**
 * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。
 * <p>
 * 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。
 * <p>
 * 链接：https://leetcode-cn.com/problems/word-transformer-lcci
 * <p>
 * 1.
 * 测试数据：
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出:
 * ["hit","hot","dot","lot","log","cog"]
 * <p>
 * <p>
 * 2.
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: []
 * <p>
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * <p>
 * 关于找某些集合的dfs，想要正确终结可以在外面放一个ret，符合条件就将不断迭代的那个temp集合放进去，然后return
 * <p>
 * <p>
 * <p>
 * 而且做dfs不要怕用全局变量，全局很舒服
 */
public class _17_11 {
    String fin;
    List<String> ret;
    List<String> wordlist;
    List<String> temp;
    boolean[] visited;
    String endword;

    public static void main(String[] args) {
        List<String> te = new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(new _17_11().findLadders("hit", "cog", te));
    }

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        ret = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return ret;
        }
        fin = endWord;
        wordlist = wordList;
        visited = new boolean[wordList.size()];
        endword = endWord;
        temp = new ArrayList<>();
        dfs(beginWord);
//        ret = dfs(ret,wordList);
        return ret;
    }

    private void dfs(String str) {
//        System.out.println("找到"+str);
        temp.add(str);
        Queue<String> queue = contain(str);//找不到合适的在这里就烂尾了，这一支就断了，回去前一个，换一个str了
        for (String nowstr : queue) {
            if (nowstr.equals(endword)) {
                temp.add(endword);
                ret = new ArrayList<>(temp);
                return;
            }
            dfs(nowstr);
            temp.remove(temp.size() - 1);
        }
    }

    private Queue<String> contain(String str) {
        Queue<String> ret = new LinkedList<>();
        for (int i = 0; i < wordlist.size(); i++) {
            if (visited[i] || wordlist.get(i).length() != str.length()) continue;
            int err = 0;
            String strTemp = wordlist.get(i);
            for (int k = 0; k < strTemp.length(); k++) {
                if (str.charAt(k) != strTemp.charAt(k)) err++;
                if (err > 1) break;

            }
            if (err == 1) {
                ret.add(strTemp);
                visited[i] = true;
            }
        }
        return ret;
    }

//    private List<String> dfs(List<String> ret, List<String> wordList) {
//        if (wordList.get(wordList.size()-1).equals(fin)) return ret;
//        if (wordList.isEmpty())return null;
//        String last = ret.get(ret.size()-1);
//        int i = contain(wordList,last);
//        return null;
//    }
//
//    private int contain(List<String> wordList, String last) {
//        for (String temp:wordList){
//            int error = 0;
//            for (int i = 0; i < temp.length(); i++) {
//                if (temp.charAt(i)!=last.charAt(i)) error+=1;
//                if (i==temp.length()-1&&error==1) return wordList.indexOf(temp);
//            }
//        }
//        return -1;
//    }
}
