package liKou.medium;

/**
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 * 利用并查集，一个圈子的找一个头，利用一维数组表现相互关系
 * z注意这一题中不需要在使用并查集时规范其父节点，找连通块时只要找到头头就可以了，比如两个连通块各自头头相连时将其中一个 连到另一个上
 * 最后统计就只会有一个
 */
public class _547 {
    int[][] wet;
    boolean[] visited;

    public static void main(String[] args) {
        int[][] temp = new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        System.out.println(new _547().findCircleNum(temp));
    }

    public int findCircleNum(int[][] M) {
        wet = M;
        int len = M.length;
        visited = new boolean[len];

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i) {
        int len = wet.length;
        for (int j = 0; j < len; j++) {
            if (wet[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j);
            }
        }
    }


//采用了并查集的方法
//    public int findCircleNum(int[][] M) {
//        int len = M.length;
//        int[] stu = new int[len];
//        for (int i = 0; i < len; i++) {
//            stu[i] = i;//认识自己
//        }
//
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < i; j++) {
//                if (M[i][j] == 1) {//如果这两个人认识
//                    int fi = find(stu, i);
//                    int fj = find(stu, j);
//                    stu[fi] = fj;
//                }
//            }
//        }
//        int ret = 0;
//        for (int i = 0; i < len; i++) {
//            if (stu[i] == i) {
//                ret++;
//            }
//        }
//        return ret;
//    }
//
//    private int find(int[] stu, int i) {
//        while (stu[i] != i) {
//            i = stu[i];
//        }//最后i是i的祖宗
//        return i;
//    }

}
