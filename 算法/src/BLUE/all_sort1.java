package BLUE;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sc
 * @date 2020/8/24
 **/
public class all_sort1 {
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] ints = {1, 2, 3,4,5,6,7,8,9};
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
            int a1 = temp[0]*10+temp[1];
            int a2 = temp[2]*100+temp[3]*10+temp[4];
            int b1 = temp[0]*100+temp[3]*10+temp[1];
            int b2 = temp[2]*10+temp[4];
            if (a1*a2==b1*b2){
                if (!result.contains(a1)){
                    System.out.println(a1+"*"+a2+"="+b1+"*"+b2);
                    result.add(a1);
                }

            }
          //  System.out.println();
        }

        for (int i = start; i < temp.length; i++) {
            swap(temp, i, start);

            mysort(temp, start + 1, target);

            swap(temp, i, start);

        }

    }
}
