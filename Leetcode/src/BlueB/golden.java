package BlueB;

public class golden {
    public static void main(String[] args) {
        double count;
        System.out.println(dfs(0));
    }

    private static double dfs(int i) {
        if (i >= 100) {
            return 1;
        }
        return 1 / (1 + dfs(i + 1));
    }
}
