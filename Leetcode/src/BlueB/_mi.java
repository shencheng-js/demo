package BlueB;

import java.util.Stack;

public class _mi {

    public static void main(String[] args) {
        String temp1 = "01010101001011001001010110010110100100001000101010 \n" +
                "00001000100000101010010000100000001001100110100101 \n" +
                "01111011010010001000001101001011100011000000010000 \n" +
                "01000000001010100011010000101000001010101011001011 \n" +
                "00011111000000101000010010100010100000101100000000 \n" +
                "11001000110101000010101100011010011010101011110111 \n" +
                "00011011010101001001001010000001000101001110000000 \n" +
                "10100000101000100110101010111110011000010000111010 \n" +
                "00111000001010100001100010000001000101001100001001 \n" +
                "11000110100001110010001001010101010101010001101000 \n" +
                "00010000100100000101001010101110100010101010000101 \n" +
                "11100100101001001000010000010101010100100100010100\n" +
                "00000010000000101011001111010001100000101010100011 \n" +
                "10101010011100001000011000010110011110110100001000\n" +
                "10101010100001101010100101000010100000111011101001 \n" +
                "10000000101100010000101100101101001011100000000100\n" +
                "10101001000000010100100001000100000100011110101001 \n" +
                "00101001010101101001010100011010101101110000110101\n" +
                "11001010000100001100000010100101000001000111000010 \n" +
                "00001000110000110101101000000100101001001000011101\n" +
                "10100101000101000000001110110010110101101010100001\n" +
                "00101000010000110101010000100010001001000100010101 \n" +
                "10100001000110010001000010101001010101011111010010\n" +
                "00000100101000000110010100101001000001000000000010\n" +
                "11010000001001110111001001000011101001011011101000 \n" +
                "00000110100010001000100000001000011101000000110011\n" +
                "10101000101000100010001111100010101001010000001000\n" +
                "10000010100101001010110000000100101010001011101000 \n" +
                "00111100001000010000000110111000000001000000001011\n" +
                "10000001100111010111010001000110111010101101111000";


        int len = temp1.length();
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < len; i++) {
            if (temp1.charAt(i) - '0' == 0 || temp1.charAt(i) - '0' == 1)
                temp.append(temp1.charAt(i));
        }
        boolean migong[][] = new boolean[30][50];
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 50; j++) {
                int num = temp.charAt(i * 50 + j) - '0';
                if (num == 1) migong[i][j] = false;
                else migong[i][j] = true;
            }
        }

        int fang[][];
        fang = new int[][]{
                {0, 1},
                {-1, 0},
                {1, 0},
                {0, -1}
        };

        Stack<Integer> stack = new Stack<>();


//        System.out.println(stack.size());
    }

}