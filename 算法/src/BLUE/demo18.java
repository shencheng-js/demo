package BLUE;

import java.util.Scanner;

/**
 * @author sc
 * @date 2020/8/23
 **/
public class demo18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String temp = in.nextLine();
        judege(temp);
    }

    private static void judege(String temp) {
        int len = temp.length();
        int odd = 0;
        int even =0;
        boolean flag = true;//表现当前是否为奇数位
        for (int i = len-1; i >= 0; i--) {
            int tempnum=(int)(temp.charAt(i)-'0');
            if (flag){
                odd+=tempnum;
                flag = !flag;
            }
            else {
                int finalnum = tempnum*2;
                if (finalnum>=10){
                    finalnum-=9;
                }
                even+=finalnum;
                flag = !flag;
            }
        }

        if ((even+odd)%10==0){
            System.out.println("成功");
        }else {
            System.out.println("失败"+(odd+even));
        }
        }
}
