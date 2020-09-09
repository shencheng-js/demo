package BLUE;

/**
 * @author sc
 * @date 2020/8/24
 **/
public class demo22 {
    public static void exeForward(int question[],int index,int sum,int needSum) {
        if(index<=10){
            for (int i = 0; i <= 1; i++) {
                question[index]=i;
                int t=sum;
                if(i==0){
                    sum-=index;
                }else {
                    sum*=2;
                }
                exeForward(question, index+1, sum, needSum);
                question[index]=(i==1?0:1);
                sum=t;
            }
        }else {
            if(sum==needSum){
                for (int i = 1; i <= 10; i++) {
                    System.out.print(question[i]);
                }
                System.out.println();
                return;
            }else {
                return;
            }
        }

    }
    public static void main(String[] args) {
        int needSum=100;
        int question[]=new int[12];
        exeForward(question, 1, 10, 100);
    }
}
