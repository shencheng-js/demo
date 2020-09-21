package weekOne;

/*
 *   7/7非字典序全排列,可以存储下来,但是可以在n==N那里进行相应判断
 */
public class full_Array_A {

    public char[][] final_result;
    static int times = 0;

    public full_Array_A(int j, int i) {
        this.final_result = new char[j][i];
    }

    public void showinfo() {
        for (int i = 0; i < final_result.length; i++) {
            for (int j = 0; j < final_result[0].length; j++) {
                System.out.print(final_result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void mycheck(int n, int N, char[] a) {

        if (n == N) {
            writeresult(a);
        }

        for (int i = n; i < N; i++) {
            char temp = a[i];
            a[i] = a[n];
            a[n] = temp;
            mycheck(n + 1, N, a);
            temp = a[i];
            a[i] = a[n];
            a[n] = temp;
        }

    }

    public void writeresult(char[] a) {

        for (int j = 0; j < a.length; j++) {
            final_result[times][j] = a[j];
        }
        times++;
    }

    public static int factor(int i) {
        int re = 1;
        for (int j = 1; j <= i; j++) {
            re *= j;

        }
        return re;
    }

    public static void main(String[] args) {
        char[] mydata = {'q', 'w', 'e', 'r', 'z', 's', 'w'};
        full_Array_A qweA = new full_Array_A(factor(mydata.length), mydata.length);
        qweA.mycheck(0, mydata.length, mydata);
        qweA.showinfo();
    }
}
