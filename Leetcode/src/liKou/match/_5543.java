package liKou.match;

public class _5543 {
    public static void main(String[] args) {
        System.out.println(new _5543().maxLengthBetweenEqualCharacters("asdfdgfgjhjfds"));
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int len = s.length();
        int ret = -1;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    ret = Math.max(ret, j - i - 1);
                }
            }
        }
        return ret;
    }
}
