package BLUE;

import java.util.Vector;

public class all_sort {
    static int  count = 0;
    public static void main(String[] args) {
        Vector<Character> source = new Vector<Character>();
        Vector<Character> result = new Vector<Character>();
        for (int i = 0; i < 10; i++) {
            source.add((char) (i+65));
        }
        sort(source,result);
        System.out.println(count);
    }


    public static void sort(Vector source,Vector result){
        if (source.size()==0){
            //print(result);
            count++;
        }
        else {
            for (int i = 0; i < source.size(); i++) {
                Vector<Character> tsource = new Vector<Character>(source);
                Vector<Character> tresult = new Vector<Character>(result);
                tresult.add(tsource.elementAt(i));
                tsource.remove(i);
                sort(tsource,tresult);
            }

        }
    }
    public static void print(Vector result) {
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.elementAt(i));
        }
        System.out.print("\n");
        return;
    }

}
