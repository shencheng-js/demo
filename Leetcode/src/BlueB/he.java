package BlueB;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class he {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] yuan = new int[m * n]; //一个并查集，数组内容为父节点
        for (int i = 0; i < yuan.length; i++) {
            yuan[i] = i;
        }
        int orderNum = in.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < orderNum; i++) {
            int left = in.nextInt();
            int right = in.nextInt();
            if (yuan[left] == left && yuan[right] == right) {
                yuan[left] = right;
            } else if (yuan[left] != left && yuan[right] == right) {
                //将left归到right下，及其父节点
                int leftRoot = find(yuan, left);
                yuan[leftRoot] = right;
            } else if (yuan[left] == left && yuan[right] != right) {
                int rightRoot = find(yuan, right);
                yuan[rightRoot] = left;
            } else {  //当两边都属于不同集合
                int leftRoot = find(yuan, left);
                int rightRoot = find(yuan, right);
                if (leftRoot != rightRoot) {
                    yuan[leftRoot] = rightRoot;
                }
            }
        }
        for (int i = 0; i < yuan.length; i++) {
            find(yuan, i);
        }
        for (int i = 0; i < yuan.length; i++) {
            set.add(yuan[i]);
        }
        System.out.println(set.size());
    }

    private static int find(int[] yuan, int x) {
        int temp, son;
        son = x;
        while (x != yuan[x]) {
            x = yuan[x];
        }
        while (son != x) {//更新路上所有的节点，直指祖先节点
            temp = yuan[son];
            yuan[son] = x;
            son = temp;
        }
        return x;
    }

}
