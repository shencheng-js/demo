package liKou.simple;
/**
 * @auther {shen}
 * @DATE 2020-12-5
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many students?");
        int num = in.nextInt();
        List<String> names = new ArrayList<>();
        String temp = in.nextLine();
        System.out.println("Please input the names of students:");
        for (int i = 1; i <= num; i++) {
            temp = in.nextLine();
            names.add(temp);
        }
        System.out.println("All the students bellow:");
        for (int i = 0; i < num; i++) {
            System.out.println((i + 1) + ":" + names.get(i));
        }
    }
}
