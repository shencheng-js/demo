package liKou.simple;

/**
 * @author sc
 * @date 2020/8/30
 **/
public class _557 {
    public static void main(String[] args) {
        System.out.println(new _557().reverseWord("s'teL ekat edoCteeL tsetnoc"));

    }
    public String reverseWords(String s) {
        if (s == null)return null;
        String[] word = s.split(" ");
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < word.length; i++) {
            ret.append(reverseWord(word[i]));
            if (i!=word.length-1) ret.append(" ");
        }
        return ret.toString();
    }

    private String reverseWord(String s) {
        StringBuffer ret = new StringBuffer();

        for (int length = s.length()-1; length >= 0; length--) {
            ret.append(s.charAt(length));
        }
        return ret.toString();
    }
}

