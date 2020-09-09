package DEMO;

/**
 * @author sc
 * @date 2020/8/28
 **/
public class dfs_1 {
    static int ans = 0;
    static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        dfs(1,0);
        System.out.println(ans);
    }

    private static void dfs(int start,int step) throws InterruptedException {

        if (start%2 == 0||step==19){
            if (start%2 == 0 ){
                System.out.println(start);
            }
            return;
        }
        System.out.println("当前count："+count+++"  "+start);
       // Thread.sleep(100);
        dfs(start*10,step+1);
        dfs(start*10+1,step+1);

    }
}
