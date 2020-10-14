package liKou.hard;

public class _allsort {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        int len = ints.length;
        dfs(ints, 0, len);
    }

    private static void dfs(int[] ints, int i, int target) {
        if (i >= target) {
            for (int k = 0; k < ints.length; k++) {
                System.out.print(ints[k] + " ");
            }
            System.out.println();
        }

        for (int k = i; k < target; k++) {
            swap(ints, i, k);
            dfs(ints, i + 1, target);
            swap(ints, i, k);
        }


    }

    private static void swap(int[] ints, int i, int k) {
//        System.out.println(ints[i]+"  "+ints[k]);
        int temp = ints[i];
        ints[i] = ints[k];
        ints[k] = temp;
    }

}
