package liKou.test;

import java.util.Random;

public class study {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.print(random.nextInt(8) + "  ");
        }

    }
}
