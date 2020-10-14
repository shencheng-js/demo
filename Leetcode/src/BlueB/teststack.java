package BlueB;

import java.util.Stack;

public class teststack {
    public static void main(String[] args) {
        int fang[][];
        fang = new int[][]{
                {0, 1},
                {-1, 0},
                {1, 0},
                {0, -1}
        };

        Stack<int[]> stack = new Stack<>();

        stack.push(fang[0]);
        int[] ret = stack.pop();
        System.out.println(ret[1]);
    }
}
