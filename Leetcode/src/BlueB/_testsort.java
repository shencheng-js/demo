package BlueB;

import java.util.Arrays;
import java.util.Comparator;

public class _testsort {
    public static void main(String[] args) {
        int[][] temp = {
                {1, 2, 3},
                {3, 4, 5},
                {2, 3, 4}
        };
        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(temp[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
