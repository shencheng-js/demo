package liKou.dfs;


/**
 * 给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：
 * <p>
 * <p>
 * 管道图妙啊啊啊啊啊啊啊啊啊啊
 * fang[i][j]=k表示沿着i，j所在路线行走的方向及可行性
 * <p>
 * [[2,4,3],[6,5,2]] // true
 * 针对数组需要注意i与j，多做，留心
 * 针对迷宫地图类问题使用数组存储每次变化方向很方便
 */
public class _1391 {
    static int[][] fang = {
            {-1, -1, -1, -1},
            {-1, 1, -1, 3},
            {0, -1, 2, -1},
            {-1, 0, 3, -1},
            {-1, -1, 1, 0},
            {3, 2, -1, -1},
            {1, -1, -1, 2}
    };
    static int[] dx = {1, 0, -1, 0};//以下由上左顺序
    static int[] dy = {0, 1, 0, -1};//以下由上左顺序  0xia  1you 2shang 3zuo
    boolean visited[][];
    int[][] gri;
    int n;
    int m;

    public static void main(String[] args) {
        int[][] temp = {
//                {2,4,3},
//                {6,5,2}
                {1, 1, 1, 1, 2}
        };
        System.out.println(new _1391().hasValidPath(temp));
    }

    public boolean hasValidPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        gri = grid;
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            visited = new boolean[n][m];
            visited[0][0] = true;
            flag = dfs(0, 0, fang[grid[0][0]][i]);
            if (flag) return true;
        }
        return false;
    }

    private boolean dfs(int i, int j, int oreder) {
        if (i == n - 1 && j == m - 1) return true;
//        System.out.println("当前到达"+i+' '+j+" "+oreder);
        if (oreder == -1) return false;

        int nowi = i + dx[oreder];
        int nowj = j + dy[oreder];
//        System.out.println("当前到达"+nowi+' '+nowj);
//        System.out.println(visited[nowi][nowj]);
        if (nowi < 0 || nowj < 0 || nowi > n - 1 || nowj > m - 1 || visited[nowi][nowj]) return false;
//        System.out.println("sdas");
        int neworder = fang[gri[nowi][nowj]][oreder];
//        System.out.println(neworder);
        visited[nowi][nowj] = true;
        //你得看看人家接不接
        if (neworder != -1) {
            return dfs(nowi, nowj, neworder);
        }
        return false;

    }
}
