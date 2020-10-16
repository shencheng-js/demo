package liKou.medium;

/**
 * 二分查找
 */
public class erfen {
    public static void main(String[] args) {
        int[] temp = {1, 4, 5, 6, 33, 55, 444};
        System.out.println(find(temp, 1));

        for (int i = 0; i < 100; i++) {
            System.out.println("id:" + i + " " + Integer.lowestOneBit(i));
        }
    }

    private static int find(int[] temp, int i) {
        int left = 0;
        int right = temp.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if (temp[mid] == i) {
                return mid;
            } else if (temp[mid] > i) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
//            System.out.println("当前mid"+mid+right+left);
            mid = (left + right) / 2;
        }
        return -1;
    }
}
