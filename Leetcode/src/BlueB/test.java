package BlueB;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
////        int n1 = in.nextInt();
////        int n2 = in.nextInt();
////        System.out.println(Integer.parseInt("a0",36));
//        int[] temp = {1,2,3,4,4,3};
////        int []ret=Arrays.sort(temp);
//        Arrays.sort(temp);
//        int len = temp.length;
//        for (int i = 0; i < len; i++) {
//            System.out.print(temp[i]+"  ");
//        }

        List<Integer> list = new ArrayList<>();
        int len = 1000000;
        for (int i = 0; i < len; i++) {
            list.add(i);
        }
        for (int i = 1; i < len; i++) {
            if (i % 2 == 0) {
                list.remove(i);
            }
        }
        for (int i = 1; i < len; i++) {
            if (i % 2 == 0) {
                list.remove(i);
            }
        }
        for (int i = 1; i < len; i++) {
            if (i % i == 0) {
                list.remove(i);
            }
        }

    }
}
