package BLUE;

/**
 * @author sc
 * @date 2020/8/23
 **/
public class demo21 {
    /*public static boolean isPrime(int x){
        for(int i=2; i<=x/2; i++){
            if(x%i==0) return false;//填空
        }
        return true;
    }
    // 是否是孪生素数
    public static int twinPrimeNum(int n){
        int sum = 0;
        for(int i=2; i<n; i++){
            if(isPrime(i) &&isPrime(i+2) && (i+2)<=n) sum++;//填空
        }

        return sum; // 返回个数
    }
    public static void main(String[] args){
        int n = 900000;
        long start = System.currentTimeMillis();

        System.out.println(twinPrimeNum(n));
        long end = System.currentTimeMillis();
        System.out.println("运行时间："+(end-start));
    }*/

/*
    public static void main(String[] args){
        double x = 1;
        double y = 1;
        int a = 1;
        int b = 3;

        while(y>1e-30){
            y =  y*a/b;
            x += y;
            a++;
            b += 2;
        }
        System.out.println(x*2);
    }*/



   /* public static void main(String[] args)
    {
        System.out.println("标准 " + Math.PI);
        double a = 1;
        int n = 6;
        for(int i=0; i<10; i++)
        {
            double b = Math.sqrt(1-(a/2)*(a/2));
            a = Math.sqrt((1-b)*(1-b) + (a/2)*(a/2));

            n = n*2; //填空

            System.out.println(n + "  " + n*a/2 );  // 填空
        }
    }*/


    public static void main(String[] args) {
        int person[]=new int[5];
        for (person[1] = 1;  person[1]<=20 ; person[1]++) {
            for (person[2] = 1;  person[2]<person[1] ; person[2]++){
                for (person[3] = 1;  person[3]<person[2] ; person[3]++){
                    for (person[4] = 1;  person[4]<person[3] ; person[4]++){
                        if ((1.0)/person[1]+(1.0)/person[2]+(1.0)/person[3]+(1.0)/person[4]==1) {
                            for (int i = 1; i <= 4; i++) {
                                System.out.print(person[i]);
                                if(i==4){
                                    System.out.println(",0");
                                }else {
                                    System.out.print(",");
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}