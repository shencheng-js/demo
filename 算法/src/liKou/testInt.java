package liKou;

/**
 * @author sc
 * @date 2020/9/12
 **/
public class testInt {
    public static void main(String[] args) {
        int num = 0;
        int count = 1;
        while (true){
            if (num>count){
                System.out.println(num);
                System.out.println(count);
                break;
            }
            num++;
            count++;
        }
    }
}
