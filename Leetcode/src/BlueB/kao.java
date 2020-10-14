package BlueB;

import java.util.Scanner;

/**
 * n个人参加某项特殊考试。
 * 　　为了公平，要求任何两个认识的人不能分在同一个考场。
 * 　　求是少需要分几个考场才能满足条件。
 * <p>
 * <p>
 * 初始版本可能因为先放一个人导致后面多人无法放入，所以应该用dfs
 * <p>
 * 对每一个学生实行放和不放两种策略
 */
public class kao {
    static boolean stu[][];
    static int kaochang[][] = new int[101][101];
    static int min = Integer.MAX_VALUE;
    static int n;
    static int m;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        stu = new boolean[n + 1][n + 1];
        m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            stu[a][b] = true;
            stu[b][a] = true;
        }

        dfs(1, 0);
        System.out.println(min);
    }

    private static void dfs(int id, int numK) {//id表示到第几号学生了，而numK是目前已使用考场数量
        if (numK > min) {
            return;
        }
        if (id > n) {
            min = Math.min(min, numK);
            return;
        }

        for (int i = 0; i < numK; i++) {//在每一个考场里面找
            int k = 0;
            while (kaochang[i][k] != 0) ;
        }

    }


//    static boolean[][] stu;
//    static int hangshu;
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        hangshu = n+1;
//        stu = new boolean[n+1][n+1];
//        int m = in.nextInt();
//        for (int i = 0; i < m; i++) {
//            int left = in.nextInt();
//            int right = in.nextInt();
//            stu[left][right] = true;
//            stu[right][left] = true;
//        }
//
//        List<List<Integer>> kaochang = new ArrayList<List<Integer>>();
//        List<Integer> temp1 = new ArrayList<>();
//        temp1.add(1);
//        kaochang.add(temp1);
//        for (int i = 2; i <= n; i++) {
//            boolean flag =false;//false是找不到考场，则在！flag情况下加
//            for (int j = 0; j < kaochang.size(); j++) {
//                List<Integer> temp = kaochang.get(j);
//                if (kaocontain(i,temp)){//如果能加进去这个考场
//                    flag = true;
////                    System.out.println("找到考场里");
//                    kaochang.remove(temp);
//                    temp.add(i);
//                    kaochang.add(temp);
//                    break;
//                }
//            }
//            //都找完了，加不进去
//            if (!flag){
////                System.out.println(i+"找不到合适考场");
//                List<Integer> temp = new ArrayList<>();
//                temp.add(i);
//                kaochang.add(temp);
//            }
//        }
//        System.out.println(kaochang.size());
//    }
//
//    private static boolean kaocontain(int i,List<Integer> temp) {
//        int len = temp.size();
//        for (int k = 0; k < len; k++) {
//            if (stu[i][temp.get(k)]){
//                return false;
//            }
//        }
//        return true;
//    }
//

}
