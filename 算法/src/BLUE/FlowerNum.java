package BLUE;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author sc
 * @date 2020/8/20
 **/
public class FlowerNum {
    private static int num = 21;
    private static BigInteger[] table = new BigInteger[10];
    private static int[] nums;
    private static int[] a=new int[10];

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10; i++)
            table[i] = BigInteger.valueOf(i).pow(num);
        nums = new int[num];
        find(nums, 0, 0);
        //f();
        time = System.currentTimeMillis() - time;
        System.out.println(time / 1000.0 + "s");
    }
    /**
     * level表示第几位数，num表示第几位数的数字；
     */
    public static void find(int[] nums, int level, int num) {
        nums[level] = num;
        if (level == nums.length - 1) {
            BigInteger big = sum(nums);//当level为20时，表示nums数组下标为20即21位数字满后求和；
            int[] temp = getArray(big);//将得到的21位数和转化为整形数组；并返回；
            if (check(nums, temp))//测试是否是21位，并将数组复制给nums数组；
                System.out.println(big);//输出big数；
            return;
        }
        for (int i =num; i < 10; i++)//递归；查找21位数字符合条件的数；
            find(nums, level + 1, i);
    }
    /**
     * 检测长度，若符合条件就复制a2到a1；
     * @param a1
     * @param a2
     * @return
     */
    public static boolean check(int[] a1, int[] a2) {
        if (a1.length != a2.length)
            return false;
        //Arrays.sort(Arrays.copyOf(a1, a1.length));
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }
    /**
     * 得到nums数组的数做为table下标的数的和。并返回；
     * @param nums
     * @return
     */
    public static BigInteger sum(int[] nums) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < nums.length; i++)
            sum = sum.add(table[nums[i]]);
        return sum;
    }
    /**
     * 将BigInteger转化为int[]类型数据；
     * @param big
     * @return
     */
    public static int[] getArray(BigInteger big) {
        String s = String.valueOf(big);
        char[] ch = s.toCharArray();
        int[] res = new int[ch.length];
        for (int i = 0; i < ch.length; i++)
            res[i] = ch[i] - '0';
        return res;
    }

    public static void f(){
        for(a[0]=0;a[0]<=21;a[0]++){
            for(a[1]=0;a[1]<=21-a[0];a[1]++){
                for(a[2]=0;a[2]<=21-a[0]-a[1];a[2]++){
                    for(a[3]=0;a[3]<=21-a[0]-a[1]-a[2];a[3]++){
                        for(a[4]=0;a[4]<=21-a[0]-a[1]-a[2]-a[3];a[4]++){
                            for(a[5]=0;a[5]<=21-a[0]-a[1]-a[2]-a[3]-a[4];a[5]++){
                                for(a[6]=0;a[6]<=21-a[0]-a[1]-a[2]-a[3]-a[4]-a[5];a[6]++){
                                    for(a[7]=0;a[7]<=21-a[0]-a[1]-a[2]-a[3]-a[4]-a[5]-a[6];a[7]++){
                                        for(a[8]=0;a[8]<=21-a[0]-a[1]-a[2]-a[3]-a[4]-a[5]-a[6]-a[7];a[8]++){
                                            a[9]=21-a[0]-a[1]-a[2]-a[3]-a[4]-a[5]-a[6]-a[7]-a[8];
                                            BigInteger sum=BigInteger.ZERO;
                                            for(int i=0;i<10;i++){
                                                sum=sum.add(table[i].multiply(new BigInteger(String.valueOf(a[i]))));
                                            }
                                            if(String .valueOf(sum).length()==21){
                                                String str=sum.toString();
                                                int b[]=new int[10];
                                                for(int index=0;index<str.length();index++){
                                                    int flag=str.charAt(index)-'0';
                                                    b[flag]+=1;
                                                }
                                                boolean f=true;
                                                int i=0;
                                                for(;;){
                                                    if(i==10)break;
                                                    if(b[i]!=a[i]){f=false;break;}
                                                    i++;
                                                }
                                                if(f)System.out.println(sum.toString());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
