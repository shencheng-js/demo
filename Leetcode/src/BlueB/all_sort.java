package BlueB;

public class all_sort {
    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 4};
        sort(temp, 0, temp.length);
    }

    private static void sort(int[] temp, int i, int length) {
        if (i >= length) {
            print(temp);
        }
        for (int j = i; j < length; j++) {
            swap(temp, j, i);
            sort(temp, i + 1, length);
            swap(temp, j, i);
        }

    }

    private static void swap(int[] temp, int j, int i) {
        int tempnum = temp[j];
        temp[j] = temp[i];
        temp[i] = tempnum;
    }

    private static void print(int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();
    }
}
