package BLUE;

/**
 * @author sc
 * @date 2020/8/23
 **/
public class demo17 {
    public static void main(String[] args) {
        microAdd(10,89,60);
        microAdd(10,90,60);
    }

    private static void microAdd(int x, int y, int m) {
        for(int i=1;i<=m;i++){
            y -= x;     // 吃掉x个y
            if(i%3==0) x *= 2;  // 每隔3分钟x分裂一次
            if(i%2==0) y *= 2;  // 每隔2分钟y分裂一次
        }
        System.out.println(y);
    }
}
