package algo_Demo.sort;

/**
 * @author sc
 * @date 2020/8/25
 **/

//归并排序
public class MergeSort {
    public static void main(String[] args) {
        int[] temp = {4, 3, 2, 1};

        temp = merge(temp, 0, temp.length - 1);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + "  ");
        }
    }

    private static int[] merge(int[] temp, int left, int right) {
        if (left>=right){
            return new int[]{temp[left]};
        }
        int mid = (left+right)/2;
        int []leftints = merge(temp,left,mid);
        int []rightints = merge(temp,mid+1,right);

        int []ret = new int[right - left + 1];
        int retindex = 0,leftindex = 0,rightindex = 0;

        while (leftindex<leftints.length&&rightindex<rightints.length){
            if (leftints[leftindex]<rightints[rightindex]){
                ret[retindex++] = leftints[leftindex++];

            }else {
                ret[retindex++] = rightints[rightindex++];
            }
        }
        while (leftindex<leftints.length){
            ret[retindex++] = leftints[leftindex++];
        }
        while (rightindex<rightints.length){
            ret[retindex++] = rightints[rightindex++];
        }
        return ret;
    }
}
