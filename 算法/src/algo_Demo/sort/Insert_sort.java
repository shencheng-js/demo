package algo_Demo.sort;


//插入排序
public class Insert_sort {
    int[] nums = {4, 3, 2, 1, 2, 5, 6, 3, 8};

    public void sort1() {
        int front;
        for (int i = 1; i < nums.length; i++) {
            front = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > front) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = front;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");

        }
    }

    public static void main(String[] args) {
        Insert_sort aInsert_sort = new Insert_sort();
        aInsert_sort.sort1();
    }
}
