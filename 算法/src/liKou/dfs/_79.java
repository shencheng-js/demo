package liKou.dfs;

/**
 * @author sc
 * @date 2020/9/13
 **/

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _79 {
    public static void main(String[] args) {
        char[][] temp = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String string = "ABCCEC";
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(new _79().exist(temp,string));
    }

    char[][] myBoard;
    char[] myWord;

    //利用dfs与回溯算法
    public boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        myBoard = board;
        myWord = word.toCharArray();
        boolean flag = false;

        System.out.println(h+" "+w);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                flag = dfs(i, j, visited, 0);
                if (flag) {
                    return flag;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, boolean[][] visited, int k) {
        if (myBoard[i][j] != myWord[k]) {
            return false;
        } else if (k == myWord.length - 1) {
            return true;
        }

        visited[i][j] = true;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean flag = false;
        //为何承载变量值的要在括号内声名？？？？
        for (int[] direction : directions) {
            int nowIndex = i + direction[0];
            int nowJdex = j + direction[1];

            if (nowIndex >= 0 && nowIndex < myBoard.length && nowJdex >= 0 && nowJdex < myBoard[0].length) {
                if (!visited[nowIndex][nowJdex]) {
                    flag = dfs(nowIndex, nowJdex, visited, k+1);
                    if (flag) {
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return flag;
    }
}
