package BLUE;

/**
 * @author sc
 * @date 2020/8/23
 **/
public class demo14 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 500000; i++) {
            sum+=dubo();
        }
        System.out.println(sum);
        double temp = sum/500000f;
        System.out.printf("%.3f",temp);


    }

    private static  int  dubo() {
        int temp1 = (int)(Math.random()*6+1);
        int temp2 = (int)(Math.random()*6+1);
        int temp3 = (int)(Math.random()*6+1);

        int key = (int) (Math.random() * 6 + 1);

        if (key == temp1 && temp1 == temp2 && temp2 == temp3){
            return -6;
        }
        else if ((key == temp1 &&key == temp2)||(key == temp1 &&key == temp3)||(key == temp3 &&key == temp2)){
            return -2;
        }
        else if (key == temp1 ||key == temp2 ||key == temp3 ){
            return -1;
        }
        else if (test(key,temp1,temp2,temp3)){
            return 0;
        }
        else {
            return 1;
        }

    }

    private static boolean test(int key, int temp1, int temp2, int temp3) {
        if (key*temp1 == temp2*temp3||key*temp2 == temp1*temp3||key*temp3 == temp2*temp1){
            return true;
        }
        else {
            return false;
        }
    }
}
