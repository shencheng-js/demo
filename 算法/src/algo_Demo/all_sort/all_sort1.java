package algo_Demo.all_sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sc
 * @date 2020/8/24
 **/
public class all_sort1 {
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        mysort(ints, 0, ints.length);
    }

    public static void swap(int[] arr, int i, int j) {
        // 交换函数
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void mysort(int[] temp, int start, int target) {
        if (start == target) {
            //  System.out.println();
        }

        for (int i = start; i < temp.length; i++) {
            swap(temp, i, start);

            mysort(temp, start + 1, target);

            swap(temp, i, start);

        }

    }
}
