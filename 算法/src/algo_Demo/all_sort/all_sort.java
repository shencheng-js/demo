package algo_Demo.all_sort;

import java.io.IOException;
import java.util.Vector;

public class all_sort {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Vector<Character> source = new Vector<Character>();
        Vector<Character> result = new Vector<Character>();

        String temp = "erda";
        char[] chars = temp.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            source.add(chars[i]);
        }


        //sort(source,result);
        //System.out.println(count);
        System.out.println("GOOD BYE~~~");
    }


    public static void sort(Vector source, Vector result) {
        if (source.size() == 0) {
            print(result);
            //count++;
        } else {
            for (int i = 0; i < source.size(); i++) {
                Vector<Character> tsource = new Vector<Character>(source);
                Vector<Character> tresult = new Vector<Character>(result);
                tresult.add(tsource.elementAt(i));
                tsource.remove(i);
                sort(tsource, tresult);
            }

        }
    }

    public static void print(Vector result) {
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < result.size(); i++) {
            temp.append(result.elementAt(i));
        }
//       System.out.println(temp);

        return;
    }

}
