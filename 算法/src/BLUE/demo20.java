package BLUE;

import java.util.Scanner;

/**
 * @author sc
 * @date 2020/8/23
 **/

//画表格

public class demo20 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int hang=scanner.nextInt(),lie=scanner.nextInt();
        for (int i = 0; i < hang; i++) {
            if(i==0){
                System.out.print("┌─");
                for (int j = 0; j < lie-1; j++) {
                    System.out.print("┬─");
                }
                System.out.println("┐");
                for (int j = 0; j < lie; j++) {
                    System.out.print("│ ");
                }
                System.out.println("│");
            }else {
                System.out.print("├─");
                for (int j = 0; j < lie-1; j++) {
                    System.out.print("┼─");
                }
                System.out.println("┤");

                for (int j = 0; j < lie; j++) {
                    System.out.print("│ ");
                }
                System.out.println("│");
            }
        }
        System.out.print("└─");
        for (int j = 0; j < lie-1; j++) {
            System.out.print("┴─");
        }
        System.out.println("┘");
    }
}
