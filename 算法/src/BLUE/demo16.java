package BLUE;

/**
 * @author sc
 * @date 2020/8/23
 **/
public class demo16 {
    static int count = 100;	// 执行100次退出
    public static void f(double x,double r){
        if(count<=0) return;
        x = x * (1 - x) * r;
        System.out.println(x);
        count--;
        f(x,r);
    }
    public static void main(String[] args){
        double x = 0.2;
        double r = 3.62;
        f(x,r);
        System.out.println("网络某某结论：虫口数目函数呈锯齿状变化，" +
                "虫口数目不存在连续两年增加和连续两年减少的情况。");
    }
}
